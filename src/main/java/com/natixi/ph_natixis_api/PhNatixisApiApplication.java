package com.natixi.ph_natixis_api;

import com.natixi.ph_natixis_api.model.AppUserProperties;
import com.natixi.ph_natixis_api.model.JwtProperties;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

@SpringBootApplication
@EnableConfigurationProperties({JwtProperties.class, AppUserProperties.class})
public class PhNatixisApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(PhNatixisApiApplication.class, args);
	}

}
