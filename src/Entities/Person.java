package Entities;

import java.util.Date;
import java.util.UUID;

public class Person {
    private String personId;
    private String nationalId;
    private String name;
    private Date dateOfBirth;
    private String phoneNumber;
    private String email;

    Person(String nationalId, String name, Date dateOfBirth, String phoneNumber, String email) {
        this.personId = UUID.randomUUID().toString(); // unique identifier
        this.nationalId = nationalId; // CNP
        this.name = name;
        this.dateOfBirth = dateOfBirth;
        this.phoneNumber = phoneNumber;
        this.email = email;
    }

    private String getPersonId() {
        return personId;
    }

    private String getNationalId() {
        return nationalId;
    }

    public String getName() {
        return name;
    }

    public Date getDateOfBirth() {
        return dateOfBirth;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setPersonId(String personId) {
        this.personId = personId;
    }

    public void setNationalId(String nationalId) {
        this.nationalId = nationalId;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDateOfBirth(Date dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
