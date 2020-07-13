package com.example.framelearn.spring.event;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.ApplicationEvent;
import org.springframework.stereotype.Component;

/**
 *
 *
 * 注入ApplicationContext对象
 * @author jt
 * @date 2020-6-7
 */
@Component
public class MyApplicationContext  implements ApplicationContextAware {

    private ApplicationContext ctxt;
    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.ctxt = applicationContext;
    }

    void publish(ApplicationEvent event){
        ctxt.publishEvent(event);

    }




}
