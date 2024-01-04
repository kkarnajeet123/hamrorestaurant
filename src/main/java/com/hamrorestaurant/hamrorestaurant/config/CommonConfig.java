package com.hamrorestaurant.hamrorestaurant.config;

import com.hamrorestaurant.hamrorestaurant.web.rest.UserInfoResponse;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class CommonConfig {

    @Bean
    @LoadBalanced
    public RestTemplate restTemplate(){
        return new RestTemplate();
    }

    @Bean
    public UserInfoResponse userInfoResponse(){
        return new UserInfoResponse();
    }

}
