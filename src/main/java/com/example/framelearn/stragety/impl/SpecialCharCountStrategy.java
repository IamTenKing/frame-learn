package com.example.framelearn.stragety.impl;

import com.example.framelearn.stragety.BaseUserDTO;
import com.example.framelearn.stragety.PasswordPolicyMap;
import com.example.framelearn.stragety.PasswordPolicyType;
import com.example.framelearn.stragety.PasswordStrategy;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author jt
 * @date 2020-6-9
 */
public class SpecialCharCountStrategy implements PasswordStrategy {
    private static final String ERROR_MESSAGE = "error.password.policy.specialChar";
    public static final String TYPE= PasswordPolicyType.SPECIALCHAR_COUNT.getValue();
    private static final String SPECIAL_REGEX = "[~`@#$%^&*\\-_=+|/()<>,.;:!]";
    private static final Pattern PATTERN= Pattern.compile("[~`@#$%^&*\\-_=+|/()<>,.;:!]");;

    public SpecialCharCountStrategy() {
    }

    @Override
    public Object validate(PasswordPolicyMap policyMap, BaseUserDTO userDO, String password) {
        Integer min = (Integer)policyMap.getPasswordConfig().get(TYPE);
        if (min != null && min != 0) {
            int count = 0;

            for(Matcher m = PATTERN.matcher(password); m.find(); ++count) {
            }

            if (count < min) {
                throw new RuntimeException("error.password.policy.specialChar");
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

