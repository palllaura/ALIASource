package com.smit.aliasource;

import com.smit.aliasource.dto.ContactDto;
import com.smit.aliasource.entity.Contact;
import com.smit.aliasource.repository.ContactRepository;
import com.smit.aliasource.service.ContactService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentCaptor;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@SpringBootTest
class ContactServiceTests {

	private ContactService service;
	private ContactRepository repository;
	private Contact contact;
	private ContactDto dto;

	@BeforeEach
	void setUp() {
		repository = mock(ContactRepository.class);
		service = new ContactService(repository);
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
	void getAllContactsCallsCorrectMethodInRepository() {
		service.getAllContacts();
		verify(repository, times(1)).findAll();
	}

	@Test
	void getAllContactsNoContactsResultsEmptyList() {
		when(repository.findAll()).thenReturn(List.of());
		List<Contact> result = service.getAllContacts();
		Assertions.assertTrue(result.isEmpty());
	}

	@Test
	void getAllContactsReturnsCorrectContacts() {
		contact = createTestContact();
		when(repository.findAll()).thenReturn(List.of(contact));
		List<Contact> result = service.getAllContacts();
		Assertions.assertTrue(result.contains(contact));
	}

	@Test
	void testAddContactCorrectTriggersSaveInRepository() {
		dto = createTestDto();
		boolean result = service.saveNewContact(dto);
		verify(repository, times(1)).save(any(Contact.class));
		Assertions.assertTrue(result);
	}

	@Test
	void testAddContactFailsFirstNameIsMissing() {
		dto = createTestDto();
		dto.setFirstName(null);

		boolean result = service.saveNewContact(dto);
		Assertions.assertFalse(result);
	}

	@Test
	void testAddContactFailsAliasIsBlank() {
		dto = createTestDto();
		dto.setAlias("   ");

		boolean result = service.saveNewContact(dto);
		Assertions.assertFalse(result);
	}

	@Test
	void testAddContactFailsPhoneNumberContainsLetters() {
		dto = createTestDto();
		dto.setPhoneNumber("A1234567");

		boolean result = service.saveNewContact(dto);
		Assertions.assertFalse(result);
	}

	@Test
	void testSpecialLettersAndCharactersAreSavedCorrectly() {
		dto = createTestDto();
		dto.setAlias(":Öö-PÕue$?");
		service.saveNewContact(dto);

		ArgumentCaptor<Contact> captor = ArgumentCaptor.forClass(Contact.class);
		verify(repository).save(captor.capture());
		Contact newContact = captor.getValue();

		Assertions.assertEquals(":Öö-PÕue$?", newContact.getAlias());
	}


}
