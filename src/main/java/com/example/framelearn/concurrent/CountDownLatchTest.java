package com.example.framelearn.concurrent;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

/**
 *
 *

 1）CountDownLatch和CyclicBarrier都能够实现线程之间的等待，只不过它们侧重点不同：
 　　　　CountDownLatch一般用于某个线程A等待若干个其他线程执行完任务之后，它才执行；
 　　　　而CyclicBarrier一般用于一组线程互相等待至某个状态，然后这一组线程再同时执行；
 　　　　另外，CountDownLatch是不能够重用的，而CyclicBarrier是可以重用的。
 　　2）Semaphore其实和锁有点类似，它一般用于控制对某组资源的访问权限
 * @author jt
 * @date 2020-7-21
 */
public class CountDownLatchTest {


    public static void main(String[] args) throws InterruptedException {
        CountDownLatch countDownLatch = new CountDownLatch(3);


        MyThread myThread = new MyThread("1", countDownLatch);
        MyThread myThread1 = new MyThread("2", countDownLatch);
        MyThread myThread2 = new MyThread("3", countDownLatch);

        myThread.start();
        myThread1.start();
        myThread2.start();

        //等待
        countDownLatch.await();
//        countDownLatch.await(10, TimeUnit.SECONDS);
        //等待其他线程都执行完才执行
        System.out.println("线程执行完。。。。。。。。。。。");
    }





}
 class MyThread extends Thread{

    private String content;

    private CountDownLatch countDownLatch;

    public MyThread(String content,CountDownLatch count){
        this.content=content;
        this.countDownLatch=count;
    }

    @Override
    public void run() {

        System.out.println(content);
        //
        countDownLatch.countDown();



    }
}
