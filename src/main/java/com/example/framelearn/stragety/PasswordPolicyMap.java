package com.example.framelearn.stragety;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;
import java.util.Map.Entry;


/**
 * loginConfig和passwordConfig
 *
 */
@Data
@AllArgsConstructor
public class PasswordPolicyMap {
    private Map<String, Object> passwordConfig;
    private Boolean enablePassword;
    private Boolean enableSecurity;


    public static PasswordPolicyMap parse(BasePasswordPolicyDTO policy) {
        boolean enablePassword = policy.getEnablePassword();
        boolean enableSecurity = policy.getEnableSecurity();
        Map<String, Object> passwordConfig = new LinkedHashMap();
        passwordConfig.put(PasswordPolicyType.MIN_LENGTH.getValue(), policy.getMinLength());
        passwordConfig.put(PasswordPolicyType.MAX_LENGTH.getValue(), policy.getMaxLength());
        passwordConfig.put(PasswordPolicyType.DIGITS_COUNT.getValue(), policy.getDigitsCount());
        passwordConfig.put(PasswordPolicyType.LOWERCASE_COUNT.getValue(), policy.getLowercaseCount());
        passwordConfig.put(PasswordPolicyType.UPPERCASE_COUNT.getValue(), policy.getUppercaseCount());
        passwordConfig.put(PasswordPolicyType.SPECIALCHAR_COUNT.getValue(), policy.getSpecialCharCount());
        passwordConfig.put(PasswordPolicyType.NOT_USERNAME.getValue(), policy.getNotUsername());
        passwordConfig.put(PasswordPolicyType.NOT_RECENT.getValue(), policy.getNotRecentCount());
        passwordConfig.put(PasswordPolicyType.REGULAR.getValue(), policy.getRegularExpression());

        return new PasswordPolicyMap(passwordConfig, enablePassword, enableSecurity);
    }
}
