package com.mjdminer.springboot.cms.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.mjdminer.springboot.cms.model.Contact;
import com.mjdminer.springboot.cms.service.ContactService;

@Controller
public class ContactController {
    private ContactService contactService;

    public ContactController(ContactService contactService) {
        super();
        this.contactService = contactService;
    }

    /**
     * Retrieves a list of all contacts and adds them to the model.
     * 
     * @param model the model to add the contacts to
     * @return the name of the view to render
     */
    @GetMapping("/")
    public String listAllContacts(ModelMap model) {
        List<Contact> contacts = contactService.getAllContacts();
        model.addAttribute("contacts", contacts);
        // return to index.html
        return "index";
    }

    // GetMapping for localhost:8080/add-contact
    /**
     * Shows the new contact page.
     * 
     * @param model the model map
     * @return the name of the contact.html template
     */
    @GetMapping("/add-contact")
    public String showNewContactPage(ModelMap model) {
        // return to contact.html
        return "contact";
    }

    // PostMapping for localhost:8080/add-contact
    /**
     * Adds a new contact to the system and redirects to the home page.
     *
     * @param contact the contact object containing the contact details
     * @return a string representing the redirect URL
     */
    @PostMapping("/add-contact")
    public String addNewContactPage(@ModelAttribute("contact") Contact contact) {
        contactService.addContact(contact.getFirstName(), contact.getLastName(), contact.getAddress(),
                contact.getEmail(), contact.getContactNumber());
        return "redirect:/";
    }

    // GetMapping for localhost:8080/delete-contact?id=
    @GetMapping("/delete-contact")
    public String deleteContact(@RequestParam int id) {
        contactService.deleteContactById(id);
        return "redirect:/";
    }

    @GetMapping("/update-contact")
    public String showUpdateContactPage(@RequestParam int id, ModelMap model) {
        Contact contact = contactService.findById(id);
        model.addAttribute("contact", contact);

        // return to contact.html
        return "contact";
    }

}
