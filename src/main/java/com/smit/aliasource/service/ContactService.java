package com.smit.aliasource.service;

import com.smit.aliasource.entity.Contact;
import com.smit.aliasource.repository.ContactRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ContactService {
    private final ContactRepository repository;

    /**
     * Contact service constructor.
     * @param repository Contact repository associated with service.
     */
    public ContactService(ContactRepository repository) {
        this.repository = repository;
    }

    /**
     * Get all contacts saved in database.
     * @return all contacts in a list.
     */
    public List<Contact> getAllContacts() {
        return repository.findAll();
    }


}
