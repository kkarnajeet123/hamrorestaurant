package com.hamrorestaurant.hamrorestaurant.web.rest;

import java.util.List;
public class UserInfoResponse {
    private Object Data;
    private List<Object> error;
    private List<Object> warning;

    public Object getData() {
        return Data;
    }

    public void setData(Object data) {
        Data = data;
    }

    public List<Object> getError() {
        return error;
    }

    public void setError(List<Object> error) {
        this.error = error;
    }

    public List<Object> getWarning() {
        return warning;
    }

    public void setWarning(List<Object> warning) {
        this.warning = warning;
    }
}
