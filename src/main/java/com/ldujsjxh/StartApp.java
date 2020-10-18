package com.ldujsjxh;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.ldujsjxh.mapper")
public class StartApp {

    //创建日志
    private static Logger logger= LogManager.getLogger(StartApp.class);
    public static void main(String[] args) {
        logger.info("system\t\t启动应用");
        SpringApplication.run(StartApp.class, args);

        
    }
}
