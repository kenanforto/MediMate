package com.medimate.WorkingHoursMicroservice;

import com.medimate.WorkingHoursMicroservice.interceptor.SystemEventsInterceptor;
import com.medimate.WorkingHoursMicroservice.models.WorkingHours;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.Bean;

@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class })
@EnableDiscoveryClient
public class WorkingHoursMicroserviceApplication {

	public static void main(String[] args) {
		var work = WorkingHours.builder()
				.title("test")
				.build();
		SpringApplication.run(WorkingHoursMicroserviceApplication.class, args);
	}

	@Bean
	public SystemEventsInterceptor systemEventsInterceptor()
	{
		return new SystemEventsInterceptor();
	}

}
