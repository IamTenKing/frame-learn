package com.example.framelearn.concurrent;

import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;

/**
 *
 * semaphore只有三个操作，初始化，获取，释放
 *
 * 作用：控制多少个线程同时访问某个资源，
 *
 * semaphore有点像锁，拿到信号才可以执行
 *
 * @author jt
 * @date 2020-7-22
 */
public class StudySemaphore {
    public static void main(String[] args) {
        ExecutorService executorService = Executors.newCachedThreadPool();

        //信号量，只允许 3个线程同时访问
        Semaphore semaphore = new Semaphore(3);

        for (int i=0;i<10;i++){
            final long num = i;
            executorService.submit(new Runnable() {
                @Override
                public void run() {
                    try {
                        //获取许可
                        semaphore.acquire();
                        //执行
                        System.out.println("Accessing: " + num);
                        Thread.sleep(new Random().nextInt(5000)); // 模拟随机执行时长
                        //释放
                        semaphore.release();
                        System.out.println("Release..." + num);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            });
        }

        executorService.shutdown();
    }

}
