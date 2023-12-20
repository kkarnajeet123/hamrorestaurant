package com.hamrorestaurant.hamrorestaurant.exception;

public class CommonException extends RuntimeException{

    private static final long serialVersionUID=1l;

    public CommonException (String errorMessage, Throwable error){
        super(errorMessage, error);
    }
}
