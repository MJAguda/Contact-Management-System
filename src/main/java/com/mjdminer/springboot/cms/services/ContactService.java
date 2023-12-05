package com.mjdminer.springboot.cms.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.mjdminer.springboot.cms.model.Contact;

@Service
public class ContactService {
    // ArrayList to store contacts
    private static ArrayList<Contact> contacts = new ArrayList<Contact>();

    // count for id for each contact
    private static int count = 0;

    // Hardcoded contacts
    static {
        // Add contacts to ArrayList
        contacts.add(new Contact(++count, "John", "Doe", "123 Main St", "johndoe@gmail.com","+639397503598"));
        contacts.add(new Contact(++count, "Jane", "Doe", "124 Main St", "janedoe@gmail.com","+639999999999"));
        contacts.add(new Contact(++count, "Mark Jayson", "Aguda", "125 Main St", "janedoe@gmail.com","+639999999999"));
    }

    // Method to getAllContacts
    public List<Contact> getAllContacts(){
        return contacts;
    }
}
