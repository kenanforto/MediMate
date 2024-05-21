package com.medimate.MedicalRecordMicroservice;

import com.medimate.MedicalRecordMicroservice.interceptor.SystemEventsInterceptor;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
@EnableDiscoveryClient
public class MedicalRecordMicroserviceApplication {

	public static void main(String[] args) {
		SpringApplication.run(MedicalRecordMicroserviceApplication.class, args);
	}

	@Bean
	public SystemEventsInterceptor customInterceptor(){return new SystemEventsInterceptor();}

}
