package com.example.framelearn.stragety.impl;

import com.example.framelearn.stragety.BaseUserDTO;
import com.example.framelearn.stragety.PasswordPolicyMap;
import com.example.framelearn.stragety.PasswordPolicyType;
import com.example.framelearn.stragety.PasswordStrategy;

/**
 * @author jt
 * @date 2020-6-9
 */
public class MinLengthStrategy implements PasswordStrategy {
    private static final String ERROR_MESSAGE = "error.password.policy.minLength";
    public static final String TYPE=PasswordPolicyType.MIN_LENGTH.getValue();

    public MinLengthStrategy() {
    }

    @Override
    public Object validate(PasswordPolicyMap policyMap, BaseUserDTO userDTO, String password) {
        Integer min = (Integer)policyMap.getPasswordConfig().get(TYPE);
        if (min != null && min != 0 && password.length() < min) {
            throw new RuntimeException("error.password.policy.minLength");
        } else {
            return null;
        }
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

