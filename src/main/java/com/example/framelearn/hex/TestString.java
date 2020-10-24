package com.example.framelearn.hex;

/**
 * Date:2020/9/28
 */
public class TestString {

    public static void main(String[] args) {

        TestString testString = new TestString();


        //输出结果：880ec60
        String s = Integer.toHexString(testString.hashCode());
        System.out.println(s);
    }

}
