package com.example.framelearn.regx;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author jt
 * @date 2020-8-7
 */
public class Test {

    public static void main(String[] args) {
        Pattern TKD_PATTERN = Pattern.compile("\"taskId\":\".*?\"");

        Matcher matcher = TKD_PATTERN.matcher("\"taskId\":\"test1\",\"taskId\":\"test2\"");

        while(matcher.find()){
            System.out.println(matcher.group());
        }

        //-----结果 $test$_$hello$------
        Pattern VARIABLE_PATTERN = Pattern.compile("\\$(.*)\\$");
        Matcher matcher1 = VARIABLE_PATTERN.matcher("$test$_$hello$");

        while(matcher1.find()){
            System.out.println(matcher1.group());
        }


        //-----结果 $test$_$hello$------
        Pattern VARIABLE_PATTERN2 = Pattern.compile("\\$(.*?)\\$");
        Matcher matcher2 = VARIABLE_PATTERN2.matcher("$test$_$hello$");

        while(matcher2.find()){
            System.out.println(matcher2.group());
        }


    }
}
