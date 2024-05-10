package com.grh.dao.repositeries;

import org.springframework.data.jpa.repository.JpaRepository;

import com.grh.model.entities.Contact;


public interface ContactRepository extends JpaRepository<Contact, Long> {

}
