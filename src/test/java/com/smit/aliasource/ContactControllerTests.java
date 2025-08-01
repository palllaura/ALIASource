package com.smit.aliasource;

import com.smit.aliasource.controller.ContactController;
import com.smit.aliasource.entity.Contact;
import com.smit.aliasource.service.ContactService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@SpringBootTest
class ContactControllerTests {

	private ContactService service;
	private ContactController controller;
	private Contact contact;

	@BeforeEach
	void setUp() {
		service = mock(ContactService.class);
		controller = new ContactController(service);
	}

	/**
	 * Helper method to create test contact.
	 * @return contact.
	 */
	private Contact createTestContact() {
		contact = new Contact("Aliisa", "Sära", "Särin", "53333333");
		contact.setId(55L);
		return contact;
	}

	@Test
	void getAllContactsCallsCorrectMethodInService() {
		controller.getAllContacts();
		verify(service, times(1)).getAllContacts();
	}

	@Test
	void getAllContactsNoContactsResultsEmptyList() {
		when(service.getAllContacts()).thenReturn(List.of());
		List<Contact> result = controller.getAllContacts();
		Assertions.assertTrue(result.isEmpty());
	}

	@Test
	void getAllContactsReturnsCorrectContacts() {
		contact = createTestContact();
		when(service.getAllContacts()).thenReturn(List.of(contact));
		List<Contact> result = controller.getAllContacts();
		Assertions.assertTrue(result.contains(contact));
	}

}
