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

    void executeTransaction() {
        account.add(amount);
    }
}
