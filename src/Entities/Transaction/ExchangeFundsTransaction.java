package Entities.Transaction;

import Entities.Account;

public class ExchangeFundsTransaction extends Transaction {

    private Account senderAccount, receiverAccount;

    public ExchangeFundsTransaction(double amount, Account senderAccount, Account receiverAccount) {
        super(amount);
        this.senderAccount = senderAccount;
        this.receiverAccount = receiverAccount;
    }

    public Account getSenderAccount() {
        return this.senderAccount;
    }

    public void setSenderAccount(Account senderAccount) {
        this.senderAccount = senderAccount;
    }

    public Account getReceiverAccount() {
        return this.receiverAccount;
    }

    public void setReceiverAccount(Account receiverAccount) {
        this.receiverAccount = receiverAccount;
    }

    void executeTransaction() {
        senderAccount.retrieve(amount);
        receiverAccount.add(amount);
    }
}
