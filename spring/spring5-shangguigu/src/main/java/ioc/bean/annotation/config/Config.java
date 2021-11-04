package ioc.bean.annotation.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * 配置类替代 XML
 *
 * @author planeswalker23
 * @date 2021/11/4
 */
@Configuration
@ComponentScan(basePackages = {"ioc"})
public class Config {


}
