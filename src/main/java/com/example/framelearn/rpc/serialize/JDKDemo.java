package com.example.framelearn.rpc.serialize;

import java.io.*;

/**
 *
 * jdk 原生序列化方式
 *
 * 网络传输必须要以二进制的方式进行传输
 *
 * 实际上任何一种序列化框架，核心思想就是设计一种序列化协议
 * @author jt
 * @date 2020-6-4
 */
public class JDKDemo {

    public static void main(String[] args) throws IOException, ClassNotFoundException {
        String home = System.getProperty("user.home");
        String basePath = home+"/Desktop";
        System.out.println(basePath);
        FileOutputStream fos = new FileOutputStream(basePath+"student.dat");

        Student student = new Student();
        student.setName("test");
        student.setAddress("广州");
        student.setAge(11);

        ObjectOutputStream oos = new ObjectOutputStream(fos);
        oos.writeObject(student);
        oos.flush();


        FileInputStream fis = new FileInputStream(basePath + "student.dat");
        ObjectInputStream ois = new ObjectInputStream(fis);
        Student student1 = (Student) ois.readObject();
        ois.close();
        System.out.println(student1.getName());


    }
}
