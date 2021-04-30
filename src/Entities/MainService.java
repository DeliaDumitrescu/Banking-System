package Entities;

import Entities.Account.Account;
import Entities.Account.AccountStatement;
import Entities.Card.Card;
import Entities.Card.CreditCard;
import Entities.Card.DebitCard;
import Entities.Client.Client;
import Entities.Client.ClientSingleton;
import Entities.Transaction.AddFundsTransaction;
import Entities.Transaction.ExchangeFundsTransaction;
import Entities.Transaction.RetrieveFundsTransaction;
import Entities.Transaction.Transaction;

import java.util.*;


public class MainService {
    HashMap<String, Client> clients;
    HashMap<Date, Transaction> transactions;
    Scanner scanner;
    ClientSingleton clientSingleton;

    public MainService() {
        clients = new HashMap<>();
        transactions = new HashMap<>();
        scanner = new Scanner(System.in);
        clientSingleton = ClientSingleton.getInstance();
    }

    // Load CSV files
    public void parseCSVFiles() {
        clientSingleton.parseCSVFile("data/read/clients.csv");
        ArrayList<Client> csvClients = clientSingleton.getClients();
        for(Client csvClient: csvClients) {
            clients.put(csvClient.getClientId(), csvClient);
        }
    }

    // Write to CSV files
    public void writeCSVFiles() {
        ArrayList<Client> csvClients = new ArrayList<>();
        for (String clientId : clients.keySet()) {
           csvClients.add(clients.get(clientId));
        }
        clientSingleton.writeCSVFile(csvClients, "data/write/clients.csv");
    }

    // option 1: Add a new client

    public void addClient() {
        System.out.println("Adding new client. Please enter following client info: ");
        System.out.println("Name: ");
        String name = scanner.next();
        System.out.println("National id: ");
        String nationalId = scanner.next();
        System.out.println("Phone number: ");
        String phoneNumber = scanner.next();

        Client newClient = new Client(nationalId, name, phoneNumber);
        String clientId = newClient.getClientId();
        clients.put(clientId, newClient);
        System.out.println("Successfully added client " + name + " with id " + newClient.getClientId() + '\n');
    }

    // option 2: Show clients info

    public void showClients() {
        System.out.println("Showing clients: ");
        for (String clientId : clients.keySet()) {
            System.out.println(clients.get(clientId));
        }
        System.out.println('\n');
    }

    //option 3: Open account for client

    public void openAccount() {
        System.out.println("Opening account. Please enter client's id: ");
        String clientId = scanner.next();;
        Client client = clients.get(clientId);
        String accountId = client.openAccount();
        System.out.println("Successfully opened account with id: " + accountId + '\n');
    }

    // option 4: Show client's accounts

    public void showClientAccounts() {
        System.out.println("Showing client's accounts. Please enter client's id: ");
        String clientId = scanner.next();
        Client client = clients.get(clientId);
        client.showAccounts();
        System.out.println('\n');
    }

    //option 5: Create transaction to retrieve money

    public void retrieveMoneyFromAccount() {
        System.out.println("Retrieving money from account. Please enter following info: ");
        System.out.println("Client id: ");
        String clientId = scanner.next();
        System.out.println("Account id: ");
        String accountId = scanner.next();
        System.out.println("Amount to retrieve: ");
        double amount = Double.parseDouble(scanner.next());

        Client client = clients.get(clientId);
        for(Account account: client.getAccounts()){
            if(account.getAccountId().equals(accountId)) {
                if(account.getBalance() > amount) {
                    RetrieveFundsTransaction transaction = new RetrieveFundsTransaction(amount, account);
                    transaction.executeTransaction();
                    Date todaysDate = new Date();
                    transactions.put(todaysDate, transaction);
                    System.out.println("Succesfully executed transaction. Current account balance: " + account.getBalance() + '\n');
                    break;
                }
                else {
                    System.out.println("Transaction failed. Not enough funds. Current account balance:" + account.getBalance() + ". Tried to send + " + amount + '\n');
                }
            }
        }
    }

    //option 6: Create transaction to add money

