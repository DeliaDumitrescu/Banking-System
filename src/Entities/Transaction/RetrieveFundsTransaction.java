package Entities.Transaction;

import Entities.Account.Account;

public class RetrieveFundsTransaction extends Transaction {

    private Account account;

    public RetrieveFundsTransaction(double amount, Account account) {
        super(amount);
        this.account = account;
    }

    public Account getAccount() {
        return this.account;
    }

    public void setAccount(Account account) {
        this.account = account;
    }

    public void executeTransaction() {
        account.retrieve(amount, this);
    }

    public @Override String toString() {
        return "";
//        return "Date: " + date + "\nAmount: " + amount + "\nAccount from which money was retrieved: " + account;
    }
}
