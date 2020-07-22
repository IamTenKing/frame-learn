package com.example.framelearn.enumtest;

/**
 * @author jt
 * @date 2020-7-20
 */
public class TestMain {
    public static void main(String[] args) {

        //枚举.values()方法是自带。
        Testenum[] values = Testenum.values();
        for (Testenum value : values) {
            ServiceDemo serviceDemo = value.getServiceDemo();
            serviceDemo.test();
        }
    }
}
