package com.example.c3.Controller;

import com.example.c3.Model.EventParticipationRequest;
import com.example.c3.Repository.EventParticipationRequestRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/event-participation-request")
public class EventParticipationRequestController {
    private final EventParticipationRequestRepository eventParticipationRequestRepository;

    @GetMapping("/get")
    public ResponseEntity getAllEventParticipationRequests() {
        List<EventParticipationRequest> eventParticipationRequests = eventParticipationRequestRepository.findAll();
        return ResponseEntity.status(200).body(eventParticipationRequests);
    }

}
