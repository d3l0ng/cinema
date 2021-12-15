package com.longosz.cinema.config;

import feign.Retryer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class FeignClientConfig {

    @Bean
    public Retryer retryer() {
        int period = 100;
        int maxPeriod = 2000;
        int maxAttempts = 3;

        return new Retryer.Default(period, maxPeriod, maxAttempts); // TODO tune it / backoff etc.
    }
}
