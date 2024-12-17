package com.example.c3.Repository;

import com.example.c3.Model.AthleteProfile;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AthleteProfileRepository extends JpaRepository<AthleteProfile, Integer> {
    AthleteProfile findAthleteProfileById(Integer id);
}
