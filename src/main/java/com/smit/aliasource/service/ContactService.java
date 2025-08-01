package com.smit.aliasource.service;

import com.smit.aliasource.repository.ContactRepository;
import org.springframework.stereotype.Service;

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
}