    public void addMoneyToAccount() {
        System.out.println("Adding money to account. Please enter following info: ");
        System.out.println("Client id: ");
        String clientId = scanner.next();
        System.out.println("Account id: ");
        String accountId = scanner.next();
        System.out.println("Amount to add: ");
        double amount = Double.parseDouble(scanner.next());

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

    public void exchangeMoneyBetweenAccounts() {
        System.out.println("Exchanging money between accounts. Please enter following info: ");
        System.out.println("Sender client id: ");
        String senderClientId = scanner.next();
        System.out.println("Sender account id: ");
        String senderAccountId = scanner.next();
        System.out.println("Receiver client id: ");
        String receiverClientId = scanner.next();
        System.out.println("Sender account id: ");
        String receiverAccountId = scanner.next();
        System.out.println("Amount to exchange: ");
        double amount = Double.parseDouble(scanner.next());

        Client senderClient = clients.get(senderClientId);
        Client receiverClient = clients.get(receiverClientId);

        for(Account senderAccount: senderClient.getAccounts()){
            if(senderAccount.getAccountId().equals(senderAccountId)) {
                    if(senderAccount.getBalance() > amount) {
                        for(Account receiverAccount: receiverClient.getAccounts()) {
                            if(receiverAccount.getAccountId().equals(receiverAccountId)) {
                                ExchangeFundsTransaction transaction = new ExchangeFundsTransaction(amount, senderAccount, receiverAccount);
                                transaction.executeTransaction();
                                Date todaysDate = new Date();
                                transactions.put(todaysDate, transaction);
                                System.out.println("Succesfully executed transaction. Sender account balance: " + senderAccount.getBalance() + " Receiver account balance: " + receiverAccount.getBalance() + '\n');
                                break;
                            }
                            else {
                                System.out.println("Transaction failed. Not enough funds. Current sender's account balance:" + senderAccount.getBalance() + ". Tried to send + " + amount + '\n');
                            }
                        }
                    }
            }
        }
    }

    //option 9: Get account statement

    public void getAccountStatement() {
        System.out.println("Getting account statement. Please enter following info: ");
        System.out.println("Client id: ");
        String clientId = scanner.next();
        System.out.println("Account id: ");
        String accountId = scanner.next();
        System.out.println("\n--ACCOUNT STATEMENT--\n");

        Client client = clients.get(clientId);
        for(Account account: client.getAccounts()){
            if(account.getAccountId().equals(accountId)) {
                AccountStatement statement = new AccountStatement(account);
                System.out.println(statement);
            }
        }
    }

    //option 10: Get all transactions in cronological order

    public void getAllTransactions() {
        System.out.println("TRANSACTIONS\n");
        SortedSet<Date> dates = new TreeSet<>(transactions.keySet());
        for (Date date : dates) {
            System.out.println(transactions.get(date));
        }
    }

    //option 11: Open card

    public void openClientCard() {
        System.out.println("Opening card. Please enter following info: ");
        System.out.println("Client id: ");
        String clientId = scanner.next();
        Client client = clients.get(clientId);
        String cardId = client.openCard();
        System.out.println("Successfully opened card with id " + cardId + '\n');
    }

    //option 12: Pay by card

    public void payByCard() {
        System.out.println("Paying by card, please enter info: ");
        System.out.println("Client id: ");
        String clientId = scanner.next();
        System.out.println("Card id: ");
        String cardId = scanner.next();
        System.out.println("Amount: ");
        double amount = Double.parseDouble(scanner.next());
        Client client = clients.get(clientId);
        for(Card card: client.getCards()) {
            if(card.getCardId().equals(cardId)) {
                for(Account account: client.getAccounts()) {
                    if(account.getAccountId().equals(card.getAcoountId())) {
                        if (card instanceof DebitCard && account.getBalance() >= amount)
                        {
                            Transaction transaction = new RetrieveFundsTransaction(amount, account);
                            transaction.executeTransaction();
                            Date todaysDate = new Date();
                            transactions.put(todaysDate, transaction);
                            System.out.println("Succesfully executed transaction. Current account balance: " + account.getBalance() + '\n');
                            break;
                        }
                        else if (card instanceof CreditCard && ((CreditCard) card).getaccumulatedDebt() + amount <= ((CreditCard) card).getCreditLimit()) {
                            double accumulatedDebt = ((CreditCard) card).getaccumulatedDebt();
                            ((CreditCard) card).setaccumulatedDebt(accumulatedDebt + amount);
                            System.out.println("Succesfully executed transaction. Credit card spendings: " + ((CreditCard) card).getaccumulatedDebt() + '\n');
                        }
                        else {
                            System.out.println("Transaction failed. Not enough funds.\n");
                        }

                    }
                }
                break;
            }
        }

    }

}
