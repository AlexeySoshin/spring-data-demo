package me.soshin.springdatademo;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * This class is needed to register our handlers
 */
@Configuration
public class RepositoryConfiguration {

    @Bean
    CustomerEventHandler customerEventHandler() {
        return new CustomerEventHandler();
    }
}
