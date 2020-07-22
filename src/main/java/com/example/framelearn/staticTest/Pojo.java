package com.example.framelearn.staticTest;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * @author jt
 * @date 2020-7-21
 */
@Data
public class Pojo {

    public Pojo() {
    }



    public final static Pojo POJO = new Pojo("11","222");
    private String name;
    private String id;

    public Pojo(String name, String id) {
        this.name = name;
        this.id = id;
    }

    Pojo getPojo(){
        return POJO;
    }
}
