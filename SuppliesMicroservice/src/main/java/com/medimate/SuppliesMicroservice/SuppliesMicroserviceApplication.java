package com.medimate.SuppliesMicroservice;

import com.medimate.SuppliesMicroservice.interceptor.SystemEventsInterceptor;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.Bean;

@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class })
@EnableDiscoveryClient
public class SuppliesMicroserviceApplication {

	public static void main(String[] args) {
		SpringApplication.run(SuppliesMicroserviceApplication.class, args);
	}

	@Bean
	public SystemEventsInterceptor systemEventsInterceptor()
	{
		return new SystemEventsInterceptor();
	}
}
