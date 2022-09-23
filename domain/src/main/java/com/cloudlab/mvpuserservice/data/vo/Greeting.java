package com.cloudlab.mvpuserservice.data.vo;

import lombok.Data;
import lombok.ToString;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;

@Configuration
@Data
@ToString
public class Greeting {

    @Lazy
    @Bean(name = "greetingMessage")
    String greetingMessage(@Value("${greeting.message}") String greetingMessage) {
        return greetingMessage;
    }

//    @Value("${greeting.message}")
//    private String message;

//    @Value("${db.user}")
//    private String userVal;
//
//    @Value("${db.password}")
//    private String passwordVal;

}
