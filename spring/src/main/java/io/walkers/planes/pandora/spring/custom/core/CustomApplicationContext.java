package io.walkers.planes.pandora.spring.custom.core;

import io.walkers.planes.pandora.spring.custom.core.annotation.CustomComponent;
import io.walkers.planes.pandora.spring.custom.core.annotation.CustomComponentScan;
import io.walkers.planes.pandora.spring.custom.core.annotation.CustomScope;

import java.io.File;
import java.lang.reflect.InvocationTargetException;
import java.net.URL;
import java.util.concurrent.ConcurrentHashMap;

/**
 * 自定义的 Spring 容器
 *
 * @author planeswalker23
 */
public class CustomApplicationContext {

    private Class configClass;

    // 单例池
    private ConcurrentHashMap<String, Object> singletonObjects = new ConcurrentHashMap<>();
    // Bean定义
    private ConcurrentHashMap<String, CustomBeanDefinition> beanDefinitionMap = new ConcurrentHashMap<>();

    public CustomApplicationContext(Class configClass) throws ClassNotFoundException, InvocationTargetException, NoSuchMethodException, InstantiationException, IllegalAccessException {
        this.configClass = configClass;

        // 解析配置类：ComponentScan 注解 -> 获取扫描路径 -> 扫描 -> 注册 BeanDefinition
        this.scan(configClass);

        // 创建并注册单例 Bean
        for (CustomBeanDefinition beanDefinition : beanDefinitionMap.values()) {
            if (BeanScope.SINGLETON.equals(beanDefinition.getScope())) {
                Object bean = this.createBean(beanDefinition);
                singletonObjects.put(beanDefinition.getBeanName(), bean);
            }
        }
    }

    public Object getBean(String beanName) throws InvocationTargetException, NoSuchMethodException, InstantiationException, IllegalAccessException {
        if (beanDefinitionMap.containsKey(beanName)) {
            CustomBeanDefinition customBeanDefinition = beanDefinitionMap.get(beanName);
            if (BeanScope.SINGLETON.equals(customBeanDefinition.getScope())) {
                Object bean = singletonObjects.get(beanName);
                return bean;
            } else {
                Object bean = this.createBean(customBeanDefinition);
                return bean;
            }
        } else {
            throw new RuntimeException("Bean 不存在");
        }
    }

    private void scan(Class configClass) throws ClassNotFoundException {
        // ComponentScan 注解 -> 获取扫描路径 -> 扫描 -> 注册 BeanDefinition
        CustomComponentScan customComponentScan = (CustomComponentScan) configClass.getDeclaredAnnotation(CustomComponentScan.class);

        // 获取扫描路径
        String path = customComponentScan.value();
        System.out.println("@CustomComponentScan 配置的扫描路径是: " + path);
        String resourcePath = this.classPath2ResourcePath(path);

        // 执行扫描逻辑
        ClassLoader classLoader = CustomApplicationContext.class.getClassLoader();
        // 获取资源
        URL resource = classLoader.getResource(resourcePath);
        assert resource != null;
        File file = new File(resource.getFile());
        if (file.isDirectory()) {
            File[] files = file.listFiles();
            // 遍历文件夹
            // TODO 后续需要考虑文件夹下还有文件夹的情况
            for (File fileTarget : files) {
                System.out.println("资源文件内容:" + fileTarget);
                // 获取类全限定路径名，然后加载类
                String className = this.absolutePath2ClassPath(fileTarget.getAbsolutePath());
                Class<?> clazz = classLoader.loadClass(className);
                // 判断类是否被标记为 Spring Bean
                if (clazz.isAnnotationPresent(CustomComponent.class)) {
                    System.out.println("类 " + clazz.getName() + " 已被注解 @CustomComponent 标记");
                    // 解析注解生成 BeanDefinition
                    CustomBeanDefinition customBeanDefinition = new CustomBeanDefinition();
                    customBeanDefinition.setClazz(clazz);
                    // bean 名称
                    CustomComponent customComponentAnnotation = clazz.getDeclaredAnnotation(CustomComponent.class);
                    String beanName = customComponentAnnotation.value();
                    customBeanDefinition.setBeanName(beanName);
                    // bean 作用域
                    if (clazz.isAnnotationPresent(CustomScope.class)) {
                        CustomScope customScopeAnnotation = clazz.getDeclaredAnnotation(CustomScope.class);
                        customBeanDefinition.setScope(customScopeAnnotation.value());
                    } else {
                        customBeanDefinition.setScope(BeanScope.SINGLETON);
                    }
                    beanDefinitionMap.put(beanName, customBeanDefinition);

                }
            }
        }
    }

    private String absolutePath2ClassPath(String target) {
        if (target == null || target.length() == 0) {
            return target;
        }
        // TODO 转化方法更具拓展性
        String className = target.substring(target.indexOf("io"), target.indexOf(".class"));
        className = className.replace(File.separatorChar, '.');
        System.out.println("原字符串 " + target + " 已转化为 " + className);
        return className;
    }

    private String classPath2ResourcePath(String target) {
        if (target == null || target.length() == 0) {
            return target;
        }
        String resourceName = target.replace('.', File.separatorChar);
        System.out.println("原字符串 " + target + " 已转化为 " + resourceName);
        return resourceName;
    }

    private Object createBean(CustomBeanDefinition beanDefinition) throws NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException {
        Class clazz = beanDefinition.getClazz();
        Object instance = clazz.getDeclaredConstructor().newInstance();
        return instance;
    }
}
