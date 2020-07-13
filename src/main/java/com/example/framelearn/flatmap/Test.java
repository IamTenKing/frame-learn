package com.example.framelearn.flatmap;

import java.util.Arrays;
import java.util.List;

import static java.util.stream.Collectors.toList;

/**
 * @author jt
 * @date 2020-6-21
 */
public class Test {

    public static void main(String[] args) {

        String[] words = new String[]{"Hello","World"};
//        List<String[]> a = Arrays.stream(words)
//                .map(word -> word.split(""))
//                .distinct()
//                .collect(toList());
//        a.forEach(System.out::print);


        List<String> b = Arrays.stream(words)
                .map(word -> word.split(""))
                //每个元素都是一个数据流
                .flatMap(Arrays::stream)
                .distinct()
                .collect(toList());
        b.forEach(System.out::println);
    }
}
