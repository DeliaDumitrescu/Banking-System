package Entities.Account;

import Entities.Account.Account;

import java.util.Date;

public class AccountStatement {
    private Account account;
    private Date date;

    public AccountStatement(Account account) {
        this.account = account;
        this.date = new Date();
    }

    public Account getAccount() {
        return account;
    }

    public void setAccount(Account account) {
        this.account = account;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public @Override String toString() {
        return "Date: " + date + " Account: " + account;
    }
}
