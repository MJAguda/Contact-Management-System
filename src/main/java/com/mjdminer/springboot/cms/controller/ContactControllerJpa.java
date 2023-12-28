package com.mjdminer.springboot.cms.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.mjdminer.springboot.cms.model.Contact;
import com.mjdminer.springboot.cms.service.ContactService;

import jakarta.validation.Valid;

@Controller
public class ContactControllerJpa {

    @Autowired
    private ContactService contactService;

    // The pupose of thie Constructor is to inject the ContactService dependency
    public ContactControllerJpa(ContactService contactService) {
        super();
        this.contactService = contactService;
    }

    // GetMapping for localhost:8080/
    @GetMapping("/")
    public String listAllContacts(ModelMap model) {

        // List<Contact> contacts = contactService.getAllContacts();

        // model.addAttribute("contacts", contacts);
        // // return to index.html
        // return "index";
        return findPaginated(1, "", "firstName", "asc", model);
    }

    // GetMapping for localhost:8080/add-contact
    @GetMapping("/add-contact")
    public String showNewContactPage(ModelMap model) {
        // return to contact.html
        return "details";
    }

    // PostMapping for localhost:8080/add-contact
    @PostMapping("/add-contact")
    public String addNewContactPage(@ModelAttribute("contact") @Valid Contact contact, BindingResult result,
            ModelMap model) {

        if (result.hasErrors()) {
            model.addAttribute("errors", result.getAllErrors());
            return "details";
        }

        contactService.addContact(contact.getFirstName(),
                contact.getLastName(),
                contact.getAddress(),
                contact.getEmail(),
                contact.getContactNumber());

        model.addAttribute("successMessage", "Contact successfully added!");
        return "redirect:/";
    }

    // GetMapping for localhost:8080/delete-contact?id=
    @GetMapping("/delete-contact")
    public String deleteContact(@RequestParam int id) {
        contactService.deleteContactById(id);
        return "redirect:/";
    }

    // GetMapping for localhost:8080/update-contact?id=
    @GetMapping("/update-contact")
    public String showUpdateContactPage(@RequestParam int id, ModelMap model) {
        Contact contact = contactService.findById(id);

        model.addAttribute("contact", contact);

        // return to contact.html
        return "details";
    }

    @PostMapping("/update-contact")
    public String updateContact(@ModelAttribute("contact") @Valid Contact contact, BindingResult result,
            ModelMap model) {

        if (result.hasErrors()) {
            model.addAttribute("errors", result.getAllErrors());
            return "details";
        }

        contactService.updateContact(contact);
        return "redirect:/";
    }

    @GetMapping("/details-contact")
    public String showDetailsContactPage(@RequestParam int id, ModelMap model) {
        Contact contact = contactService.findById(id);
        model.addAttribute("contact", contact);

        // return to contact.html
        return "details";
    }

    @PostMapping("/details-contact")
    public String backToIndex() {
        return "redirect:/";
    }

    @GetMapping("/search-contact")
    public String searchContact(ModelMap model, @RequestParam(required = false) String query,
            @RequestParam(defaultValue = "1") int pageNo,
            @RequestParam(defaultValue = "firstName") String sortField,
            @RequestParam(defaultValue = "asc") String sortDir) {

        int pageSize = 4;

        Page<Contact> contacts = contactService.findPaginated(pageNo, query, pageSize, sortField, sortDir);
        List<Contact> allContacts = contactService.filterContacts(query);

        model.addAttribute("currentPage", pageNo);
        model.addAttribute("totalPages", (int) Math.ceil((double) allContacts.size() / pageSize));
        model.addAttribute("totalItems", allContacts.size());
        model.addAttribute("contacts", contacts.getContent());
        model.addAttribute("sortField", sortField);
        model.addAttribute("sortDir", sortDir);
        model.addAttribute("reverseSortDir", sortDir.equals("asc") ? "desc" : "asc");
        model.addAttribute("query", query);

        return "index";
    }

    @GetMapping("/page/{pageNo}")
    public String findPaginated(@PathVariable(value = "pageNo") int pageNo,
            @RequestParam(required = false) String query, @RequestParam("sortField") String sortField, @RequestParam("sortDir") String sortDir, ModelMap model) {

        int pageSize = 4;

        Page<Contact> contacts = contactService.findPaginated(pageNo, query, pageSize, sortField, sortDir);
        List<Contact> allContacts;
        
        if(query != null && !query.isEmpty()){
            allContacts = contactService.filterContacts(query);
        }
        else{
            allContacts = contactService.getAllContacts();
        }
        
        model.addAttribute("currentPage", pageNo);
        model.addAttribute("query", query);
        // model.addAttribute("totalPages", allContacts.size() / pageSize);
        model.addAttribute("totalPages", (int) Math.ceil((double) allContacts.size() / pageSize)); // Adjust totalPages
                                                                                                   // calculation
        model.addAttribute("totalItems", allContacts.size());
        model.addAttribute("contacts", contacts);
        model.addAttribute("sortField", sortField);
        model.addAttribute("sortDir", sortDir);
        model.addAttribute("reverseSortDir", sortDir.equals("asc") ? "desc" : "asc");

        return "index";
    }

}
