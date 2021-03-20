import Entities.Account.Account;
import Entities.Account.AccountService;
import Entities.Card.Card;
import Entities.Card.CreditCard;
import Entities.Card.DebitCard;
import Entities.Person;
import Entities.PersonService;
import Entities.Transaction.AddFundsTransaction;
import Entities.Transaction.ExchangeFundsTransaction;
import Entities.Transaction.Transaction;

import java.util.Date;

public class Main {
    public static void main(String[] args)
    {
//        Account a = new Account();
//        a.setBalance(100.0);
//
//        Account b = new Account();
//        b.setBalance(200.0);
//
//        ArrayList<Account> acs = new ArrayList<Account>();
//        acs.add(a);
//        acs.add(b);
//
//        Transaction t1 = new ExchangeFundsTransaction(10, acs.get(0), acs.get(1));
//        t1.executeTransaction();
//
//
//        System.out.println(acs.get(0).getBalance());
//        System.out.println(acs.get(1).getBalance());
        Date today = new Date();
        Person me = new Person("6010", "Delia Dumitrescu", today, "075959", "dd@yh.com");

        Account account1 = new Account();
        AccountService accountService1 = new AccountService(account1);
        Transaction t1 = new AddFundsTransaction(100.0, account1);
        t1.executeTransaction();
        accountService1.addTransaction(t1);

        account1.setBalance(100.0);

        Account account2 = new Account();
        account1.setBalance(130.0);

        Transaction t2 = new ExchangeFundsTransaction(300.0, account1, account2);
        t2.executeTransaction();
        accountService1.addTransaction(t2);

        Card card1 = new DebitCard(account1.getAccountId(), "1234 5678 1234 5678", 231);
        Card card2 = new CreditCard(account2.getAccountId(), "5678 1234 5678 1234", 231, 5000.0, 15.0);

        PersonService personService = new PersonService(me);

        personService.addAccount(account1);
        personService.addAccount(account2);

        personService.addCard(card1);
        personService.addCard(card2);

        System.out.println(me);
//        System.out.println(t1);
//        System.out.println(t2);

    }
}
