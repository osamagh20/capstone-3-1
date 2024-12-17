package com.example.c3.Model;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Check;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@Entity
@NoArgsConstructor
public class Event {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NotEmpty(message = "Name can't be empty.")
    @Size(min = 4, max = 15, message = "Name length must be between 4-15 characters.")
    @Column(columnDefinition = "varchar(15) not null")
    @Check(constraints = "length(name)>=4")
    private String name;

    @NotNull(message = "Number can't be empty.")
    @Positive(message = "Number must be positive number largern than zero.")
    @Column(columnDefinition = "int not null")
    @Check(constraints = "number>0")
    private Integer number;

    @NotEmpty(message = "Location can't be empty.")
    @Size(min = 4, max = 500, message = "Location length must be between 4-500 characters.")
    @Column(columnDefinition = "varchar(500) not null")
    @Check(constraints = "length(location)>=4")
    private String location;

    @NotNull(message = "Etart date end date can't be empty.")
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Column(columnDefinition = "date")
    private LocalDate startDate;

    @NotNull(message = "End date end date can't be empty.")
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Column(columnDefinition = "date")
    private LocalDate endDate;

    @ManyToOne
    @JsonIgnore
    private Arena arena;

    @ManyToOne
    @JsonIgnore
    private Sponsor sponsor;
}