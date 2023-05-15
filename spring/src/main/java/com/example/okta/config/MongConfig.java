package com.example.okta.config;

import com.example.okta.auditable.AuditorAwareImpl;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.domain.AuditorAware;
import org.springframework.data.mongodb.config.EnableMongoAuditing;

@Configuration
@EnableMongoAuditing(auditorAwareRef = "auditorProvider")
public class MongConfig {
    @Bean
    AuditorAware<String>auditorProvider(){
        return new AuditorAwareImpl();

    }
}
