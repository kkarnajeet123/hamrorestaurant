package com.hamrorestaurant.hamrorestaurant.web.rest.error;

import java.io.Serializable;
import java.util.List;

public class ErrorResponse implements Serializable {
    private static final long serialVersionUID=1L;

    private String code;
    private String message;
    private List<String> fields;
}
