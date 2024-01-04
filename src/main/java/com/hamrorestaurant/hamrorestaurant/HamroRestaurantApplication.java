package com.hamrorestaurant.hamrorestaurant;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;


@SpringBootApplication
@EnableEurekaClient
public class HamroRestaurantApplication {

	public static void main(String[] args) {
		SpringApplication.run(HamroRestaurantApplication.class, args);
	}

}
