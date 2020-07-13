package com.example.framelearn.test;

import org.springframework.stereotype.Component;

import java.io.IOException;

/**
 *
 * 在Java程序中可以通过添加关闭钩子，实现在程序退出时关闭资源、平滑退出的功能。 使用Runtime.addShutdownHook(Thread hook)方法，可以注册一个JVM关闭的钩子，这个钩子可以在以下几种场景被调用：
 * 1. 程序正常退出
 * 2. 使用System.exit()
 * 3. 终端使用Ctrl+C触发的中断
 * 4. 系统关闭
 * 5. 使用Kill pid命令干掉进程
 *
 *
 *
 * @author jt
 * @date 2020-5-18
 */

public class ShutdownHookTest {
    public static void main(String[] args) {
        System.out.println("我是主线程，说点什么好呢？");

        Runtime.getRuntime().addShutdownHook(new Thread(() -> {
            System.out.println("程序结束之前最后的反抗");
        }));

        new Thread(() -> {
            System.out.println("==============IDE debug==================");
            System.out.println("press ENTER to call System.exit(0) ");
            System.out.println("==============IDE debug==================");
            try {
                System.out.println(System.in.read());
            } catch (IOException e) {
                e.printStackTrace();
            }

            System.exit(0);
        }).start();
    }


}
