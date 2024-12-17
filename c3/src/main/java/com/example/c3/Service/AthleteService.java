package com.example.c3.Service;

import com.example.c3.ApiResponse.ApiException;
import com.example.c3.Model.Athlete;
import com.example.c3.Model.AthleteProfile;
import com.example.c3.Repository.AthleteProfileRepository;
import com.example.c3.Repository.AthleteRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AthleteService {
    private final AthleteRepository athleteRepository;
    private final AthleteProfileRepository athleteProfileRepository;


    public List<Athlete> getAllAthletes(){
        return athleteRepository.findAll();
    }

//    public List<AthleteOutDTO> getAllAthletes(){
//        List<Athlete> athletes = athleteRepository.findAll();
//        List<AthleteOutDTO> athleteOutDTOS = new ArrayList<>();
//        for(Athlete a : athletes){
//            AthleteOutDTO athleteOutDTO = new AthleteOutDTO(a.getFullName(), a.getPhoneNumber(), a.getEmail(), a.getAge(), )
//        }
//    }

    public void addAthlete(Athlete athlete){
        athleteRepository.save(athlete);
    }

    public void updateAthlete(Integer id, Athlete athlete){
        Athlete oldAthlete = athleteRepository.findAthleteById(id);
        if(oldAthlete==null){
            throw new ApiException("athlete not found");
        }
        oldAthlete.setFullName(athlete.getFullName());
        oldAthlete.setPhoneNumber(athlete.getPhoneNumber());
        oldAthlete.setEmail(athlete.getEmail());
        oldAthlete.setAge(athlete.getAge());
        athleteRepository.save(oldAthlete);
    }

    public void deleteAthlete(Integer id){
        Athlete athlete = athleteRepository.findAthleteById(id);
        if(athlete == null){
            throw  new ApiException("athlete not found");
        }
        AthleteProfile athleteProfile = athleteProfileRepository.findAthleteProfileById(athlete.getId());
        athlete.setAthleteProfile(null);
        athleteProfileRepository.delete(athleteProfile);
        athleteRepository.delete(athlete);
    }

    //public void requestCoach
}
