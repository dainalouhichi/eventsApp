package com.grh.model.dto;

import com.grh.model.entities.DescriptionType;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data

public class EvenementDTO {
	private Long id;
    @NotBlank
    private String date;
    @NotBlank
    private String lieu;
    @NotBlank
    private String description;
    @NotBlank
	private DescriptionType type;


}
