package com.example.framelearn.spring.event;

import org.springframework.context.ApplicationEvent;

/**
 *
 * 自定义一个applicaiotnEvent
 * @author jt
 * @date 2020-6-7
 */
public class MyApplicationEvent extends ApplicationEvent {


    private static final long serialVersionUID = 1L;
    public String address;
    public String text;

    public MyApplicationEvent(Object source) {
        super(source);
    }

    public MyApplicationEvent(Object source, String address, String text) {
        super(source);
        this.address = address;
        this.text = text;
    }

    public void print(){
        System.out.println("hello spring event!");
    }
}
