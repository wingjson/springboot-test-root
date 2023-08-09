package com.zja;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

/**
 * @swagger3: <a href="http://localhost:8080/swagger-ui/index.html">...</a>
 * @author: zhengja
 * @since: 2023/06/14 15:57
 */
@SpringBootApplication
public class DesignPatternsTaskApplication extends SpringBootServletInitializer {

    public static void main(String[] args) {
        SpringApplication.run(DesignPatternsTaskApplication.class, args);
    }

    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
        return application.sources(DesignPatternsTaskApplication.class);
    }
}