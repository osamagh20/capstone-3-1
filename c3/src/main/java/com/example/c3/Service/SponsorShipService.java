package com.example.c3.Service;

import com.example.c3.Model.SponsorShip;
import com.example.c3.Repository.SponsorShipRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class SponsorShipService {
    private final SponsorShipRepository sponsorShipRepository;

    public List<SponsorShip> getAllSponsorShips() {
        return sponsorShipRepository.findAll();
    }
}
