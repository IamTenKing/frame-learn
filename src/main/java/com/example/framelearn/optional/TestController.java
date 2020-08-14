package com.example.framelearn.optional;

import com.example.framelearn.retrofit.ShopBean;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

/**
 * @author jt
 * @date 2020-8-14
 */

@RestController
@RequestMapping
public class TestController
{
    @GetMapping("/pageByOptions")
    public ShopBean pageByOptions(){

        //返回值为null的时候抛出异常
        ShopBean helloworld = new ShopBean(1, "helloworld");

        return helloworld;
//        return Optional.ofNullable(new ShopBean(1,"helloworld"))
//                .map(target -> new ResponseEntity<>( target, HttpStatus.OK))
//                .orElseThrow(() -> new RuntimeException("error.app.service.baseList"));
//        return Optional.ofNullable(null)
//                .map(target -> new ResponseEntity<>((Object) target, HttpStatus.OK))
//                .orElseThrow(() -> new RuntimeException("error.app.service.baseList"));
    }

}
