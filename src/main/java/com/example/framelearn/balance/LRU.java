package com.example.framelearn.balance;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * @author jt
 * @date 2020-7-22
 */
public class LRU {


    public static void main(String[] args) {

        LinkedHashMap<String, String> map = new LinkedHashMap<String, String>(16, 0.75f, true);

        map.put("1","1");
        map.put("2","2");
        map.put("3","3");
        map.put("4","4");

//
//        String key = map.entrySet().iterator().next().getKey();
//        System.out.println("key:"+key);
//        //get非常重要，一定要get以后才有效
//        String s = map.get(key);
//
//        System.out.println("map大小："+map.size());
//
//        String key1 = map.entrySet().iterator().next().getKey();
//        System.out.println("key1:"+key1);
//        String s1 = map.get(key1);
//        System.out.println("map大小："+map.size());


        for (int i = 0; i < 10; i++) {
            String key2 = map.entrySet().iterator().next().getKey();
            System.out.println("key:"+key2);
            //get非常重要，一定要get以后才有效
            String s2 = map.get(key2);

            System.out.println("map大小："+map.size());

        }

    }
}
