package Entities.Account;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class AccountSingleton {
    private static AccountSingleton instance = null;
    HashMap<String, ArrayList<Account>> accounts = new HashMap<>();

    public static AccountSingleton getInstance() {
        if (instance == null)
            instance = new AccountSingleton();
        return instance;
    }

    public HashMap<String, ArrayList<Account>> getAccounts() {
        return this.accounts;
    }

    public void setAccounts(HashMap<String, ArrayList<Account>> accounts) {
        this.accounts = accounts;
    }

    public void parseCSVFile(String filePath) {
        List<List<String>> lines = new ArrayList<>();
        ArrayList<Account> currentAccounts;
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] values = line.split(",");
                lines.add(Arrays.asList(values));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        for(List<String> line:lines) {
            String clientId = line.get(0);
            Account account = new Account();
            if (accounts.containsKey(clientId)) {
                currentAccounts = accounts.get(clientId);
            }
            else {
               currentAccounts = new ArrayList<>();
            }
            currentAccounts.add(account);
            accounts.put(clientId, currentAccounts);
        }
    }

    public void writeCSVFile(ArrayList<Account> csvAccounts, String filePath) {
        try(FileWriter writer = new FileWriter(filePath)){
            for(Account csvAccount : csvAccounts){
                writer.write(csvAccount.toCSV());
                writer.write("\n");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
