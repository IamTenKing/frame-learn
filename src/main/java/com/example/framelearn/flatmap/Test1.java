package com.example.framelearn.flatmap;



import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author jt
 * @date 2020-6-21
 */
public class Test1 {
    public static void main(String[] args) {
        List<User> uList = new ArrayList<>();
        User u1 = new User();
        u1.setAddr("a1;a2;a3;a4;a5");

        User u2 = new User();
        u2.setAddr("b1;b2;b3;b4;b5");

        uList.add(u1);
        uList.add(u2);
        //map(入参，返回值)
        List<String> addrList = uList.stream().map(x -> x.getAddr()).flatMap(x->Arrays.stream(x.split(";"))).collect(Collectors.toList());
        //或者
        List<String> ridStrList = uList.stream().map(x -> x.getAddr()).map(x -> x.split(";")).flatMap(Arrays::stream).collect(Collectors.toList());
        System.out.println(addrList);
    }
}
