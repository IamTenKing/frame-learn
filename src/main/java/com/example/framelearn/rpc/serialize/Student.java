package com.example.framelearn.rpc.serialize;

import lombok.Data;

import java.io.Serializable;

/**
 * Student需要实现序列化接口，否则报错
 * Exception in thread "main" java.io.NotSerializableException: com.example.framelearn.rpc.serialize.Student
 * @author jt
 * @date 2020-6-4
 */

@Data
public class Student implements Serializable {

    private String name;
    private String address;
    private String remark;
    private String nickName;
    private int age;
    private String country;



    private void print(){
        System.out.println("反射成功：========"+this.name);
    }





}
