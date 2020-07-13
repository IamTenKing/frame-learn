package com.example.framelearn.spring.event;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

/**
 * @author jt
 * @date 2020-6-7
 */
public class TestConfig extends WebMvcConfigurationSupport {

    public TestConfig() {
        System.out.println("hello =========================================");
    }
}
