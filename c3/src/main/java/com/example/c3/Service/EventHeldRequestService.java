package com.example.c3.Service;

import com.example.c3.Model.EventHeldRequest;
import com.example.c3.Repository.EventHeldRequestRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class EventHeldRequestService {
    private final EventHeldRequestRepository eventHeldRequestRepository;

    public List<EventHeldRequest> getAllEventHeldRequests() {
        return eventHeldRequestRepository.findAll();
    }
}
