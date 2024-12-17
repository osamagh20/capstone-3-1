package com.example.c3.Controller;

import com.example.c3.ApiResponse.ApiResponse;
import com.example.c3.Model.Athlete;
import com.example.c3.Service.AthleteService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/athlete")
public class AthleteController {
    private final AthleteService athleteService;

    @GetMapping("/get")
    public ResponseEntity getAllAthletes(){
        List<Athlete> athletes = athleteService.getAllAthletes();
        return ResponseEntity.status(200).body(athletes);
    }

    @PostMapping("/add")
    public ResponseEntity addAthlete(@RequestBody Athlete athlete){
        athleteService.addAthlete(athlete);
        return ResponseEntity.status(200).body(new ApiResponse("athlete added successfully"));
    }
}
