package com.example.framelearn.spring.event;

import org.springframework.context.ApplicationEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

/**
 *
 * 监听MyApplicationEvent事件
 * @author jt
 * @date 2020-6-7
 */

@Component
public class MyListener implements ApplicationListener {
    @Override
    public void onApplicationEvent(ApplicationEvent event) {
        if(event instanceof  MyApplicationEvent){

            MyApplicationEvent emailEvent = (MyApplicationEvent)event;
            emailEvent.print();
            System.out.println("the source is:"+emailEvent.getSource());
            System.out.println("the address is:"+emailEvent.address);
            System.out.println("the email's context is:"+emailEvent.text);

        }


    }
}
