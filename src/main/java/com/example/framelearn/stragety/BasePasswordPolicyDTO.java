package com.example.framelearn.stragety;

import lombok.Data;

//@Table(
//        name = "oauth_password_policy"
//)
@Data
public class BasePasswordPolicyDTO  {
//    @Id
//    @GeneratedValue(
//            strategy = GenerationType.IDENTITY
//    )
    private Long id;
    private String code;
    private String name;
    private Long organizationId;
    private String originalPassword;
    private Integer minLength;
    private Integer maxLength;
    private Integer maxErrorTime;
    private Integer digitsCount;
    private Integer lowercaseCount;
    private Integer uppercaseCount;
    private Integer specialCharCount;
    private Boolean notUsername;
    private String regularExpression;
    private Integer notRecentCount;
    private Boolean enablePassword;
    private Boolean enableSecurity;
    private Boolean enableLock;
    private Integer lockedExpireTime;
    private Boolean enableCaptcha;
    private Integer maxCheckCaptcha;

    public BasePasswordPolicyDTO() {
    }

    public void setterOne(String name, Long organizationId, String originalPassword, Integer minLength, Integer maxLength, Integer maxErrorTime, Integer digitsCount) {
        this.name = name;
        this.organizationId = organizationId;
        this.originalPassword = originalPassword;
        this.minLength = minLength;
        this.maxLength = maxLength;
        this.maxErrorTime = maxErrorTime;
        this.digitsCount = digitsCount;
    }

    public void setterTwo(Integer lowercaseCount, Integer uppercaseCount, Integer specialCharCount, Boolean notUsername, String regularExpression, Integer notRecentCount, Boolean enablePassword) {
        this.lowercaseCount = lowercaseCount;
        this.uppercaseCount = uppercaseCount;
        this.specialCharCount = specialCharCount;
        this.notUsername = notUsername;
        this.regularExpression = regularExpression;
        this.notRecentCount = notRecentCount;
        this.enablePassword = enablePassword;
    }

    public void setterThree(Boolean enableSecurity, Boolean enableLock, Integer lockedExpireTime, Boolean enableCaptcha, Integer maxCheckCaptcha) {
        this.enableSecurity = enableSecurity;
        this.enableLock = enableLock;
        this.lockedExpireTime = lockedExpireTime;
        this.enableCaptcha = enableCaptcha;
        this.maxCheckCaptcha = maxCheckCaptcha;
    }

}
