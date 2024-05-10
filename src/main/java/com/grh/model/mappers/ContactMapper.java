package com.grh.model.mappers;

import org.modelmapper.ModelMapper;

import com.grh.model.dto.ContactDTO;
import com.grh.model.entities.Contact;


public class ContactMapper {
	private static final ModelMapper modelMapper=new ModelMapper();

	 
	 public static ContactDTO toDTO(Contact user) {
	        return modelMapper.map(user, ContactDTO.class);
	    }
	 
	 public static Contact toEntity(ContactDTO userDTO) {
	        return modelMapper.map(userDTO, Contact.class);
	    }
	


}
