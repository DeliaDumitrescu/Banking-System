import Entities.Account;
import Entities.Card.Card;
import Entities.Transaction.ExchangeFundsTransaction;
import Entities.Transaction.RetrieveFundsTransaction;
import Entities.Transaction.Transaction;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args)
    {
        Account a = new Account();
        a.setBalance(100.0);

        Account b = new Account();
        b.setBalance(200.0);

        ArrayList<Account> acs = new ArrayList<Account>();
        acs.add(a);
        acs.add(b);

        Transaction t1 = new ExchangeFundsTransaction(10, acs.get(0), acs.get(1));
        System.out.println(acs.get(0).getBalance());
        System.out.println(acs.get(1).getBalance());
        

    }
}
