package Entities;

import Entities.Card.Card;

import java.util.ArrayList;

public class PersonService {
    private Person person;

    public PersonService(Person person) {
        this.person = person;
    }

    public void addCard(Card card) {
        ArrayList<Card> cards = this.person.getCards();
        cards.add(card);
        person.setCards(cards);
    }

    public void addAccount(Account account) {
        ArrayList<Account> accounts = this.person.getAccounts();
        accounts.add(account);
        person.setAccounts(accounts);
    }

    public void showAccounts() {
        for(Account account: this.person.getAccounts()) {
            System.out.println(account);
        }
    }

    public void showCards() {
        for(Card card: this.person.getCards()) {
            System.out.println(card);
        }
    }
}
