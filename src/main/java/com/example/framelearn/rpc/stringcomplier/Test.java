package com.example.framelearn.rpc.stringcomplier;

import com.itranswarp.compiler.JavaStringCompiler;

import java.lang.reflect.Method;
import java.util.Map;

/**
 *
 * 动态编译加载类，反射执行
 *
 * 需要依赖jdk tools.jar包，否则报错classNotDef
 * @author jt
 * @date 2020-6-8
 */
public class Test {

    public static void main(String[] args) throws Exception {


        String source  = "package com.example.framelearn.rpc.stringcomplier;\n" +
                "public class Test1 {\n" +
                "    public static void main(String[] args) {\n" +
                "        System.out.println(\"喔呵呵呵呵==================\");\n" +
                "    }\n" +
                "}\n";
        JavaStringCompiler compiler = new JavaStringCompiler();

        Map<String, byte[]> result = compiler.compile("Test1.java", source);

        Class<?> test = compiler.loadClass("com.example.framelearn.rpc.stringcomplier.Test1", result);
        Object o = test.newInstance();
        Method main = test.getDeclaredMethod("main",String[].class);

        main.invoke(o, (Object) new String[0]);


    }
}
