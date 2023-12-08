package com.mjdminer.springboot.cms.service;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

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
        contacts.add(new Contact(++count, "John", "Doe", "123 Main St", "johndoe@gmail.com", "+639397503598"));
        contacts.add(new Contact(++count, "Jane", "Doe", "124 Main St", "janedoe@gmail.com", "+639999999999"));
        contacts.add(new Contact(++count, "Mark Jayson", "Aguda", "125 Main St", "janedoe@gmail.com", "+639999999779"));
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

    public void deleteContactById(int id) {
        Predicate<? super Contact> predicate = contact -> contact.getId() == id;
        contacts.removeIf(predicate);
    }

    public Contact findById(int id) {
        Predicate<? super Contact> predicate = contact -> contact.getId() == id;
        Contact contact = contacts.stream().filter(predicate).findFirst().get();
        return contact;
    }

    public void updateContact(Contact contact) {
        deleteContactById(contact.getId());
        contacts.add(contact);
    }
}
