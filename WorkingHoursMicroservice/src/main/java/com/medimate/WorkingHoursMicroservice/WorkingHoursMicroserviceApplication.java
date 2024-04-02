package com.medimate.WorkingHoursMicroservice;

import com.medimate.WorkingHoursMicroservice.models.WorkingHours;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class WorkingHoursMicroserviceApplication {

	public static void main(String[] args) {
		var work = WorkingHours.builder()
				.title("test")
				.build();
		SpringApplication.run(WorkingHoursMicroserviceApplication.class, args);
	}

}
