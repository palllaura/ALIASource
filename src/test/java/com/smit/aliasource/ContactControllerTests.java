package com.smit.aliasource;

import com.smit.aliasource.controller.ContactController;
import com.smit.aliasource.dto.ContactDto;
import com.smit.aliasource.entity.Contact;
import com.smit.aliasource.service.ContactService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.List;
import java.util.Map;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@SpringBootTest
class ContactControllerTests {

	private ContactService service;
	private ContactController controller;
	private Contact contact;
	private ContactDto dto;

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

	/**
	 * Helper method to create contact dto.
	 * @return dto.
	 */
	private ContactDto createTestDto() {
		dto = new ContactDto("Aliisa", "Sära", "Särin", "53333333");
		return dto;
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

	@Test
	void addContactCallsCorrectMethodInService() {
		dto = createTestDto();
		controller.addContact(dto);
		verify(service, times(1)).saveNewContact(dto);
	}

	@Test
	void testAddContactCorrect() {
		dto = createTestDto();

		when(service.saveNewContact(dto)).thenReturn(true);
		ResponseEntity<?> result = controller.addContact(dto);

		Assertions.assertEquals(HttpStatus.OK, result.getStatusCode());

		Map<String, String> expectedBody = Map.of("message", "Contact added successfully!");
		Assertions.assertEquals(expectedBody, result.getBody());
	}

	@Test
	void testAddContactFailure() {
		dto = createTestDto();

		when(service.saveNewContact(dto)).thenReturn(false);
		ResponseEntity<?> result = controller.addContact(dto);

		Assertions.assertEquals(HttpStatus.BAD_REQUEST, result.getStatusCode());
		Map<String, String> expectedBody = Map.of("message", "Failed to save contact.");
		Assertions.assertEquals(expectedBody, result.getBody());
	}

	@Test
	void testDeleteContactSuccess() {
		Long id = 55L;
		when(service.deleteContactById(id)).thenReturn(true);

		ResponseEntity<?> result = controller.deleteContact(id);

		Assertions.assertEquals(HttpStatus.OK, result.getStatusCode());
		Assertions.assertEquals(Map.of("message", "Contact deleted successfully!"), result.getBody());
	}

	@Test
	void testDeleteContactNotFound() {
		Long id = 55L;
		when(service.deleteContactById(id)).thenReturn(false);

		ResponseEntity<?> result = controller.deleteContact(id);

		Assertions.assertEquals(HttpStatus.NOT_FOUND, result.getStatusCode());
		Assertions.assertEquals(Map.of("message", "Contact not found."), result.getBody());
	}

}
