package com.smit.aliasource.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name = "contacts")
public class Contact {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String firstName;

    @Column(nullable = false)
    private String lastName;

    @Column(nullable = false)
    private String alias;

    @Column(nullable = false)
    private String phoneNumber;

    /**
     * No-args constructor.
     */
    public Contact() {}

    /**
     * Contact constructor.
     * @param firstName first name of contact as string.
     * @param lastName last name of contact as string.
     * @param alias alias as string.
     * @param phoneNumber phone number as string.
     */
    public Contact(String firstName, String lastName, String alias, String phoneNumber) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.alias = alias;
        this.phoneNumber = phoneNumber;
    }
}
