package com.example.framelearn.file;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.math.BigInteger;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;


/**
 *
 * 通过md5 判断文件是否有被修改
 */
public class ChangeTest {
    public static String getMd5ByFile(File file) throws IOException, NoSuchAlgorithmException {
        String value = null;
        FileInputStream in = new FileInputStream(file);
        MappedByteBuffer byteBuffer = in.getChannel().map(FileChannel.MapMode.READ_ONLY, 0, file.length());
        MessageDigest md5 = MessageDigest.getInstance("MD5");
        md5.update(byteBuffer);
        BigInteger bi = new BigInteger(1, md5.digest());
        value = bi.toString(16);
        if (null != in) {
            in.close();
        }
        return value;
    }

    public static void main(String[] args) throws IOException, NoSuchAlgorithmException {
        String path = "C:\\Users\\Ten\\Desktop\\王子战个人简历_20200716.doc";
        String path2 = "C:\\Users\\Ten\\Desktop\\王子战个人简历_20200716 - 副本.doc";
        String v = getMd5ByFile(new File(path));
        String v2 = getMd5ByFile(new File(path2));
        System.out.println("MD5:" + v);
        System.out.println("MD5:" + v2);
    }

}
