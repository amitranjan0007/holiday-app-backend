package com.neosoft.response;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;

@JsonSerialize
public class APIResponse <T>{
    private T data;
    private Integer code;
    private String message;
    private boolean status;
    private String serverStatusCode;

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public String getServerStatusCode() {
        return serverStatusCode;
    }

    public void setServerStatusCode(String serverStatusCode) {
        this.serverStatusCode = serverStatusCode;
    }
}
