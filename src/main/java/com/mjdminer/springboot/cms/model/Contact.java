package com.mjdminer.springboot.cms.model;

import java.util.Arrays;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;

@Entity // This tells Hibernate to make a table out of this class
public class Contact {

    @Id // This makes id the primary key
    @GeneratedValue (strategy = GenerationType.IDENTITY) // This makes id auto-increment
    private int id;

    @NotBlank(message = "First name must not be blank")
    private String firstName;

    @NotBlank(message = "Last name must not be blank")
    private String lastName;

    @NotBlank(message = "Address must not be blank")
    private String address;

    @NotBlank(message = "Email must not be blank")
    @Email(message = "Email must be valid")
    private String email;

    @Pattern(regexp = "\\+63\\d{10}", message = "Contact number must start with +63 and have 13 numbers")
    private String contactNumber;

    // Empty Contact Constructors
    public Contact() {
    }

    // Contact Constructor that will take all fields
    public Contact(int id, String firstName, String lastName, String address, String email, String contactNumber) {
        // super();
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.address = address;
        this.email = email;
        this.contactNumber = contactNumber;
    }
    
    // Contact Constructor that will take a string and split it into first and last name
    public Contact(String string) {
        String[] names = string.split(" ");
        this.firstName = String.join(" ", Arrays.copyOfRange(names, 0, names.length - 1));
        this.lastName = names[names.length - 1];
    }

    // Getters and Setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getContactNumber() {
        return contactNumber;
    }

    public void setContactNumber(String contactNumber) {
        this.contactNumber = contactNumber;
    }

    // toString() method
    @Override
    public String toString() {
        return "Contact [firstName=" + firstName + ", lastName=" + lastName + ", address=" + address + ", email="
                + email + ", contactNumber=" + contactNumber + "]";
    }

}
