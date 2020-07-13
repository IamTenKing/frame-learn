package com.example.framelearn.excel.bean;

import lombok.Data;

/**
 * 类功能描述：Excel row bean
 *
 * @author WangXueXing create at 19-4-13 下午10:22
 * @version 1.0.0
 */
@Data
public class Row {
    private String name1;
    private String name2;
    private String name3;
    private String name4;
    private String name5;
    private String name6;
    private String name7;

    public String getName1() {
        return name1;
    }
    public void setName1(String name1) {
        this.name1 = name1;
    }

    public String getName2() {
        return name2;
    }
    public void setName2(String name2) {
        this.name2 = name2;
    }

    public String getName3() {
        return name3;
    }
    public void setName3(String name3) {
        this.name3 = name3;
    }
}
