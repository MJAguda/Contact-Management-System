package com.mjdminer.springboot.cms;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.ui.ModelMap;

import com.mjdminer.springboot.cms.controller.ContactController;
import com.mjdminer.springboot.cms.model.Contact;
import com.mjdminer.springboot.cms.service.ContactService;

@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
class CmsApplicationTests {

	private ContactService contactService = mock(ContactService.class);
    private ModelMap model = mock(ModelMap.class);
    private ContactController contactController = new ContactController(contactService);

    @Test
    void testListAllContacts() {
        List<Contact> contacts = new ArrayList<>();
        when(contactService.getAllContacts()).thenReturn(contacts);

        String viewName = contactController.listAllContacts(model);

        verify(contactService, times(1)).getAllContacts();
        verify(model, times(1)).addAttribute("contacts", contacts);
        assertEquals("index", viewName);
    }

	@Test
    void testShowNewContactPage() {
        String viewName = contactController.showNewContactPage(model);
        assertEquals("contact", viewName);
    }

	// @Test
    // void testAddNewContactPage() {
    //     Contact contact = new Contact(1, "John", "Doe", "123 Street", "john@example.com", "+1234567890");

    //     String viewName = contactController.addNewContactPage(contact);

    //     verify(contactService, times(1)).addContact(contact.getFirstName(), contact.getLastName(), contact.getAddress(),
    //             contact.getEmail(), contact.getContactNumber());
    //     assertEquals("redirect:/", viewName);
    // }
}