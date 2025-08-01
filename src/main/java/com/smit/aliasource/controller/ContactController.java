package com.smit.aliasource.controller;

import com.smit.aliasource.dto.ContactDto;
import com.smit.aliasource.entity.Contact;
import com.smit.aliasource.service.ContactService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

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

    /**
     * Add new contact.
     * @param input dto with contact data.
     * @return response entity with result message.
     */
    @PostMapping("/add")
    public ResponseEntity<?> addContact(@RequestBody ContactDto input) {
        if (service.saveNewContact(input)) {
            return ResponseEntity.ok(Map.of(
                    "message", "Contact added successfully!"
            ));
        } else {
            return ResponseEntity.badRequest().body(Map.of(
                    "message", "Failed to save contact."
            ));
        }
    }


}
