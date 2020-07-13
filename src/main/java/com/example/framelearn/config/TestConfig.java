package com.example.framelearn.config;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;

/**
 *
 *
 *
 * @author jt
 * @date 2020-5-18
 */

@Configuration
public class TestConfig {




    /**
     *
     *
     * 可以注入factory,environment
     */
    @Bean
    public Object test(BeanFactory factory, Environment environment, ApplicationContext context){
        String applicationName = context.getApplicationName();
        System.out.println("context:"+applicationName);
        String property = environment.getProperty("spring.application.name");
        System.out.println(property+"================");
        return null;
    }
}
