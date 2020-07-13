package com.example.framelearn.rpc.proxy.jdk;

/**
 * @author jt
 * @date 2020-6-5
 */
public class UserServiceImpl implements UserService {
    @Override
    public String getName(int id) {
        System.out.println("------getName------");
        return "Tom";
    }

    @Override
    public Integer getAge(int id) {
        System.out.println("------getAge------");
        return 10;
    }
}

