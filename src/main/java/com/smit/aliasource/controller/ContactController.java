package com.smit.aliasource.controller;

import com.smit.aliasource.entity.Contact;
import com.smit.aliasource.service.ContactService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api")
public class ContactController {

    private final ContactService service;

    /**
     * Contact controller constructor.
     * @param service Contact service associated with controller.
     */
    public ContactController(ContactService service) {
        this.service = service;
    }

    /**
     * Get all saved contacts.
     * @return contacts in a list.
     */
    @GetMapping("/contacts")
    public List<Contact> getAllContacts() {
        return service.getAllContacts();
    }
}
