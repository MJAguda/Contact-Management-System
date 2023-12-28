package com.mjdminer.springboot.cms.service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.mjdminer.springboot.cms.model.Contact;
import com.mjdminer.springboot.cms.respository.ContactRepository;

@Service
public class ContactService {

    @Autowired
    private ContactRepository contactRepository;

    // The pupose of this Constructor is to inject the ContactRepository dependency
    public ContactService(ContactRepository contactRepository) {
        super();
        this.contactRepository = contactRepository;
    }

    // ArrayList to store contacts
    private static List<Contact> contacts = new ArrayList<Contact>();

    // count for id for each contact
    private static int count = 0;

    // Hardcoded contacts
    static {
        // Add contacts to ArrayList

        contacts.add(new Contact(++count, "John", "Doe", "123 Main St", "john.doe@example.com", "123-456-7890"));
        contacts.add(new Contact(++count, "Bob", "Smith", "789 Elm St", "bob.smith@example.com", "555-123-4567"));
        contacts.add(new Contact(++count, "Mark Jayson", "Aguda", "125 Main St", "janedoe@gmail.com", "+639999999779"));
        contacts.add(new Contact(++count, "Eva", "Miller", "567 Pine Rd", "eva.miller@example.com", "222-789-4561"));

    }

    // Method to getAllContacts
    public List<Contact> getAllContacts() {
        return contactRepository.findAll();
    }

    // Method to addContact
    public void addContact(String firstName, String lastName, String address, String email, String contactNumber) {
        Contact contact = new Contact();
        contact.setFirstName(firstName);
        contact.setLastName(lastName);
        contact.setAddress(address);
        contact.setEmail(email);
        contact.setContactNumber(contactNumber);

        // contacts.add(contact);
        contactRepository.save(contact);
    }

    // Method to deleteContactById
    public void deleteContactById(int id) {
        // Predicate<? super Contact> predicate = contact -> contact.getId() == id;
        // contacts.removeIf(predicate);
        contactRepository.deleteById(id);
    }

    // Method to findById
    public Contact findById(int id) {
        // Predicate<? super Contact> predicate = contact -> contact.getId() == id;
        // Contact contact = contacts.stream().filter(predicate).findFirst().get();
        Contact contact = contactRepository.findById(id).get();
        return contact;
    }

    // Method to updateContact
    public void updateContact(Contact contact) {
        deleteContactById(contact.getId());
        contactRepository.save(contact);
    }

    // Method to filterContacts
    public List<Contact> filterContacts(String query) {
        return contactRepository.findAll().stream()
                .filter(contact -> contact.getFirstName().toLowerCase().contains(query.toLowerCase())
                        || contact.getLastName().toLowerCase().contains(query.toLowerCase())
                        || contact.getAddress().toLowerCase().contains(query.toLowerCase())
                        || contact.getEmail().toLowerCase().contains(query.toLowerCase())
                        || contact.getContactNumber().toLowerCase().contains(query.toLowerCase()))
                .collect(Collectors.toList());
        // return contacts.stream()
        // .filter(contact ->
        // contact.getFirstName().toLowerCase().contains(query.toLowerCase())
        // || contact.getLastName().toLowerCase().contains(query.toLowerCase())
        // || contact.getAddress().toLowerCase().contains(query.toLowerCase())
        // || contact.getEmail().toLowerCase().contains(query.toLowerCase())
        // || contact.getContactNumber().toLowerCase().contains(query.toLowerCase()))
        // .collect(Collectors.toList());
    }

    // Method to findPaginated
    public Page<Contact> findPaginated(int pageNo, int pageSize, String sortField, String sortDirection) {
        Sort sort = sortDirection.equalsIgnoreCase(Sort.Direction.ASC.name()) ? Sort.by(sortField).ascending()
                : Sort.by(sortField).descending();

        Pageable pageable = PageRequest.of(pageNo - 1, pageSize, sort);
        return this.contactRepository.findAll(pageable);
    }

    // Add this method to the ContactService.java
    public Page<Contact> findPaginated(int pageNo, String query, int pageSize, String sortField, String sortDirection) {
        Sort sort = sortDirection.equalsIgnoreCase(Sort.Direction.ASC.name()) ? Sort.by(sortField).ascending()
                : Sort.by(sortField).descending();

        Pageable pageable = PageRequest.of(pageNo - 1, pageSize, sort);

        if (query != null && !query.isEmpty()) {
            return contactRepository
                    .findAllByFirstNameContainingIgnoreCaseOrLastNameContainingIgnoreCaseOrAddressContainingIgnoreCaseOrEmailContainingIgnoreCaseOrContactNumberContainingIgnoreCase(
                            query, query, query, query, query, pageable);
        } else {
            return contactRepository.findAll(pageable);
        }
    }
}
