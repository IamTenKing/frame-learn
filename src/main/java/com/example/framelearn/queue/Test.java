package com.example.framelearn.queue;

import java.util.ArrayList;
import java.util.concurrent.LinkedBlockingDeque;

/**
 * @author jt
 * @date 2020-7-19
 */
public class Test {

    public static void main(String[] args) throws InterruptedException {


        LinkedBlockingDeque<String> strings = new LinkedBlockingDeque<>();

        strings.add("test");

        strings.add("test1");

//        for (String string : strings) {
//            System.out.println(string);
//        }


        for (int i = 0; i < strings.size()+1; i++) {
            System.out.println(strings.take());
        }
    }
}
