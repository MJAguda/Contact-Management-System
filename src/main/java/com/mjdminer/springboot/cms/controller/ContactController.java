package com.mjdminer.springboot.cms.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mjdminer.springboot.cms.model.Contact;
import com.mjdminer.springboot.cms.services.ContactService;

@Controller
public class ContactController {
    private ContactService contactService;

    public ContactController(ContactService contactService){
        super();
        this.contactService = contactService;
    }

    
    // Mapping for localhost:8080/list-contacts
    @RequestMapping("/list-contacts")
    public List<Contact> listAllContacts(ModelMap model){
        List<Contact> contacts = contactService.getAllContacts();
        model.addAttribute("contacts", contacts);
        //return to list-contacts.html
        return contacts;
    }
}
