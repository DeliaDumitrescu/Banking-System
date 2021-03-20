package Entities.Transaction;

import Entities.Account;

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

    void executeTransaction() {
        account.retrieve(amount);
    }

}
