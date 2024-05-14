package com.MediMate.SystemEventsService.services;

import com.MediMate.SystemEventsService.models.SystemEvent;
import com.MediMate.SystemEventsService.repositories.SystemEventRepository;
import io.grpc.stub.StreamObserver;
import org.medimate.grpc.SystemEventRequest;
import org.medimate.grpc.SystemEventResponse;
import org.medimate.grpc.SystemEventsServiceGrpc;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SystemEventService extends SystemEventsServiceGrpc.SystemEventsServiceImplBase {

    @Autowired
    SystemEventRepository systemEventRepository;
    @Override
    public void systemEventLog(SystemEventRequest request, StreamObserver<SystemEventResponse> responseObserver)
    {
        SystemEvent systemEvent=new SystemEvent(
                request.getTimestamp(),
                request.getMicroserviceName(),
                request.getUser(),
                request.getAction(),
                request.getResource(),
                request.getResourceType()
        );
        systemEventRepository.save(systemEvent);

        SystemEventResponse response=SystemEventResponse.newBuilder().setResponse("Test loga").build();
        responseObserver.onNext(response);
        responseObserver.onCompleted();
    }

    public ResponseEntity<List<SystemEvent>> getAllEvents()
    {
        List<SystemEvent> events=systemEventRepository.findAll();
        return (!events.isEmpty()) ? ResponseEntity.ok(events):ResponseEntity.notFound().build();
    }
}
