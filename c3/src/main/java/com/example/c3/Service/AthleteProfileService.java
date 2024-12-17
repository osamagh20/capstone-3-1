package com.example.c3.Service;

import com.example.c3.ApiResponse.ApiException;
import com.example.c3.DTO.AthleteDTO;
import com.example.c3.Model.Athlete;
import com.example.c3.Model.AthleteProfile;
import com.example.c3.Repository.AthleteProfileRepository;
import com.example.c3.Repository.AthleteRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AthleteProfileService {
    private final AthleteProfileRepository athleteProfileRepository;
    private final AthleteRepository athleteRepository;

    public List<AthleteProfile> getAllAthleteProfiles() {
        return athleteProfileRepository.findAll();
    }

    public void addAthleteProfile(AthleteDTO athleteDTO) {
        //1. check if the athlete itself exist
        Athlete athlete = athleteRepository.findAthleteById(athleteDTO.getAthlete_id());
        if (athlete == null) {
            throw new ApiException("Athlete Not Found");
        }
        AthleteProfile athleteProfile = new AthleteProfile(null, athleteDTO.getGender(), athleteDTO.getCity(), athleteDTO.getSportName(), athlete);
        athleteProfileRepository.save(athleteProfile);
    }

    public void updateAthleteProfile(AthleteDTO athleteDTO) {
        AthleteProfile athleteProfile = athleteProfileRepository.findAthleteProfileById(athleteDTO.getAthlete_id());
        if(athleteProfile == null){
            throw new ApiException("Athlete Profile Not Found");
        }
        athleteProfile.setCity(athleteDTO.getCity());
        athleteProfile.setSportName(athleteDTO.getSportName());
        athleteProfileRepository.save(athleteProfile);
    }

    // profile is deleted when athlete is deleted
}
