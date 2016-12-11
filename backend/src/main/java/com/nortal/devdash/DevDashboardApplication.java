package com.nortal.devdash;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Import;

import com.nortal.devdash.config.SwaggerConfig;

@SpringBootApplication
@Import({ SwaggerConfig.class })
public class DevDashboardApplication {

    public static void main(String[] args) {
        SpringApplication.run(DevDashboardApplication.class, args);
    }
}
