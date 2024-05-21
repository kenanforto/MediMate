package com.medimate.SuppliesMicroservice.interceptor;

import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.medimate.grpc.SystemEventsServiceGrpc;
import org.medimate.grpc.SystemEventRequest;
import org.medimate.grpc.SystemEventResponse;
import org.springframework.lang.Nullable;
import org.springframework.web.servlet.HandlerInterceptor;

import java.time.LocalDateTime;

public class SystemEventsInterceptor implements HandlerInterceptor {

    public SystemEventsInterceptor(){}

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler,
                                 @Nullable Exception ex) throws Exception {
        ManagedChannel channel= ManagedChannelBuilder.forAddress("localhost",9000).usePlaintext().build();
        SystemEventsServiceGrpc.SystemEventsServiceBlockingStub stub=SystemEventsServiceGrpc.newBlockingStub(channel);
        SystemEventResponse systemEventResponse=stub.systemEventLog(
                SystemEventRequest.newBuilder()
                        .setTimestamp(LocalDateTime.now().toString())
                        .setMicroserviceName("supplies-microservice")
                        .setUser("admin")
                        .setAction(request.getMethod())
                        .setResource(request.getRequestURI())
                        .setResponseType(Integer.toString(response.getStatus()))
                        .build()
        );
        channel.shutdown();

    }
}
