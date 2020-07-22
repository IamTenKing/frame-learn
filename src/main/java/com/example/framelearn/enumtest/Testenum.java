package com.example.framelearn.enumtest;

/**
 * @author jt
 * @date 2020-7-20
 */
public enum  Testenum {

    test1("test1",new ServiceDemo());

    //成员
    private String name;
    private ServiceDemo serviceDemo;

    //构造方法
    Testenum(String name, ServiceDemo serviceDemo) {
        this.name = name;
        this.serviceDemo = serviceDemo;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setServiceDemo(ServiceDemo serviceDemo) {
        this.serviceDemo = serviceDemo;
    }

    public String getName() {
        return name;
    }

    public ServiceDemo getServiceDemo() {
        return serviceDemo;
    }}




