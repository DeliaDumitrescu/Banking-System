package Entities.Account;

import Entities.Transaction.Transaction;

import java.util.ArrayList;

public class AccountService {
    private Account account;

    public AccountService(Account account) {
        this.account = account;
    }

    public Account getAccount() {
        return account;
    }

    public void setAccount(Account account) {
        this.account = account;
    }

    public void addTransaction(Transaction transaction) {
        ArrayList<Transaction> transactions = account.getTransactions();
        transactions.add(transaction);
        account.setTransactions(transactions);
    }

    public void showTransactions() {
        for(Transaction transaction: account.getTransactions()){
            System.out.println(transaction);
        }
    }
}
