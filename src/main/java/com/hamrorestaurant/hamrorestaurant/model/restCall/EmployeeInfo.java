package com.hamrorestaurant.hamrorestaurant.model.restCall;

import lombok.Data;

import java.util.List;

public class EmployeeInfo {

    private String status;
    private List<Datum> data;
    private String message;

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public List<Datum> getData() {
        return data;
    }

    public void setData(List<Datum> data) {
        this.data = data;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
