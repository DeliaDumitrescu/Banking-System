package Entities.Client;

import Entities.Account.Account;
import Entities.Card.Card;
import Entities.Card.CreditCard;
import Entities.Card.DebitCard;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.UUID;

public class Client {
    private String clientId;
    private String nationalId;
    private String name;
    private String phoneNumber;
    private ArrayList<Account> accounts;
    private ArrayList<Card> cards;

    public Client(String nationalId, String name, String phoneNumber) {
        this.clientId = UUID.randomUUID().toString(); // unique identifier
        this.nationalId = nationalId; // CNP
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.accounts = new ArrayList<>();
        this.cards = new ArrayList<>();
    }

    public String getClientId() {
        return clientId;
    }

    public void setClientId(String clientId) {
        this.clientId = clientId;
    }

    public String getNationalId() {
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

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public ArrayList<Account> getAccounts() {
        return this.accounts;
    }

    public void setAccounts(ArrayList<Account> accounts) {
        this.accounts = accounts;
    }

    public ArrayList<Card> getCards() {
        return this.cards;
    }

    public void setCards(ArrayList<Card> cards) {
        this.cards = cards;
    }

    public void openAccount() {
        Account newAccount = new Account();
        accounts.add(newAccount);
    }

    public String openCard() throws IOException {
        Card card;
        BufferedReader reader = new BufferedReader(
                new InputStreamReader(System.in));
        System.out.println("Please enter following info: ");
        System.out.println("Card type (debit or credit)");
        String type = reader.readLine();
        System.out.println("Account id: ");
        String accountId = reader.readLine();
        System.out.println("Number: ");
        String number = reader.readLine();
        System.out.println("CVV: ");
        int cvv = Integer.parseInt((reader.readLine()));
        if(type == "credit") {
            System.out.println("Credit limit: ");
            double creditLimit = Double.parseDouble(reader.readLine());
            System.out.println("Interest: ");
            double interest = Double.parseDouble(reader.readLine());
            card = new CreditCard(accountId, number, cvv, creditLimit, interest);
            cards.add(card);
            return card.getCardId();
        }
        else if(type == "debit") {
            card = new DebitCard(accountId, number, cvv);
            cards.add(card);
            return card.getCardId();
        }
        return null;
    }

    public void showAccounts() {
        for(Account account: accounts) {
            System.out.println(account);
        }
    }

    public @Override String toString() {
        return name.toUpperCase() + '\n' + "Client Id: " + clientId + "\nNational Id: " + nationalId +
                "\nPhone number: " + phoneNumber;
    }

}
