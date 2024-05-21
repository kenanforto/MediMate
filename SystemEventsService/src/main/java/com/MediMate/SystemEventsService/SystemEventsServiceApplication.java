package com.MediMate.SystemEventsService;

import com.MediMate.SystemEventsService.services.SystemEventService;
import io.grpc.Server;
import io.grpc.ServerBuilder;
import org.springframework.beans.BeansException;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

@SpringBootApplication
public class SystemEventsServiceApplication implements ApplicationContextAware {

	static ApplicationContext applicationContext;
	public static void main(String[] args) {

		SpringApplication.run(SystemEventsServiceApplication.class, args);
		Server server= ServerBuilder
				.forPort(9000)
				.addService(new SystemEventService(applicationContext)).build();
		try {
			server.start();
			server.awaitTermination();
		}
		catch(Exception exception){ }
	}

	@Override
	public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
		this.applicationContext=applicationContext;
	}
}
