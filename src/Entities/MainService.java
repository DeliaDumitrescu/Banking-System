package Entities;

import Entities.Account.Account;
import Entities.Account.AccountStatement;
import Entities.Client.Client;
import Entities.Transaction.AddFundsTransaction;
import Entities.Transaction.ExchangeFundsTransaction;
import Entities.Transaction.RetrieveFundsTransaction;
import Entities.Transaction.Transaction;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Date;
import java.util.HashMap;
import java.util.SortedSet;
import java.util.TreeSet;


public class MainService {
    HashMap<String, Client> clients;
    HashMap<Date, Transaction> transactions;

    public MainService() {
        clients = new HashMap<>();
        transactions = new HashMap<>();
    }

    // option 1: Add a new client

    public void addClient() throws IOException {
        BufferedReader reader = new BufferedReader(
                new InputStreamReader(System.in));

        System.out.println("Adding new client. Please enter following client info: ");
        System.out.println("Name: ");
        String name = reader.readLine();
        System.out.println("National id: ");
        String nationalId = reader.readLine();
        System.out.println("Phone number: ");
        String phoneNumber = reader.readLine();

        Client newClient = new Client(nationalId, name, phoneNumber);
        String clientId = newClient.getClientId();
        clients.put(clientId, newClient);
        System.out.println("Successfully added client " + name + " with id " + newClient.getClientId() + '\n');
    }

    //option 2: Show clients info

    public void showClients() {
        System.out.println("Showing clients: ");
        for (String clientId : clients.keySet()) {
            System.out.println(clients.get(clientId));
        }
        System.out.println('\n');
    }

    //option 3: Open account for client

    public void openAccount() throws IOException{
        BufferedReader reader = new BufferedReader(
                new InputStreamReader(System.in));
        System.out.println("Opening account. Please enter client's id: ");
        String clientId = reader.readLine();
        Client client = clients.get(clientId);
        client.openAccount();
        System.out.println("Successfully opened account.\n");
    }

    // option 4: Show client's accounts

    public void showClientAccounts() throws IOException{
        BufferedReader reader = new BufferedReader(
                new InputStreamReader(System.in));
        System.out.println("Showing client's accounts. Please enter client's id: ");
        String clientId = reader.readLine();
        Client client = clients.get(clientId);
        client.showAccounts();
        System.out.println('\n');
    }

    //option 5: Create transaction to retrieve money

    public void retrieveMoneyFromAccount() throws IOException{
        BufferedReader reader = new BufferedReader(
                new InputStreamReader(System.in));
        System.out.println("Retrieving money from account. Please enter following info: ");
        System.out.println("Client id: ");
        String clientId = reader.readLine();
        System.out.println("Account id: ");
        String accountId = reader.readLine();
        System.out.println("Amount to retrieve: ");
        double amount = Double.parseDouble(reader.readLine());

        Client client = clients.get(clientId);
        for(Account account: client.getAccounts()){
            if(account.getAccountId().equals(accountId)) {
                RetrieveFundsTransaction transaction = new RetrieveFundsTransaction(amount, account);
                transaction.executeTransaction();
                Date todaysDate = new Date();
                transactions.put(todaysDate, transaction);
                System.out.println("Succesfully executed transaction. Current account balance: " + account.getBalance() + '\n');
                break;
            }
        }
    }

    //option 6: Create transaction to add money

    public void addMoneyToAccount() throws IOException{
        BufferedReader reader = new BufferedReader(
                new InputStreamReader(System.in));
        System.out.println("Adding money to account. Please enter following info: ");
        System.out.println("Client id: ");
        String clientId = reader.readLine();
        System.out.println("Account id: ");
        String accountId = reader.readLine();
        System.out.println("Amount to add: ");
        double amount = Double.parseDouble(reader.readLine());

        Client client = clients.get(clientId);
        for(Account account: client.getAccounts()){
            if(account.getAccountId().equals(accountId)) {
                AddFundsTransaction transaction = new AddFundsTransaction(amount, account);
                transaction.executeTransaction();
                Date todaysDate = new Date();
                transactions.put(todaysDate, transaction);
                System.out.println("Succesfully executed transaction. Current account balance: " + account.getBalance() + '\n');
                break;
            }
        }
    }

    //option 7: Create transaction to send money from one account to another

    public void exchangeMoneyBetweenAccounts() throws IOException{
        BufferedReader reader = new BufferedReader(
                new InputStreamReader(System.in));
        System.out.println("Exchanging money between accounts. Please enter following info: ");
        System.out.println("Sender client id: ");
        String senderClientId = reader.readLine();
        System.out.println("Sender account id: ");
        String senderAccountId = reader.readLine();
        System.out.println("Receiver client id: ");
        String receiverClientId = reader.readLine();
        System.out.println("Sender account id: ");
        String receiverAccountId = reader.readLine();
        System.out.println("Amount to exchange: ");
        double amount = Double.parseDouble(reader.readLine());

        Client senderClient = clients.get(senderClientId);
        Client receiverClient = clients.get(receiverClientId);

        for(Account senderAccount: senderClient.getAccounts()){
            if(senderAccount.getAccountId().equals(senderAccountId)) {
                    for(Account receiverAccount: receiverClient.getAccounts()) {
                        if(receiverAccount.getAccountId().equals(receiverAccountId)) {
                            ExchangeFundsTransaction transaction = new ExchangeFundsTransaction(amount, senderAccount, receiverAccount);
                            transaction.executeTransaction();
                            Date todaysDate = new Date();
                            transactions.put(todaysDate, transaction);
                            System.out.println("Succesfully executed transaction. Sender account balance: " + senderAccount.getBalance() + " Receiver account balance: " + receiverAccount.getBalance() + '\n');
                            break;
                        }
                    }
            }
        }
    }

    //option 9: Get account statement

    public void getAccountStatement() throws IOException {
        BufferedReader reader = new BufferedReader(
                new InputStreamReader(System.in));
        System.out.println("Getting account statement. Please enter following info: ");
        System.out.println("Client id: ");
        String clientId = reader.readLine();
        System.out.println("Account id: ");
        String accountId = reader.readLine();
        System.out.println("\n--ACCOUNT STATEMENT--\n");

        Client client = clients.get(clientId);
        for(Account account: client.getAccounts()){
            if(account.getAccountId().equals(accountId)) {
                AccountStatement statement = new AccountStatement(account);
                System.out.println(statement);
            }
        }
    }

    //option 10: Get transactions in cronological order
    public void getAllTransactions() {
        System.out.println("TRANSACTIONS\n");
        SortedSet<Date> dates = new TreeSet<>(transactions.keySet());
        for (Date date : dates) {
            System.out.println(transactions.get(date));
        }
    }

}
