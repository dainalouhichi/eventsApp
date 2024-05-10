package com.grh.model.entities;

import java.io.Serializable;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Entity
@Data
@EqualsAndHashCode(onlyExplicitlyIncluded = true,callSuper = false)
public class Contact extends BaseEntity implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Column(nullable=false)
	private String nom;
	@Column(nullable=false)
	private String prenom;
	@Column(nullable = false,unique = true)
	private String telephone;
	@Column(nullable=false)
	private String adresse;

}
