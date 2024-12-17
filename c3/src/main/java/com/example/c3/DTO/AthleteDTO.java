package com.example.c3.DTO;
import jakarta.persistence.Column;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class AthleteDTO {
    private Integer athlete_id;

    @NotEmpty(message = "gender cannot be empty")
    private String gender;

    @NotEmpty(message = "city cannot be empty")
    private String city;

    @NotEmpty(message = "sport name cannot be empty")
    private String sportName;
}
