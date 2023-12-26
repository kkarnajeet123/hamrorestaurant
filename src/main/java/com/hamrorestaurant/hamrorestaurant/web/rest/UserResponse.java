package com.hamrorestaurant.hamrorestaurant.web.rest;

import com.hamrorestaurant.hamrorestaurant.entity.UserInfoEntity;

import java.util.List;
public class UserResponse {
    private List<UserInfoEntity> Data;
    private List<Object> error;
    private List<Object> warning;

    public List<UserInfoEntity> getData() {
        return Data;
    }

    public void setData(List<UserInfoEntity> data) {
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
