package com.mjdminer.springboot.cms.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.mjdminer.springboot.cms.model.Contact;
import com.mjdminer.springboot.cms.services.ContactService;

@Controller
public class ContactController {
    private ContactService contactService;

    public ContactController(ContactService contactService) {
        super();
        this.contactService = contactService;
    }

    // GetMapping for localhost:8080/
    @GetMapping("/")
    public String listAllContacts(ModelMap model) {
        List<Contact> contacts = contactService.getAllContacts();
        model.addAttribute("contacts", contacts);
        // return to index.html
        return "index";
    }

    // GetMapping for localhost:8080/add-contact
    @GetMapping("/add-contact")
    public String showNewContactPage(ModelMap model) {
        // return to contact.html
        return "contact";
    }

    // PostMapping for localhost:8080/add-contact
    @PostMapping("/add-contact")
    public String addNewContactPage(@ModelAttribute("contact") Contact contact) {
        contactService.addContact(contact.getFirstName(), contact.getLastName(), contact.getAddress(),
                contact.getEmail(), contact.getContactNumber());
        return "redirect:/";
    }

    // @RequestMapping("/list-contact")
    // public List<Contact> listAllContacts(ModelMap model){
    // List<Contact> contacts = contactService.getAllContacts();
    // model.addAttribute("contacts", contacts);
    // //return to list-contacts.html
    // return contacts;
    // }
}
