package com.grh.controllers;

import org.springframework.data.domain.Page;

import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.grh.dao.services.ContactService;
import com.grh.model.dto.ContactDTO;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/contacts")
@RequiredArgsConstructor
public class ContactController {
	private final ContactService contactService;
	
	  @GetMapping("/{id}")
	    public ResponseEntity<ContactDTO> getContactById(@PathVariable Long id) {
	        ContactDTO contactDTO = contactService.getContactById(id);
	        return ResponseEntity.ok(contactDTO);
	    }

	    @GetMapping
	    public ResponseEntity<Page<ContactDTO>> getAllContacts(Pageable pageable) {
	        Page<ContactDTO> contacts = contactService.getAllContacts(pageable);
	        return ResponseEntity.ok(contacts);
	    }

	    @PostMapping
	    public ResponseEntity<ContactDTO> createContact(@RequestBody ContactDTO contactDTO) {
	        ContactDTO createdContact = contactService.createContact(contactDTO);
	        return ResponseEntity.status(HttpStatus.CREATED).body(createdContact);
	    }

	    @PutMapping("/{id}")
	    public ResponseEntity<ContactDTO> updateContact(@PathVariable Long id, @RequestBody ContactDTO contactDTO) {
	        ContactDTO updatedContact = contactService.updateContact(id, contactDTO);
	        return ResponseEntity.ok(updatedContact);
	    }

	    @DeleteMapping("/{id}")
	    public ResponseEntity<Void> deleteContact(@PathVariable Long id) {
	        contactService.deleteContact(id);
	        return ResponseEntity.noContent().build();
	    }
}
