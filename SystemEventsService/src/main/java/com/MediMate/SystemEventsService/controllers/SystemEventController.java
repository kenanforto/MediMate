package com.MediMate.SystemEventsService.controllers;

import com.MediMate.SystemEventsService.models.SystemEvent;
import com.MediMate.SystemEventsService.services.SystemEventService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "events")
public class SystemEventController {

    @Autowired
    SystemEventService systemEventService;

    @GetMapping
    public ResponseEntity<List<SystemEvent>> getAllEvents()
    {
      return systemEventService.getAllEvents();
    }
}
