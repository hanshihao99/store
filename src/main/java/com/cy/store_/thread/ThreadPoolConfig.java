package com.cy.store_.thread;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

/**
 * @Description:
 * @Auther: hanshihao
 * @Date: 2023/10/30/23:02
 */
@Configuration
public class ThreadPoolConfig {

    @Bean
    public ThreadPoolTaskExecutor threadPoolTaskExecutor() {
        ThreadPoolTaskExecutor executor = new ThreadPoolTaskExecutor();
        // 无需显式设置线程池属性
        executor.setThreadNamePrefix("ThreadPool-");
        executor.initialize();
        return executor;
    }
}