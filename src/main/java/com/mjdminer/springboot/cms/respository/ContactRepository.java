package com.mjdminer.springboot.cms.respository;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mjdminer.springboot.cms.model.Contact; // Import the Contact class

@Repository
public interface ContactRepository extends JpaRepository<Contact, Integer> {

    Page<Contact> findAllByFirstNameContainingIgnoreCaseOrLastNameContainingIgnoreCaseOrAddressContainingIgnoreCaseOrEmailContainingIgnoreCaseOrContactNumberContainingIgnoreCase(
            String query, String query2, String query3, String query4, String query5, Pageable pageable);

    public List<Contact> findByUsername(String username);
}
