package com.grh.dao.services;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import com.grh.dao.repositeries.ContactRepository;
import com.grh.model.dto.ContactDTO;
import com.grh.model.entities.Contact;
import com.grh.model.mappers.ContactMapper;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor

public class ContactServiceImplementation  implements ContactService{
	private final ContactRepository contactRepo;


	
	@Override
	public ContactDTO getContactById(Long id) {
		// TODO Auto-generated method stub
		return ContactMapper.toDTO(contactRepo.findById(id).orElse(null));
	}

	@Override
	public Page<ContactDTO> getAllContacts(Pageable pageable) {
		// TODO Auto-generated method stub
		Page<Contact> contacts = contactRepo.findAll(pageable);

		return contacts.map(ContactMapper::toDTO);
	}

	@Override
	public ContactDTO createContact(ContactDTO contactDTO) {
		// TODO Auto-generated method stub
		Contact saved=contactRepo.save(ContactMapper.toEntity(contactDTO));
		return ContactMapper.toDTO(saved);
	}

	@Override
	public ContactDTO updateContact(Long id, ContactDTO contactDTO) {
		// TODO Auto-generated method stub
		Contact saved=contactRepo.findById(id).orElse(null);
		return ContactMapper.toDTO(saved);
	}

	@Override
	public void deleteContact(Long id) {
		// TODO Auto-generated method stub
		contactRepo.deleteById(id);
	}

}
