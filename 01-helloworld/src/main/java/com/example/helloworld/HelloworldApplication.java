package com.example.helloworld;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @SpringBootApplication中包含了许多注解,其中:
 *      @SpringBootConfiguration 表明这是一个spring boot的配置类
 *      @EnableAutoConfiguration 开启自动配置功能：
 *             @AutoConfigurationPackage 自动配置包，将主配置类（@SpringBootApplication标注的类）的所在包及下面所有子包里面的所有组件扫描到Spring容器中
 *             @Import({AutoConfigurationImportSelector.class}) 会导入许多自动配置类，spring boot能够省去许多配置，就是因为这些自动配置类的存在
 *             Spring Boot在启动的时候从类路径下的META-INF/spring.factories中获取EnableAutoConfiguration指定的值，将这些值作为自动配置类导入到容器中，
 *            自动配置类就生效，帮我们进行自动配置工作；
 */
@SpringBootApplication
public class HelloworldApplication {

    public static void main(String[] args) {
        SpringApplication.run(HelloworldApplication.class, args);
    }

}

