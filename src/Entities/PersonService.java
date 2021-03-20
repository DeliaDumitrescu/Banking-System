package Entities;

import Entities.Account.Account;
import Entities.Card.Card;

import java.util.ArrayList;

public class PersonService {
    private Person person;

    public PersonService(Person person) {
        this.person = person;
    }

    public void addCard(Card card) {
        ArrayList<Card> cards = person.getCards();
        cards.add(card);
        person.setCards(cards);
    }

    public void addAccount(Account account) {
        ArrayList<Account> accounts = person.getAccounts();
        accounts.add(account);
        person.setAccounts(accounts);
    }

    public void showAccounts() {
        for(Account account: person.getAccounts()) {
            System.out.println(account);
        }
    }

    public void showCards() {
        for(Card card: person.getCards()) {
            System.out.println(card);
        }
    }
}
