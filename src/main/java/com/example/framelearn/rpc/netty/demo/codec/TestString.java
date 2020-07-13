package com.example.framelearn.rpc.netty.demo.codec;

import java.io.UnsupportedEncodingException;

/**
 * @author jt
 * @date 2020-6-8
 */
public class TestString {
    public static void main(String[] args) {

        String test = "713f17ca614361fb257dc6741332caf2";
        try {
            System.out.println(test.getBytes("utf-8").length);


        } catch (Exception e) {
            e.printStackTrace();
        }


    }
}
