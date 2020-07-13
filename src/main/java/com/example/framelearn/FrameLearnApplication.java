package com.example.framelearn;

import com.example.framelearn.spring.event.MyApplicationEvent;
import com.example.framelearn.test.ShutdownHookTest;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class FrameLearnApplication {

    public static void main(String[] args) {
        ApplicationContext run = SpringApplication.run(FrameLearnApplication.class, args);

        //发布一个事件
        run.publishEvent(new MyApplicationEvent("hello","boylmx@163.com","this is a email text!"));
    }




}
