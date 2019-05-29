package org.newit.microservice.springMVCdemo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration;

/**
 * Created by Administrator on 2019-05-28.
 */

public class SpringMVCInitializer implements WebApplicationInitializer {
    private static final Logger logger = LoggerFactory.getLogger(SpringMVCInitializer.class);

    public void onStartup(ServletContext servletContext) throws ServletException {
        logger.info("WebInitializer started~~~~~~~");
        //基于Java的配置类加载Spring的应用上下文建立spring容器
        AnnotationConfigWebApplicationContext ctx = new AnnotationConfigWebApplicationContext();
        ctx.register(MyConfig.class);
        ctx.setServletContext(servletContext);

        ServletRegistration.Dynamic servlet = servletContext.addServlet("dispatcher",new DispatcherServlet(ctx));

        servlet.addMapping("/");
        servlet.setLoadOnStartup(1);


    }
}
