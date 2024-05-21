package com.MediMate.SystemEventsService.services;

import com.MediMate.SystemEventsService.models.SystemEvent;
import com.MediMate.SystemEventsService.repositories.SystemEventRepository;
import io.grpc.stub.StreamObserver;
import org.medimate.grpc.SystemEventRequest;
import org.medimate.grpc.SystemEventResponse;
import org.medimate.grpc.SystemEventsServiceGrpc;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SystemEventService extends SystemEventsServiceGrpc.SystemEventsServiceImplBase {

    SystemEventRepository systemEventRepository;

    public SystemEventService(ApplicationContext applicationContext)
    {
        this.systemEventRepository=applicationContext.getBean(SystemEventRepository.class);
    }
    @Override
    public void systemEventLog(SystemEventRequest request, StreamObserver<SystemEventResponse> responseObserver)
    {
        SystemEvent systemEvent=new SystemEvent(
                request.getTimestamp(),
                request.getMicroserviceName(),
                request.getUser(),
                request.getAction(),
                request.getResource(),
                request.getResponseType()
        );

        systemEventRepository.save(systemEvent);
        System.out.println("\nEvent details: ");
        System.out.println("ID: "+systemEvent.getId());
        System.out.println("Timestamp: "+systemEvent.getTimestamp());
        System.out.println("Microservice: "+systemEvent.getMicroserviceName());
        System.out.println("Action: "+systemEvent.getAction());
        System.out.println("User: "+systemEvent.getUser());
        System.out.println("Resource: "+systemEvent.getResource());
        System.out.println("Response type: "+systemEvent.getResponseType()+"\n");

        SystemEventResponse response=SystemEventResponse.newBuilder().setResponse("Event successfully recorded!").build();
        responseObserver.onNext(response);
        responseObserver.onCompleted();
    }

    public ResponseEntity<List<SystemEvent>> getAllEvents()
    {
        List<SystemEvent> events=systemEventRepository.findAll();
        return (!events.isEmpty()) ? ResponseEntity.ok(events):ResponseEntity.notFound().build();
    }
}
