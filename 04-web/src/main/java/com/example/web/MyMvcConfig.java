package com.example.web;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * @Description: spring boot已经帮我们默认配置好了spring mvc,继承WebMvcConfigurerAdapter可以扩展spring mvc功能，
 * 如果加上@EnableWebMvc注解则会完全替代spring boot中的spring mvc配置。
 * <p>
 * But it doesn't work when I visit localhost:8080/web. It return a 404 page. But I do put success.html under templates folder.
 * @Author: WenChangSheng
 * @Date: Created in 2019/1/21 9:09
 */
@Configuration
public class MyMvcConfig implements WebMvcConfigurer {

    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        //浏览器发送 /web 请求来到 success
        registry.addViewController("/web").setViewName("success");
    }

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new MyHandlerInterceptor()).addPathPatterns("/**");
    }
}
