package org.hyperskill.componentvsbean;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class ComponentVsBeanApplication {

    public static void main(String[] args) {
        SpringApplication.run(ComponentVsBeanApplication.class, args);
    }

    @Bean
    CommandLineRunner commandLineRunner() {
        return args -> {
            System.out.println("Hello, 👋");
        };
    }
}
