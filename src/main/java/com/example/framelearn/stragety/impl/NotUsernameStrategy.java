package com.example.framelearn.stragety.impl;

import com.example.framelearn.stragety.BaseUserDTO;
import com.example.framelearn.stragety.PasswordPolicyMap;
import com.example.framelearn.stragety.PasswordPolicyType;
import com.example.framelearn.stragety.PasswordStrategy;

/**
 * @author jt
 * @date 2020-6-9
 */
public class NotUsernameStrategy implements PasswordStrategy {
    private static final String ERROR_MESSAGE = "error.password.policy.notUsername";
    public static final String TYPE= PasswordPolicyType.NOT_USERNAME.getValue();;

    public NotUsernameStrategy() {
    }

    @Override
    public Object validate(PasswordPolicyMap policyMap, BaseUserDTO userDO, String password) {
        Boolean notUsername = (Boolean)policyMap.getPasswordConfig().get(TYPE);
        if (notUsername) {
            String userName = userDO.getLoginName();
            if (password.equals(userName)) {
                throw new RuntimeException("error.password.policy.notUsername");
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
