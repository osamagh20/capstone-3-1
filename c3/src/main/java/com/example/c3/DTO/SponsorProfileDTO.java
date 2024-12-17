package com.example.c3.DTO;

import com.example.c3.Model.*;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.Set;

@Data
@AllArgsConstructor
public class SponsorProfileDTO {

    private Integer sponsor_id;
    @NotEmpty(message = "Please enter your name")
    @Pattern(regexp = "^[a-zA-Z ]+$",message = "Enter just characters")
    private String name;
    @NotEmpty(message = "Please enter your phone number")
    @Pattern(regexp = "^05\\d{8}$",message = "Start with 05 and exactly 10 digits")
    private String phoneNumber;
    @NotEmpty(message = "Please enter your email")
    @Email
    private String email;
    @NotEmpty(message = "Please enter your city")
    private String city;
    @NotEmpty(message = "Please enter the Certification Record")
    @Pattern(regexp = "^1\\d{9}$",message = "Enter just digits and start with number 1")
    private String certificateRecord;


    @OneToOne
    @MapsId
    @JsonIgnore
    private Sponsor sponsor;

    @OneToMany(cascade = CascadeType.ALL,mappedBy = "sponsor")
    private Set<SponsorShip> sponsorShipList;

}
