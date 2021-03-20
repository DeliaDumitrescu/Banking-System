package Entities;

import Entities.Card.Card;
import Entities.Transaction.Transaction;

import java.util.ArrayList;
import java.util.Date;
import java.util.Locale;
import java.util.UUID;

public class Person {
    private String personId;
    private String nationalId;
    private String name;
    private Date dateOfBirth;
    private String phoneNumber;
    private String email;
    private ArrayList<Account> accounts;
    private ArrayList<Card> cards;

    public Person(String nationalId, String name, Date dateOfBirth, String phoneNumber, String email) {
        this.personId = UUID.randomUUID().toString(); // unique identifier
        this.nationalId = nationalId; // CNP
        this.name = name;
        this.dateOfBirth = dateOfBirth;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.accounts = new ArrayList<>();
        this.cards = new ArrayList<>();
    }

    private String getPersonId() {
        return personId;
    }

    public void setPersonId(String personId) {
        this.personId = personId;
    }

    private String getNationalId() {
        return nationalId;
    }

    public void setNationalId(String nationalId) {
        this.nationalId = nationalId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(Date dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public ArrayList<Card> getCards() {
        return this.cards;
    }

    public void setCards(ArrayList<Card> cards) {
        this.cards = cards;
    }

    public ArrayList<Account> getAccounts() {
        return this.accounts;
    }

    public void setAccounts(ArrayList<Account> accounts) {
        this.accounts = accounts;
    }

    public @Override String toString() {
        String accountsOutput = "---------\n";
        String cardsOutput = "---------\n";

        for(Account account: accounts) {
            accountsOutput = accountsOutput + account + "\n---------\n";
        }

        for(Card card: cards) {
            cardsOutput = cardsOutput + card + "\n---------\n";
        }

        return name.toUpperCase() + '\n' + "Person Id: " + personId + "\nNational Id: " + nationalId +
                "\nDate of birth: " + dateOfBirth + "\nPhone number: " + phoneNumber +
                "\nEmail: " + email + "\nCards:\n " + cardsOutput + "Accounts:\n " + accountsOutput;
    }

}
