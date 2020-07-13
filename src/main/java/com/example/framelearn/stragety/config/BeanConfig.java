package com.example.framelearn.stragety.config;

import com.example.framelearn.stragety.PasswordPolicyManager;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author jt
 * @date 2020-6-9
 */
@Configuration
public class BeanConfig {


    /**
     * 初始化类的同时，传入ApplicationContext
     * @param context
     * @return
     */
    @Bean
    public PasswordPolicyManager passwordPolicyManager(ApplicationContext context) {
        return new PasswordPolicyManager(context);
    }
}
