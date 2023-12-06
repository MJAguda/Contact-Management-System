package com.mjdminer.springboot.cms;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.ui.ModelMap;

import com.mjdminer.springboot.cms.controller.ContactController;
import com.mjdminer.springboot.cms.model.Contact;
import com.mjdminer.springboot.cms.services.ContactService;

@SpringBootTest
class CmsApplicationTests {

	@Test
    void testListAllContacts() {
        // Create a mock instance of the ContactService
        ContactService contactService = mock(ContactService.class);

        // Create a test instance of the ContactController
        ContactController contactController = new ContactController(contactService);

        // Create a mock instance of the ModelMap
        ModelMap model = mock(ModelMap.class);

        // Create a test list of contacts
        List<Contact> contacts = List.of(new Contact("John Doe"), new Contact("Jane Smith"));

        // Set up the mock behavior of the contactService.getAllContacts() method
        when(contactService.getAllContacts()).thenReturn(contacts);

        // Call the method under test
        String result = contactController.listAllContacts(model);

        // Verify that the contactService.getAllContacts() method was called once
        verify(contactService, times(1)).getAllContacts();

        // Verify that the "contacts" attribute was added to the model with the correct value
        verify(model, times(1)).addAttribute("contacts", contacts);

        // Verify that the method returned the expected view name
        assertEquals("index", result);
    }

}
