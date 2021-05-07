package io.walkers.planes.pandora.mybatis.quickstart;

import io.walkers.planes.pandora.mybatis.common.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * MyBatis demo: configuration priority of properties
 *
 * @author planeswalker23
 */
public class MyBatisConfigurationPriorityOfPropertiesDemo {

    public static void main(String[] args) throws IOException {
        // 加载配置文件
        String resource = "quickstart/quickstart-mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        // 配置文件属性（properties）优先级：优先级最高
        Properties properties = new Properties();
        properties.setProperty("password", "password");
        // 基于构建者模式构建 SqlSessionFactory 对象，传入 Properties
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream, properties);
        // 基于工厂模式构建 SqlSession 对象，执行查询方法
        SqlSession sqlSession = sqlSessionFactory.openSession();
        User user = sqlSession.selectOne("io.walkers.planes.pandora.mybatis.common.UserMapper.selectUserById", 1);
        System.out.println("MyBatisConfigurationPriorityOfPropertiesDemo result: " + user);
    }
}
