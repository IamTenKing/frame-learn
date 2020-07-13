package com.example.framelearn.stragety;

import lombok.Data;

import java.util.Date;

/**
 * @author jt
 * @date 2020-6-9
 */
@Data
public class BaseUserDTO {

    public static final String EMAIL_REGULAR_EXPRESSION = "[\\w!#$%&'*+/=?^_`{|}~-]+(?:\\.[\\w!#$%&'*+/=?^_`{|}~-]+)*@(?:[\\w](?:[\\w-]*[\\w])?\\.)+[\\w](?:[\\w-]*[\\w])?";
    private Long id;
    private String loginName;
    private String email;
    private Long organizationId;

    private String password;
    private String realName;
    private String phone;
    private String imageUrl;
    private String profilePhoto;
    private Boolean isEnabled;
    private Boolean isLdap;
    private String language;
    private String timeZone;
    private Date lastPasswordUpdatedAt;
    private Date lastLoginAt;
    private Boolean isLocked;
    private Date lockedUntilAt;
    private Integer passwordAttempt;
}
