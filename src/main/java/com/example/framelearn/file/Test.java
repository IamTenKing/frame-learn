package com.example.framelearn.file;

import com.alibaba.fastjson.JSONObject;
import com.example.framelearn.file.model.FilterRule;
import org.omg.CORBA.Environment;
import org.springframework.util.StreamUtils;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.List;

/**
 *
 * 项目启动读取配置文件
 * @author jt
 * @date 2020-8-9
 */
public class Test {

    public static void main(String[] args) throws IOException {

//        总结一下：假如文件是在jar包中，读取方式应当使用基于类加载器读取文件流的方式
//        使用基于java中File方式的读取，在j
//        ar包情况下是读取不到的

        //1、基于java file
        String path = "D:\\seata-1.2.0 (1)\\frame-learn\\src\\main\\resources\\application.yml";
        String fileContent = getFileContent(new File(path));
//        System.out.println(fileContent);


        //----------------基于类加载器读取文件流--------------------
        //2、
//        ClassPathResource classPathResource = new ClassPathResource("application.yml");
//        InputStream inputStream =classPathResource.getInputStream();


        //3、
//        Resource resource = new ClassPathResource("application.yml");
//        InputStream is = resource.getInputStream();
//        InputStreamReader isr = new InputStreamReader(is);
//        BufferedReader br = new BufferedReader(isr);
//        String data = null;
//        while((data = br.readLine()) != null) {
//            System.out.println(data);
//        }
//
//        br.close();
//        isr.close();
//        is.close();


        //4
//        InputStream inputStream = this.getClass().getResourceAsStream("/excleTemplate/test.xlsx");


        try {
            String content = StreamUtils.copyToString(Thread.currentThread().getContextClassLoader().getResourceAsStream("rule.json"), StandardCharsets.UTF_8);
            System.out.println(content);
            List<FilterRule> filterRules = JSONObject.parseArray(content, FilterRule.class);
            for (FilterRule filterRule : filterRules) {
//                if(filterRule.getUrl())


            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


//    public static void loadData() {
//        try {
//            String content = StreamUtils.copyToString(this.getClass().getClassLoader().getResourceAsStream(demoDataFilePath), StandardCharsets.UTF_8);
//            Map demoDataVO = JSONObject.parseObject(content, Map.class);
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//    }


    /**
     * 读取文件内容
     * try-with-resources语法
     *
     * @param file 文件
     * @return 文件内容
     */
    public static String getFileContent(File file) {

        StringBuilder content = new StringBuilder();
        try {
            //try里面不需要关闭资源
            try (FileReader fileReader = new FileReader(file)) {
                try (BufferedReader reader = new BufferedReader(fileReader)) {
                    String lineTxt;
                    while ((lineTxt = reader.readLine()) != null) {
                        content.append(lineTxt).append("\n");
                    }
                }
            }
        } catch (IOException e) {
            throw new RuntimeException("error.file.read", e);
        }
        return content.toString();
    }

}
