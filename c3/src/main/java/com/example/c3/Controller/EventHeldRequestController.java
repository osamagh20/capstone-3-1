package com.example.c3.Controller;

import com.example.c3.Model.EventHeldRequest;
import com.example.c3.Service.EventHeldRequestService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/event-held-request")
public class EventHeldRequestController {
    private final EventHeldRequestService eventHeldRequestService;

    @GetMapping("/get")
    public ResponseEntity eventHeldRequest() {
        List<EventHeldRequest> eventHeldRequests = eventHeldRequestService.getAllEventHeldRequests();
        return ResponseEntity.status(200).body(eventHeldRequests);

    }
}
