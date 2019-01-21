package com.example.data.druid.config;

import org.mybatis.spring.boot.autoconfigure.ConfigurationCustomizer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @Description:
 * @Author: WenChangSheng
 * @Date: Created in 2019/1/21 10:55
 */
@Configuration
public class MyBatisConfig {
    @Bean
    public ConfigurationCustomizer myBatisConfigurationCustomizer() {
        return configuration -> configuration.setMapUnderscoreToCamelCase(true);
    }
}
