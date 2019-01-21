package com.example.data.druid.config;

import com.alibaba.druid.pool.DruidDataSource;
import com.alibaba.druid.support.http.StatViewServlet;
import com.alibaba.druid.support.http.WebStatFilter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;
import java.util.*;


/**
 * @Description: 使用druid数据源
 * @Author: WenChangSheng
 * @Date: Created in 2019/1/21 10:06
 */
@Configuration
public class DruidConfig {

    @ConfigurationProperties(prefix = "spring.datasource")
    @Bean
    public DataSource druidSource() {
        return new DruidDataSource();
    }

    /**
     * 1.配置druid监控后台
     */
    @Bean
    public ServletRegistrationBean<StatViewServlet> statViewServlet() {
        ServletRegistrationBean<StatViewServlet> servletRegistrationBean = new ServletRegistrationBean<>(new StatViewServlet(), "/druid/*");
        Map<String, String> initMap = new HashMap<>();
        initMap.put("loginUserName", "admin");
        initMap.put("loginPassword", "123456");
        //默认允许所有访问
        initMap.put("allow", "");
        //拒绝某个ip的访问
        initMap.put("deny", "123.213.123.12");
        servletRegistrationBean.setInitParameters(initMap);
        return servletRegistrationBean;
    }

    /**
     * 2.配置一个web监控的filter
     */
    @Bean
    public FilterRegistrationBean<WebStatFilter> webStatFilter() {
        FilterRegistrationBean<WebStatFilter> filterRegistrationBean = new FilterRegistrationBean<>();
        filterRegistrationBean.setFilter(new WebStatFilter());
        Map<String, String> initMap = new HashMap<>();
        initMap.put("exclusions", "*.js,*.css,/druid/*");
        filterRegistrationBean.setInitParameters(initMap);
        filterRegistrationBean.setUrlPatterns(Collections.singletonList("/*"));
        return filterRegistrationBean;
    }
}
