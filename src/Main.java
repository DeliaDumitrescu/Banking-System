import Entities.MainService;

import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException
    {
        MainService c = new MainService();
        c.addClient();
//        c.addClient();
        c.openAccount();
        c.openClientCard();
//        c.openAccount();
//        c.showClientAccounts();
//        c.showClientAccounts();
        c.addMoneyToAccount();
        c.payByCard();
//        c.retrieveMoneyFromAccount();
//        c.getAccountStatement();
        c.getAllTransactions();

    }
}
