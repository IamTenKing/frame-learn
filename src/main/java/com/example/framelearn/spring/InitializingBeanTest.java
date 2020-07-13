package com.example.framelearn.spring;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;

/**
 * @author jt
 * @date 2020-6-12
 */
//@Configuration
public class InitializingBeanTest  implements InitializingBean {

    @Override
    public void afterPropertiesSet() throws Exception {


        System.out.println("###############InitializingBean=========================");
    }
}
