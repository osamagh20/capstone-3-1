package com.example.c3.Model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Set;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class SponsorProfile {

    @Id
    private Integer id;
    @NotEmpty(message = "Please enter your name")
    @Pattern(regexp = "^[a-zA-Z ]+$",message = "Enter just characters")
    @Column(columnDefinition = "varchar(20) not null")
    private String name;
    @NotEmpty(message = "Please enter your phone number")
    @Pattern(regexp = "^05\\d{8}$",message = "Start with 05 and exactly 10 digits")
    @Column(columnDefinition = "varchar(10) not null unique")
    private String phoneNumber;
    @NotEmpty(message = "Please enter your email")
    @Email
    @Column(columnDefinition = "varchar(30) not null unique")
    private String email;
    @NotEmpty(message = "Please enter your city")
    @Column(columnDefinition = "varchar(15) not null")
    private String city;
    @NotEmpty(message = "Please enter the Certification Record")
    @Pattern(regexp = "^1\\d{9}$",message = "Enter just digits and start with number 1")
    @Column(columnDefinition = "varchar(10) not null unique")
    private String certificateRecord;

    @OneToOne
    @MapsId
    @JsonIgnore
    private Sponsor sponsor;

    @OneToMany
    private Set<SponsorShip> sponsorShipList;

}
