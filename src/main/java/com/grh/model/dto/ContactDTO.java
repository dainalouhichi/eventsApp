package com.grh.model.dto;
import jakarta.validation.constraints.NotBlank;

import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ContactDTO {
	private Long id;
	@NotBlank(message = "le nom est obligatoire")
	private String nom;
	@NotBlank(message = "le prenom est obligatoire")
	private String prenom;
	@NotBlank(message = "le telephone est obligatoire")
	@Size(min = 8, max = 14, message = "veuillez donner un numéro valide")
	private String telephone;
	@NotBlank
    private String adresse;

}
