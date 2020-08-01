package com.example.framelearn.spring.bean;

import org.springframework.beans.BeansException;
import org.springframework.beans.PropertyValues;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.beans.factory.config.InstantiationAwareBeanPostProcessor;
import org.springframework.stereotype.Component;

/**
 * @author MrBird
 */
@Component
public class MyBeanPostProcessor implements BeanPostProcessor , InstantiationAwareBeanPostProcessor {

    @Override
    public Object postProcessBeforeInstantiation(Class<?> beanClass, String beanName) throws BeansException {
        System.out.println("实例化before。。。。。。。。。。");
        return null;
    }

    @Override
    public boolean postProcessAfterInstantiation(Object bean, String beanName) throws BeansException {
        System.out.println("实例化after。。。。。。");
        return false;
    }

    @Override
    public PropertyValues postProcessProperties(PropertyValues pvs, Object bean, String beanName) throws BeansException {
        System.out.println("属性设。。。。。。");
        return null;
    }

    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
       if(bean instanceof Book){
        System.out.println("BeanPostProcessor:"+beanName + " 初始化之前调用");

       }

        return bean;
    }

    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
//        System.out.println(beanName + " 初始化之后调用");

        if(bean instanceof Book){
            System.out.println("BeanPostProcessor:"+beanName + " 初始化之后调用");

        }
        return bean;
    }
}
