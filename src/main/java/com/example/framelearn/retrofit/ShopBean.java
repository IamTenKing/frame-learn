package com.example.framelearn.retrofit;

import java.io.Serializable;

/**
 * @author jt
 * @date 2020-8-14
 */
public class ShopBean implements Serializable {

    private int error_code;
    private String reason;

    public int getError_code() {
        return error_code;
    }

    public ShopBean(int error_code, String reason) {
        this.error_code = error_code;
        this.reason = reason;
    }

    public void setError_code(int error_code) {
        this.error_code = error_code;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

}
