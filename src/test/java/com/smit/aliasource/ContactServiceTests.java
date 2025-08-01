package com.smit.aliasource;

import com.smit.aliasource.repository.ContactRepository;
import com.smit.aliasource.service.ContactService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.mockito.Mockito.mock;

@SpringBootTest
class ContactServiceTests {

	private ContactService service;
	private ContactRepository repository;

	@BeforeEach
	void setUp() {
		repository = mock(ContactRepository.class);
		service = new ContactService(repository);
	}

	@Test
	void contextLoads() {
	}

}
