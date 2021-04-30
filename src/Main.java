import Entities.Client.ClientSingleton;
import Entities.MainService;

import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException
    {
        MainService service = new MainService();
        service.parseCSVFiles();
        service.addClient();
        service.openAccount();
        service.writeCSVFiles();

//        service.openClientCard();
//        service.addMoneyToAccount();
//        service.payByCard();
//        service.retrieveMoneyFromAccount();
//        service.getAccountStatement();
//        service.getAllTransactions();

    }
}
