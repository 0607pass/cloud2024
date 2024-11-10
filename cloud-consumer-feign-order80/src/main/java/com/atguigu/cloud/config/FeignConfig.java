package com.atguigu.cloud.config;

import feign.Logger;
import feign.Retryer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class FeignConfig {

    @Bean
    public Retryer retryer(){
//        return new Retryer.Default(100,1,3);
        return Retryer.NEVER_RETRY;
    }
    @Bean
    public Logger.Level level(){
        return Logger.Level.FULL;
    }
}
