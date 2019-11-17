package com.tbproject.challenge;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class })
public class TbChallengeVehiclesApplication {

	public static void main(String[] args) {
		SpringApplication.run(TbChallengeVehiclesApplication.class, args);
	}

}
