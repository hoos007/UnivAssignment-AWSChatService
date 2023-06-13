package com.hoos007.project.onlinekaraoke;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

@SpringBootApplication
public class OnlinekaraokeApplication extends SpringBootServletInitializer {

    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
        return application.sources(OnlinekaraokeApplication.class);
    }

    public static void main(String[] args) {
        SpringApplication.run(OnlinekaraokeApplication.class, args);
    }

}
