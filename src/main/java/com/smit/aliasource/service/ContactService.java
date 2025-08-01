package com.smit.aliasource.service;

import com.smit.aliasource.dto.ContactDto;
import com.smit.aliasource.entity.Contact;
import com.smit.aliasource.repository.ContactRepository;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.logging.Logger;

@Service
public class ContactService {
    private static final java.util.logging.Logger LOGGER = Logger.getLogger(ContactService.class.getName());
    private final ContactRepository repository;

    /**
     * Contact service constructor.
     *
     * @param repository Contact repository associated with service.
     */
    public ContactService(ContactRepository repository) {
        this.repository = repository;
    }

    /**
     * Get all contacts saved in database.
     *
     * @return all contacts in a list.
     */
    public List<Contact> getAllContacts() {
        return repository.findAll();
    }

    /**
     * Save new contact if data is valid.
     *
     * @param dto Contact data.
     * @return true if contact was saved, else false.
     */
    public boolean saveNewContact(ContactDto dto) {
        if (!validateContactDto(dto)) return false;

        Contact contact = new Contact(dto.getFirstName(), dto.getLastName(), dto.getAlias(), dto.getPhoneNumber());

        try {
            repository.save(contact);
        } catch (Exception e) {
            LOGGER.warning(e.getMessage());
            return false;
        }

        String message = String.format("Added new contact: %1$s (%2$s) %3$s",
                contact.getFirstName(), contact.getLastName(), contact.getAlias());
        LOGGER.info(message);
        return true;
    }

    /**
     * Validate if all input fields are correct.
     * @param dto data to validate.
     * @return true if valid, else false.
     */
    private boolean validateContactDto(ContactDto dto) {
        if (dto.getFirstName() == null || dto.getFirstName().isBlank()
                || dto.getLastName() == null || dto.getLastName().isBlank()
                || dto.getAlias() == null || dto.getAlias().isBlank()
                || dto.getPhoneNumber() == null || dto.getPhoneNumber().isBlank()) {
            LOGGER.info("Validation failed because one of the fields is missing or blank.");
            return false;
        }

        if(!dto.getPhoneNumber().matches("^\\d{7,11}$")) {
            LOGGER.info("Validation failed because phone number is incorrect.");
            return false;
        }
        return true;
    }

    /**
     * Delete contact from database.
     * @param id ID of contact to delete.
     * @return true if contact was deleted, false if not found or error.
     */
    public boolean deleteContactById(Long id) {
        try {
            repository.deleteById(id);
            return true;
        } catch (EmptyResultDataAccessException e) {
            LOGGER.warning("Error while deleting contact: contact not found");
            return false;
        } catch (Exception e) {
            LOGGER.warning("Unexpected error while deleting contact: " + e.getMessage());
            return false;
        }
    }


}
