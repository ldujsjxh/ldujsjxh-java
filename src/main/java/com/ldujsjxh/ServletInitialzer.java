package com.ldujsjxh;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

public class ServletInitialzer extends SpringBootServletInitializer {

    //创建日志
    private static Logger logger= LogManager.getLogger(StartApp.class);

    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
        logger.info("外部tomcat启动!");
        return application.sources(StartApp.class);
    }
}
