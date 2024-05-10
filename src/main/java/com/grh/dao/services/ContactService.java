package com.grh.dao.services;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.grh.model.dto.ContactDTO;


public interface ContactService {
	 ContactDTO getContactById(Long id);
	 Page<ContactDTO> getAllContacts(Pageable pageable);
	 ContactDTO createContact(ContactDTO contactDTO);
	 ContactDTO updateContact(Long id, ContactDTO contactDTO);
	 void deleteContact(Long id);
	
	

}
