package com.example.c3.Service;

import com.example.c3.Repository.EventRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class EventService {
    // 1. Declare a dependency for EventRepository using Dependency Injection
    private final EventRepository eventRepository;

    // 2.CRUD
    // 2.1 GET
    
}