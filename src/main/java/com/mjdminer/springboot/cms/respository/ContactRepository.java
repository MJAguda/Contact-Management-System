package com.mjdminer.springboot.cms.respository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.mjdminer.springboot.cms.model.Contact; // Import the Contact class
import java.util.List;


public interface ContactRepository extends JpaRepository<Contact, Integer> {
    
}
