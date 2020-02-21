package com.example.mastermind;

import com.example.mastermind.config.AppConfig;
import com.example.mastermind.config.StaticResourceConfiguration;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Import;

@SpringBootApplication
@Import({
        AppConfig.class,
        StaticResourceConfiguration.class
})
public class MastermindBootApplication {

    public static void main(String[] args) {
        SpringApplication.run(MastermindBootApplication.class, args);
    }
}
