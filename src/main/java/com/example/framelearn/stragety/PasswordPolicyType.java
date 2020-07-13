package com.example.framelearn.stragety;

/**
 * @author jt
 * @date 2020-6-9
 */
public enum  PasswordPolicyType {

    MIN_LENGTH("minLength"),
    MAX_LENGTH("maxLength"),
    DIGITS_COUNT("digitsCount"),
    LOWERCASE_COUNT("lowercaseCount"),
    UPPERCASE_COUNT("uppercaseCount"),
    SPECIALCHAR_COUNT("specialCharCount"),
    NOT_USERNAME("notUsername"),
    NOT_RECENT("notRecent"),
    REGULAR("regular"),
    MAX_ERROR_TIME("maxErrorTime"),
    ENABLE_CAPTCHA("enableCaptcha"),
    MAX_CHECK_CAPTCHA("maxCheckCaptcha"),
    ENABLE_LOCK("enableLock"),
    LOCK_EXPIRE_TIME("lockExpireTime");

    private String value;

    private PasswordPolicyType(String value) {
        this.value = value;
    }

    public String getValue() {
        return this.value;
    }
}

