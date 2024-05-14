package com.MediMate.SystemEventsService;

import com.MediMate.SystemEventsService.services.SystemEventService;
import io.grpc.Server;
import io.grpc.ServerBuilder;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SystemEventsServiceApplication {

	public static void main(String[] args) {

		SpringApplication.run(SystemEventsServiceApplication.class, args);
		Server server= ServerBuilder
				.forPort(9000)
				.addService(new SystemEventService()).build();
		try {
			server.start();
			server.awaitTermination();
		}
		catch(Exception exception){ }
	}

}
