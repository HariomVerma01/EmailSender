package com.example.EmailSender.AsyncConfig;

import java.util.concurrent.Executor;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

@Configuration
@EnableAsync
public class AsyncConfig {

    @Bean(name = "mailExecutor")
    public Executor mailExecutor() {

        ThreadPoolTaskExecutor executor = new ThreadPoolTaskExecutor();
        executor.setCorePoolSize(5);      // minimum threads
        executor.setMaxPoolSize(10);      // maximum threads
        executor.setQueueCapacity(100);
        executor.setThreadNamePrefix("Mail-Thread-");
        executor.initialize();

        return executor;
    }
}
