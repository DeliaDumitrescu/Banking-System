package Entities.Transaction;

import java.util.Date;

public abstract class Transaction {
    protected Date date;
    protected double amount;

    public Transaction(double amount) {
        Date currentDate = new Date();
        this.amount = amount;
    }

    public Date getDate() {
        return date;
    }

    public void setDate() {
        this.date = date;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public abstract void executeTransaction();

    abstract public @Override String toString();
}
