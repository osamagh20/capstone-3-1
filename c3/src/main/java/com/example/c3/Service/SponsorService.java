package com.example.c3.Service;

import com.example.c3.ApiResponse.ApiException;
import com.example.c3.DTO.SponsorProfileDTO;
import com.example.c3.Model.*;
import com.example.c3.Repository.*;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class SponsorService {
    private final SponsorRepository sponsorRepository;
    private final AthleteRepository athleteRepository;
    private final SponsorShipRepository sponsorShipRepository;
    private final ArenaRepository arenaRepository;
    private final EventHeldRequestRepository eventHeldRequestRepository;
    private final EventParticipationRequestRepository eventParticipationRequestRepository;

    public List<Sponsor> getAllSponsor() {
        return sponsorRepository.findAll();
    }

    public List<SponsorProfileDTO> getSponsorProfile() {
        List<Sponsor> sponsors = sponsorRepository.findAll();
        List<SponsorProfileDTO> sponsorDTOS = new ArrayList<>();
        for (Sponsor sponsor : sponsors) {
            SponsorProfileDTO sponsorDTO = new SponsorProfileDTO(sponsor.getId(),sponsor.getName(),sponsor.getPhoneNumber(),sponsor.getEmail(),sponsor.getCity(),sponsor.getCertificateRecord(),null,sponsor.getSponsorShipList());
            sponsorDTOS.add(sponsorDTO);
        }
        return sponsorDTOS;
    }

    public void addSponsor(Sponsor sponsor) {
        sponsorRepository.save(sponsor);
    }

    public void updateSponsor(Integer id,Sponsor sponsor) {
        Sponsor oldSponsor = sponsorRepository.findSponsorById(id);
        if(oldSponsor == null) {
            throw new ApiException("Sponsor not found");
        }
        oldSponsor.setName(sponsor.getName());
        oldSponsor.setCity(sponsor.getCity());
        oldSponsor.setEmail(sponsor.getEmail());
        oldSponsor.setPhoneNumber(sponsor.getPhoneNumber());
        sponsorRepository.save(oldSponsor);
    }

    public void deleteSponsor(Integer id) {
        Sponsor sponsor = sponsorRepository.findSponsorById(id);
        sponsorRepository.delete(sponsor);

    }

    // sponsor send sponsorship request to athlete
    public void sponsorAthlete(SponsorShip sponsorShip) {
        Sponsor sponsor = sponsorRepository.findSponsorById(sponsorShip.getAthleteSponsor().getId());
        if(sponsor == null) {
            throw new ApiException("Sponsor not found");
        }
        Athlete athlete = athleteRepository.findAthleteById(sponsorShip.getAthlete().getId());
        if(athlete == null) {
            throw new ApiException("Athlete not found");
        }
        sponsorShip.setStatus("Pending");
        sponsorShipRepository.save(sponsorShip);
    }

    // sponsor request event from arena
    public void requestEvent(EventHeldRequest eventRequest) {
        Sponsor sponsor = sponsorRepository.findSponsorById(eventRequest.getRequestSponsor().getId());
        if(sponsor == null) {
            throw new ApiException("Sponsor not found");
        }
        Arena arena =  arenaRepository.findArenaById(eventRequest.getArena().getId());
        if(arena == null) {
            throw new ApiException("Arena not found");
        }

        eventRequest.setStatus("requested");
        eventHeldRequestRepository.save(eventRequest);
    }

    // sponsor accept the event participation request from athlete
    public void acceptEventParticipation(Integer sponsor_id,Integer participationRequestId) {
        Sponsor sponsor = sponsorRepository.findSponsorById(sponsor_id);
        if(sponsor == null) {
            throw new ApiException("Sponsor not found");
        }
        EventParticipationRequest participationRequest = eventParticipationRequestRepository.findEventParticipationRequestById(participationRequestId);
        if(participationRequest == null) {
            throw new ApiException("Participation request not found");
        }
        if (participationRequest.getStatus().equals("requested")) {
            participationRequest.setStatus("accepted");
            eventParticipationRequestRepository.save(participationRequest);
        }


    }


}
