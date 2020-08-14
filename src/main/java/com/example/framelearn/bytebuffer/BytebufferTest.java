package com.example.framelearn.bytebuffer;

import java.nio.ByteBuffer;
import java.nio.CharBuffer;

/**
 *
 * 堆外内存的使用，也是由gc进行回收
 * 有两种方式：1.unsafe类  2. nio  bytebuffer
 * @author jt
 * @date 2020-8-11
 */
public class BytebufferTest {
    public static void main(String[] args) {
        // 底层也是调用unsafe类进行操作
        ByteBuffer byteBuffer = ByteBuffer.allocateDirect(10 * 1024 * 1024);

        CharBuffer charBuffer =

                byteBuffer.asCharBuffer();

    }
}

