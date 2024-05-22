package com.medimate.AppointmentMicroservice.interceptor;

import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.medimate.grpc.SystemEventRequest;
import org.medimate.grpc.SystemEventResponse;
import org.medimate.grpc.SystemEventsServiceGrpc;
import org.springframework.lang.Nullable;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import java.time.LocalDateTime;

public class SystemEventsInterceptor implements HandlerInterceptor {


    public SystemEventsInterceptor() {
    }

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception{
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {

    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler,
                                 @Nullable Exception ex) throws Exception {
        ManagedChannel channel= ManagedChannelBuilder.forAddress("localhost",9000)
                .usePlaintext()
                .build();
        SystemEventsServiceGrpc.SystemEventsServiceBlockingStub stub=SystemEventsServiceGrpc.newBlockingStub(channel); // interface for client to make remote method call
        SystemEventResponse systemEventResponse=stub.systemEventLog(
                SystemEventRequest.newBuilder()
                        .setTimestamp(LocalDateTime.now().toString())
                        .setMicroserviceName("appointment-service")
                        .setUser("admin")
                        .setAction(request.getMethod())
                        .setResource(request.getRequestURI())
                        .setResponseType(Integer.toString(response.getStatus()))
                        .build()
        );
        channel.shutdown();
    }
}
