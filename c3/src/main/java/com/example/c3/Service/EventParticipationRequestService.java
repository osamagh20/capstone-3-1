package com.example.c3.Service;

import com.example.c3.Model.EventParticipationRequest;
import com.example.c3.Repository.EventParticipationRequestRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class EventParticipationRequestService {
    private final EventParticipationRequestRepository eventParticipationRequestRepository;

    public List<EventParticipationRequest> getAllEventParticipationRequests() {
        return eventParticipationRequestRepository.findAll();
    }
}
