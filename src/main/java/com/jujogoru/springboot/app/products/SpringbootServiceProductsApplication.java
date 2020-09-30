package com.jujogoru.springboot.app.products;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@EnableEurekaClient
@SpringBootApplication
@EntityScan({"com.jujogoru.springboot.app.commons.models.entity"}) //Separated by commas you can indicate all the packages from different projects  
public class SpringbootServiceProductsApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringbootServiceProductsApplication.class, args);
	}

}
