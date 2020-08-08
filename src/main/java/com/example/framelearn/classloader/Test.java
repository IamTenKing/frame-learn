package com.example.framelearn.classloader;

import java.lang.reflect.Field;

/**
 * @author jt
 * @date 2020-7-22
 */
public class Test {

    public static void main(String[] args) throws Exception {
//        Class<?> aClass = Class.forName(String.valueOf(Pojo.class), false,);

//        Class<?> aClass = Class.forName("com.example.framelearn.classloader.Pojo");
        //loadclass只执行类加载过程中的第一不 load
        //完整的类加载过程也只是跟静态变量打交道
//        Class<?> aClass = Test1.class.getClassLoader().loadClass("com.example.framelearn.classloader.Pojo");


        Class<?> aClass = Class.forName("com.example.framelearn.classloader.Pojo");
//        Field age = aClass.getField("age");
        Field[] fields = aClass.getFields();
//        System.out.println("sdfsdfs:"+age.get("age").toString());
//        for (Field field : fields) {
//            if(field.getName().equalsIgnoreCase("age")){
//                System.out.println(field.get("age"));
//            }
//        }
    }

}
