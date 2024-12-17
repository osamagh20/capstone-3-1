package com.example.c3.Service;

import com.example.c3.ApiResponse.ApiException;
import com.example.c3.DTO.OfferingDTO;
import com.example.c3.Model.Offering;
import com.example.c3.Repository.OfferingRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class OfferingService {
    // 1. Declare a dependency for OfferingRepository using Dependency Injection
    private final OfferingRepository offeringRepository;

    // 2. CRUD
    // 2.1 GET
    public List<OfferingDTO> getAllOfferings() {
        List<Offering> offerings = offeringRepository.findAll();
        List<OfferingDTO> offeringDTOS = new ArrayList<>();
        for (Offering offering : offerings) {
            OfferingDTO offeringDTO = new OfferingDTO(offering.getName(),offering.getDescription(),offering.getAvailability(),offering.getPrice());
            offeringDTOS.add(offeringDTO);
        }
        return offeringDTOS;
    }

    // 2.2 POST
    public void addOffering(Offering offering) {
        offeringRepository.save(offering);
    }

    // 2.3 UPDATE
    public void updateOffering(Integer id, Offering offering) {
        Offering oldOffering = offeringRepository.findOfferingById(id);
        if (oldOffering == null) {
            throw new ApiException("Offering Not Found.");
        }
        oldOffering.setName(offering.getName());
        oldOffering.setDescription(offering.getDescription());
        oldOffering.setAvailability(offering.getAvailability());
        oldOffering.setPrice(oldOffering.getPrice());
        offeringRepository.save(oldOffering);
    }

    // 2.4 DELETE
    public void deleteOffering(Integer id) {
        Offering oldOffering = offeringRepository.findOfferingById(id);
        if (oldOffering == null) {
            throw new ApiException("Offering Not Found.");
        }
        offeringRepository.delete(oldOffering);
    }
}