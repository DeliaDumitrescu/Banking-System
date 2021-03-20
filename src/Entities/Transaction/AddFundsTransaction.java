package Entities.Transaction;

import Entities.Account;

public class AddFundsTransaction extends Transaction {
    private Account account;

    public AddFundsTransaction(double amount, Account account) {
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
        account.add(amount, this);
    }

    public @Override String toString() {
        return "Date: " + date + " Amount: " + amount + " Account where money was added: " + account;
    }
}
