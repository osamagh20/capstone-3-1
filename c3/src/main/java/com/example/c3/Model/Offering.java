package com.example.c3.Model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Check;

import java.util.Set;

@Data
@AllArgsConstructor
@Entity
@NoArgsConstructor
public class Offering {
    @Id
    private Integer id;

    @NotEmpty(message = "Name can't be empty.")
    @Size(min = 4, max = 15, message = "Name length must be between 4-15 characters.")
    @Column(columnDefinition = "varchar(15) not null")
    @Check(constraints = "length(name)>=4")
    private String name;

    @NotEmpty(message = "Description can't be empty.")
    @Size(min = 20, max = 800, message = "Description length must be between 20-800 characters.")
    @Column(columnDefinition = "varchar(800) not null")
    @Check(constraints = "length(description)>=20")
    private String description;

    @NotEmpty(message = "Availability can't be empty.")
    @Pattern(regexp = "^(?i)(Available|Not Available)$")
    @Column(columnDefinition = "varchar(14) not null")
    @Check(constraints = "availability IN ('Available', 'Not Available')")
    private String availability;

    @NotNull(message = "Price can't be empty.")
    @Positive(message = "Price must be a positive number larger than zero.")
    @Column(columnDefinition = "double not null")
    @Check(constraints = "price>0")
    private Double price;

    @ManyToOne
    @JsonIgnore
    private Arena arena;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "offering")
    @JsonIgnore
    private Set<BookOffering> bookOfferings;
}