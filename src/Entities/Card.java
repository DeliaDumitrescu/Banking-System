package Entities;

import java.util.Calendar;
import java.util.Date;
import java.util.UUID;

public class Card {
    private String cardId;
    private String number;
    private int cvv;
    private Date expirationDate;

    public Card(String number, int cvv) {
        this.cardId = UUID.randomUUID().toString();
        this.number = number;
        this.cvv = cvv;
        Date currentDate = new Date();
        Calendar c = Calendar.getInstance();
        c.setTime(currentDate);
        c.add(Calendar.YEAR, 3);
        this.expirationDate = c.getTime();
    }

    public String getCardId() {
        return cardId;
    }

    public void setCardId(String cardId) {
        this.cardId = cardId;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public int getCvv() {
        return cvv;
    }

    public void setCvv(int cvv) {
        this.cvv = cvv;
    }

    public Date getExpirationDate() {
        return expirationDate;
    }

    public void setExpirationDate(Date expirationDate) {
        this.expirationDate = expirationDate;
    }

}


