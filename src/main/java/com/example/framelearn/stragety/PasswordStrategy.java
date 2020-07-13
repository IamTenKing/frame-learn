package com.example.framelearn.stragety;

public interface PasswordStrategy {

    <T> T validate(PasswordPolicyMap policyMap,BaseUserDTO userDTO, String password);

    String getType();

    Object parseConfig(Object value);
}


