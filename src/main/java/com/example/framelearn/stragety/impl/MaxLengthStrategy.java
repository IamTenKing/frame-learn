package com.example.framelearn.stragety.impl;

import com.example.framelearn.stragety.BaseUserDTO;
import com.example.framelearn.stragety.PasswordPolicyMap;
import com.example.framelearn.stragety.PasswordPolicyType;
import com.example.framelearn.stragety.PasswordStrategy;

/**
 * @author jt
 * @date 2020-6-9
 */
public class MaxLengthStrategy implements PasswordStrategy {
    private static final String ERROR_MESSAGE = "error.password.policy.maxLength";
    private static final String TYPE= PasswordPolicyType.MAX_LENGTH.getValue();

    public MaxLengthStrategy() {
    }

    @Override
    public Object validate(PasswordPolicyMap policyMap, BaseUserDTO userDTO, String password) {
        Integer max = (Integer)policyMap.getPasswordConfig().get(TYPE);
        if (max != null && max != 0 && password.length() > max) {
            throw new RuntimeException(ERROR_MESSAGE);
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
