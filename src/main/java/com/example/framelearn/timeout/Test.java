package com.example.framelearn.timeout;

/**
 * @author jt
 * @date 2020-7-20
 *
 * xxljob使用的技巧
 */
public class Test {
    public static void main(String[] args) throws InterruptedException {
        long minTim_now = System.currentTimeMillis()/60000;
        Thread.sleep(60000);
        long minTim_now1 = System.currentTimeMillis()/60000;

        if(minTim_now != minTim_now1){
            System.out.println("不相等，说明超过了60s");
        }


        long minTim_now2 = System.currentTimeMillis()/60000;
        long minTim_now3= System.currentTimeMillis()/60000;
        System.out.println(minTim_now+","+minTim_now1+","+minTim_now2+","+minTim_now3);
    }
}
