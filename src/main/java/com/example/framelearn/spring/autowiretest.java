package com.example.framelearn.spring;

import java.lang.reflect.Field;

/**
 * @author jt
 * @date 2020-6-15
 */
public class autowiretest {
    public static void main(String[] args) throws IllegalAccessException, InstantiationException {

        UserController userController = new UserController();

        Field[] declaredFields = userController.getClass().getDeclaredFields();


        for (Field declaredField : declaredFields) {

            if(declaredField.getAnnotationsByType(MyAutoWire.class)!=null){

                declaredField.setAccessible(true);
                Class<?> type = declaredField.getType();
                Object o = type.newInstance();

                declaredField.set(userController,o);


            }
        }

        userController.hello();
    }
}
