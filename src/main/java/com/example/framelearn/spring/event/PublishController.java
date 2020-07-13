package com.example.framelearn.spring.event;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author jt
 * @date 2020-6-7
 */
@RestController
@RequestMapping
public class PublishController {

    @Autowired
    private MyApplicationContext context;

    /**
     * 发布事件接口
     */
    @GetMapping("/publish")
    public void publish(){

        MyApplicationEvent myApplicationEvent = new MyApplicationEvent("tset", "tset", "test");

        context.publish(myApplicationEvent);


    }
}
