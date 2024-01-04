package com.hamrorestaurant.hamrorestaurant.web.rest;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class CommonResponse {
    private Object data;
    private List<Object> error;
    private List<Object> warning;

}
