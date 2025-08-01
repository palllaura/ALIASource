package com.smit.aliasource.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ContactDto {
    String firstName;
    String lastName;
    String alias;
    String phoneNumber;

    /**
     * Constructor for dto.
     * @param firstName first name as string.
     * @param lastName last name as string.
     * @param alias alias as string.
     * @param phoneNumber phone number as string.
     */
    public ContactDto(String firstName, String lastName, String alias, String phoneNumber) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.alias = alias;
        this.phoneNumber = phoneNumber;
    }

}
