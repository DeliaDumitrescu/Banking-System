import Entities.MainService;

import java.io.IOException;
import java.sql.*;


public class Main {
    public static void main(String[] args) throws IOException, SQLException {
        MainService service = new MainService();
        service.addClient();
        service.addClient();
        service.openAccount();
        service.openAccount();
        service.addMoneyToAccount();
        service.retrieveMoneyFromAccount();
        service.exchangeMoneyBetweenAccounts();
        //        service.openClientCard();

//        service.parseCSVFiles();
//        service.openClientCard();
//        service.addMoneyToAccount();
//        service.payByCard();
//        service.retrieveMoneyFromAccount();
//        service.getAccountStatement();
//        service.getAllTransactions();
//        service.writeCSVFiles();

//        String DB_URL = "jdbc:mysql://localhost:3306/BankingSystem";
//        String USER = "root";
//        String password = "";
//        Connection conn = DriverManager.getConnection(DB_URL,USER, password);
    }
}
