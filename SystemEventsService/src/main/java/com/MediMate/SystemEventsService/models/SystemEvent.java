package com.MediMate.SystemEventsService.models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "system_events")
public class SystemEvent {

    @Id
    @GeneratedValue
    Integer id;
    private String timestamp;
    private String microserviceName;
    private String userName;
    private String action;
    private String resource;
    private String responseType;

    public SystemEvent(){    }

    public SystemEvent(String timestamp, String microserviceName, String user, String action, String resource, String responseType) {
        this.timestamp = timestamp;
        this.microserviceName = microserviceName;
        this.userName = user;
        this.action = action;
        this.resource = resource;
        this.responseType = responseType;
    }

    public Integer getId() {
        return id;
    }

    public String getTimestamp() {
        return timestamp;
    }

    public String getMicroserviceName() {
        return microserviceName;
    }

    public String getUser() {
        return userName;
    }

    public String getAction() {
        return action;
    }

    public String getResource() {
        return resource;
    }

    public String getResponseType() {
        return responseType;
    }
}
