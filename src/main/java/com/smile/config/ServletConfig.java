package com.smile.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

import javax.servlet.ServletContext;

@Configuration
@ComponentScan(basePackages = {"com.smile.controller"})
//@EnableWebMvc   //用于启用MVC Java config，相当于继承WebMvcConfigurationSupport
public class ServletConfig extends WebMvcConfigurationSupport {

    @Bean
    public ViewResolver viewResolver(){
        InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();
        viewResolver.setPrefix("/webapp/WEB-INF/jsp/");
        viewResolver.setSuffix(".jsp");
        //设置可以在jsp中通过${}访问beans
        viewResolver.setExposeContextBeansAsAttributes(true);
        return viewResolver;
    }
}
