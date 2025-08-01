package com.smit.aliasource;

import com.smit.aliasource.controller.ContactController;
import com.smit.aliasource.service.ContactService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.mockito.Mockito.mock;

@SpringBootTest
class ContactControllerTests {

	private ContactService service;
	private ContactController controller;

	@BeforeEach
	void setUp() {
		service = mock(ContactService.class);
		controller = new ContactController(service);
	}

	@Test
	void contextLoads() {
	}

}
