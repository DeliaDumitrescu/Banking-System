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

    private void setAccountId(String accountId) {
        this.accountId = accountId;
    }

    public Date getDateOfCreation() {
        return dateOfCreation;
    }

    private void setDateOfCreation(Date dateOfCreation) {
        this.dateOfCreation = dateOfCreation;
    }

    public double getBalance() {
        return balance;
    }

    private void setBalance(Double balance) {
        this.balance = balance;
    }

}
