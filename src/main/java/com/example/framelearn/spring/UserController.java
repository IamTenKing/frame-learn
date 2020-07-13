package com.example.framelearn.spring;

/**
 * @author jt
 * @date 2020-6-15
 */


public class UserController {


    @MyAutoWire
    private UserService userService;


    public void hello(){
        userService.hello();
    }
}
