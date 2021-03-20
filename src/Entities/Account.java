package Entities;

import java.util.Date;
import java.util.UUID;

public class Account {
    private String accountId;
    private Date dateOfCreation;
    private Double balance;

    public Account() {
        this.accountId = UUID.randomUUID().toString();
        this.dateOfCreation = new Date();
        this.balance = 0.0;
    }

    public String getAccountId() {
        return accountId;
    }

    public void setAccountId(String accountId) {
        this.accountId = accountId;
    }

    public Date getDateOfCreation() {
        return dateOfCreation;
    }

    public void setDateOfCreation(Date dateOfCreation) {
        this.dateOfCreation = dateOfCreation;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(Double balance) {
        this.balance = balance;
    }

    public void retrieve(double amount) {
        this.balance -= amount;
    }

    public void add(double amount) {
        this.balance += amount;
    }
}
