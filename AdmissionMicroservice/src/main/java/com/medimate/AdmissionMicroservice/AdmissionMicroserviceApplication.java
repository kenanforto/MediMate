package com.medimate.AdmissionMicroservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class AdmissionMicroserviceApplication {

	public static void main(String[] args) {
		SpringApplication.run(AdmissionMicroserviceApplication.class, args);
	}

}
