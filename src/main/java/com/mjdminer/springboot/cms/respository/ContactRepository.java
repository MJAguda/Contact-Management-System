package com.mjdminer.springboot.cms.respository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.mjdminer.springboot.cms.model.Contact; // Import the Contact class

@Repository
public interface ContactRepository extends JpaRepository<Contact, Integer> {

}
