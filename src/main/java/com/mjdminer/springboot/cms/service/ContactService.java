package com.mjdminer.springboot.cms.service;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.mjdminer.springboot.cms.model.Contact;

@Service
public class ContactService {
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
        return contacts;
    }

    // Method to addContact
    public void addContact(String firstName, String lastName, String address, String email, String contactNumber) {
        Contact contact = new Contact(++count, firstName, lastName, address, email, contactNumber);
        contacts.add(contact);
    }

    // Method to deleteContactById
    public void deleteContactById(int id) {
        Predicate<? super Contact> predicate = contact -> contact.getId() == id;
        contacts.removeIf(predicate);
    }

    // Method to findById
    public Contact findById(int id) {
        Predicate<? super Contact> predicate = contact -> contact.getId() == id;
        Contact contact = contacts.stream().filter(predicate).findFirst().get();
        return contact;
    }

    // Method to updateContact
    public void updateContact(Contact contact) {
        deleteContactById(contact.getId());
        contacts.add(contact);
    }

    // Method to filterContacts
    public List<Contact> filterContacts(String query) {
        return contacts.stream()
                .filter(contact -> contact.getFirstName().toLowerCase().contains(query.toLowerCase())
                                || contact.getLastName().toLowerCase().contains(query.toLowerCase())
                                || contact.getAddress().toLowerCase().contains(query.toLowerCase())
                                || contact.getEmail().toLowerCase().contains(query.toLowerCase())
                                || contact.getContactNumber().toLowerCase().contains(query.toLowerCase()))
                .collect(Collectors.toList());
    }
}
