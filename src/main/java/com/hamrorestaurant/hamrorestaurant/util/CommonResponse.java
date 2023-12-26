package com.hamrorestaurant.hamrorestaurant.util;

import lombok.Data;

import java.util.List;
@Data
public class CommonResponse {
    private Object data;
    private List<Object> error;
    private List<Object> warning;

    public CommonResponse(){

    }
    public CommonResponse(Object data){
        this.data = data;
    }
}
