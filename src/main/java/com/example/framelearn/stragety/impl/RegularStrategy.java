package com.example.framelearn.stragety.impl;

import com.example.framelearn.stragety.BaseUserDTO;
import com.example.framelearn.stragety.PasswordPolicyMap;
import com.example.framelearn.stragety.PasswordPolicyType;
import com.example.framelearn.stragety.PasswordStrategy;
import com.sun.corba.se.impl.ior.OldJIDLObjectKeyTemplate;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * 密码匹配自定义正则表达式
 * @author jt
 * @date 2020-6-9
 */
public class RegularStrategy implements PasswordStrategy {
    private static final String ERROR_MESSAGE = "error.password.policy.regular";
    public static final String TYPE= PasswordPolicyType.REGULAR.getValue();

    public RegularStrategy() {
    }


    @Override
    public Object validate(PasswordPolicyMap policyMap,  BaseUserDTO userDTO, String password) {
        Object reg = policyMap.getPasswordConfig().get(TYPE);
        if (reg instanceof String) {
            Pattern pattern = Pattern.compile((String)reg);
            Matcher matcher = pattern.matcher(password);
            if (!matcher.matches()) {
                throw new RuntimeException(ERROR_MESSAGE);
            }
        }

        return null;
    }

    @Override
    public String getType() {
        return TYPE;
    }

    @Override
    public Object parseConfig(Object value) {
        return null;
    }
}

