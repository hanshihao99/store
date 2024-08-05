package com.cy.store_;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.File;

@SpringBootApplication
@MapperScan("com.cy.store_.mapper")
public class StoreApplication {



    public static void main(String[] args) {
        // 设置日志目录环境变量
        String logDir1 = "/Users/hanshihao/logs/store/log";
        String logDir2 = "/Users/hee/software/logs/store/log";

        if (new File(logDir1).exists()) {
            System.setProperty("LOG_DIR", logDir1);
        } else {
            System.setProperty("LOG_DIR", logDir2);
        }
        SpringApplication.run(StoreApplication.class, args);
    }

}
