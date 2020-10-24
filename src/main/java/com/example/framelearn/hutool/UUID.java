package com.example.framelearn.hutool;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * Date:2020/9/15
 *
 * 雪花算法id生成
 */

@RestController
@RequestMapping
public class UUID implements ApplicationContextAware {





    @GetMapping("/uuid")
    public void uuid(){

//        SnowflakeUtil snowflakeConfig1 = (SnowflakeUtil) applicationContext1.getBean("snowflakeUtil");


        for (int i = 0; i < 10; i++) {
            System.out.println(SnowflakeUtil.snowflakeId());

        }


    }

    private ApplicationContext applicationContext1;

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        applicationContext1 = applicationContext;


    }
}
