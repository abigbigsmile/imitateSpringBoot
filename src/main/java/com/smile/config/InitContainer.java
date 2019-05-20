package com.smile.config;

//初始化Spring、SpringMVC容器：加载Spring容器配置文件RootConfig.class、SpringMVC容器配置文件ServletConfig.class

import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

public class InitContainer extends AbstractAnnotationConfigDispatcherServletInitializer {

    //加载spring容器配置信息
    @Override
    protected Class<?>[] getRootConfigClasses() {
        return new Class[]{RootConfig.class};
    }

    //加载springMVC配置信息
    @Override
    protected Class<?>[] getServletConfigClasses() {
        return new Class[]{ServletConfig.class};
    }

    //springmvc映射 拦截url所有请求
    @Override
    protected String[] getServletMappings() {
        return new String[]{"/"};
    }
}
