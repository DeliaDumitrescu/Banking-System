package Entities;

public class CreditCard extends Card {
    double creditLimit;
    double interest;
    double monthSpendings; // amount spent this month, to be paid from account at the end of the month
    double accumulatedDebt;

    public CreditCard(String number, int cvv, double creditLimit, double interest) {
        super(number, cvv);
        this.creditLimit = creditLimit;
        this.interest = interest;
        this.monthSpendings = 0.0;
        this.accumulatedDebt = 0.0;
    }

    public double getCreditLimit() {
        return creditLimit;
    }

    public double getInterest() {
        return interest;
    }

    public double getMonthSpendings() {
        return monthSpendings;
    }
    
    public double getaccumulatedDebt() {
        return accumulatedDebt;
    }
    
    public void setCreditLimit(double creditLimit) {
        this.creditLimit = creditLimit;
    }
    
    public void setInterest(double interest) {
        this.interest = interest;
    }
    
    public void setMonthSpendings(double monthSpendings) {
        this.monthSpendings = monthSpendings;
    }
    
    public void setaccumulatedDebt(double accumulatedDebt) {
        this.accumulatedDebt = accumulatedDebt;
    }

}
