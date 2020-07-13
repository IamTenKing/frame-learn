package com.example.framelearn.rpc.serialize;

import com.caucho.hessian.io.Hessian2Output;
import com.caucho.hessian.io.HessianInput;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;

/**
 *
 * hessian 压缩后长度比原生短，速度比原生块
 * @author jt
 * @date 2020-6-4
 */
public class HessianDemo {

    public static void main(String[] args) {
        try {
            Student student = new Student();
            student.setAge(111);
            student.setName("hello");
            student.setAddress("tset");
            ByteArrayOutputStream baos = new ByteArrayOutputStream();

            Hessian2Output h2o = new Hessian2Output(baos);

            h2o.writeObject(student);
            h2o.flush();

            byte[] bytes = baos.toByteArray();

            h2o.close();
            baos.close();
            System.out.println("长度"+bytes.length);

            //反序列化
            ByteArrayInputStream bais = new ByteArrayInputStream(bytes);
            HessianInput input = new HessianInput(bais);
            Student object = (Student)input.readObject();

            System.out.println(object.getName());


        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
