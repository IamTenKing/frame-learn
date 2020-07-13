package com.example.framelearn;

import com.example.framelearn.exector.NamedThreadFactory;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

@SpringBootTest
class FrameLearnApplicationTests {

    @Test
    void contextLoads() {
    }


    @Test
    public void test(){
        ThreadPoolExecutor test = new ThreadPoolExecutor(1, 1, 5,
                TimeUnit.SECONDS, new ArrayBlockingQueue<>(1), new NamedThreadFactory("test", 1, false));

        test.execute(new Runnable() {
            @Override
            public void run() {
                System.out.println("=============:"+Thread.currentThread().getName());
            }
        });


    }



   @Test
    public void testStragety(){





    }

}
