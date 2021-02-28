package ru.ruslan.config;

import feign.Feign;
import feign.jackson.JacksonDecoder;
import feign.jackson.JacksonEncoder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {

    @Bean
    public Feign.Builder client() {
        return Feign.builder()
            .encoder(new  JacksonEncoder())
            .decoder(new JacksonDecoder());
    }
}
