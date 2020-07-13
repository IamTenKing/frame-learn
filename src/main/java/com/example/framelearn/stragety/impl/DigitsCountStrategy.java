package com.example.framelearn.stragety.impl;

import com.example.framelearn.stragety.BaseUserDTO;
import com.example.framelearn.stragety.PasswordPolicyMap;
import com.example.framelearn.stragety.PasswordPolicyType;
import com.example.framelearn.stragety.PasswordStrategy;

/**
 * @author jt
 * @date 2020-6-9
 */
public class DigitsCountStrategy implements PasswordStrategy {
    private static final String ERROR_MESSAGE = "error.password.policy.digits";
    public static final String TYPE= PasswordPolicyType.DIGITS_COUNT.getValue();

    public DigitsCountStrategy() {
    }

    @Override
    public Object validate(PasswordPolicyMap policyMap, BaseUserDTO userDTO, String password) {
        Integer min = (Integer)policyMap.getPasswordConfig().get(TYPE);
        if (min != null && min != 0) {
            int count = 0;
            char[] var6 = password.toCharArray();
            int var7 = var6.length;

            for(int var8 = 0; var8 < var7; ++var8) {
                char c = var6[var8];
                if (Character.isDigit(c)) {
                    ++count;
                }
            }

            if (count < min) {
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
