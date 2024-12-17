package com.example.c3.Model;

import com.example.c3.ApiResponse.ApiException;
import com.example.c3.Repository.AthleteProfileRepository;
import com.example.c3.Repository.AthleteRepository;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class AthleteProfile {
    @Id
    private Integer id;

    @NotEmpty(message = "gender cannot be empty")
    @Column(columnDefinition = "varchar(6) not null")
    private String gender;

    @NotEmpty(message = "city cannot be empty")
    @Column(columnDefinition = "varchar(15) not null")
    private String city;

    @NotEmpty(message = "sport name cannot be empty")
    @Column(columnDefinition = "varchar(15) not null")
    private String sportName;

    //private String achievement;
    //MAKE achivement class

    @OneToOne
    @MapsId // --> to know it will take the id from athlete
    @JsonIgnore
    private Athlete athlete;
}
