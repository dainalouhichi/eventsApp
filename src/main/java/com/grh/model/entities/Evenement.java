package com.grh.model.entities;

import java.io.Serializable;

import java.util.Date;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Entity
@Data
@EqualsAndHashCode(onlyExplicitlyIncluded = true,callSuper = false)
public class Evenement extends BaseEntity implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Column(nullable=false)
	private Date date;
	@Column(nullable=false)
	private String lieu;
	@Enumerated(EnumType.STRING)
	private DescriptionType type;
	

}
