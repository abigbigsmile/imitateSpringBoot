package com.smile;


import org.apache.catalina.WebResourceRoot;
import org.apache.catalina.core.StandardContext;
import org.apache.catalina.startup.Tomcat;
import org.apache.catalina.webresources.DirResourceSet;
import org.apache.catalina.webresources.StandardRoot;

import java.io.File;

public class Application {

    private static final int PORT = 8080;

    public static void main(String[] args) throws Exception{
        run();
    }

    private static void run() throws Exception{
        //创建Tomcat服务器
        Tomcat tomcatServer = new Tomcat();
        //绑定端口号
        tomcatServer.setPort(PORT);
        //读取项目路径，加载静态资源 我这里加上了项目名，你们要注意下是否需要加，我是idea 下面贴出目录结构，
        StandardContext sdc = (StandardContext) tomcatServer.addWebapp("/", new File("src/main").getAbsolutePath());
        //禁止重新载入
        sdc.setReloadable(false);
        //读取class文件位置
        File classFile = new File("target/classes");
        //创建webroot
        WebResourceRoot resource = new StandardRoot(sdc);
        //tomcat读取class文件执行（创建虚拟的文件目录）
        resource.addPreResources(new DirResourceSet(resource,"/WEB-INF/classes",classFile.getAbsolutePath(),"/"));
        //启动
        tomcatServer.start();
        System.out.println("启动Tomcat成功");
        //异步进行接收请求
        tomcatServer.getServer().await();

    }
}
