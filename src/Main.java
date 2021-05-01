import Entities.MainService;

import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        MainService service = new MainService();
        service.parseCSVFiles();
        service.openClientCard();
        service.addMoneyToAccount();
        service.payByCard();
        service.retrieveMoneyFromAccount();
        service.getAccountStatement();
        service.getAllTransactions();
        service.writeCSVFiles();
    }
}
