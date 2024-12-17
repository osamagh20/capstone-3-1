package com.example.c3.DTO;

import jakarta.persistence.Column;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.hibernate.annotations.Check;

@Data
@AllArgsConstructor
public class OfferingDTO {
    private String name;

    private String description;

    private String availability;

    private Double price;
}