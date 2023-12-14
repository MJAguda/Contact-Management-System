package com.mjdminer.springboot.cms.respository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mjdminer.springboot.cms.model.Contact; // Import the Contact class


public interface ContactRepository extends JpaRepository<Contact, Integer> {
    
}
