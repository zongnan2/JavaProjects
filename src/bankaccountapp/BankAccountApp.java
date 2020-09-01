package bankaccountapp;

import java.util.LinkedList;
import java.util.List;

public class BankAccountApp {
    public static void main(String[] args) {
        List<Account> accounts = new LinkedList<>();
        /**
        Checking chkacc1 = new Checking("Zongnan Chen","123456789",500);
        Savings savacc1 = new Savings("Yunshu Huo","987654321",1000);
         */


        // Read csv file and create new account based on data
        String file = "/Users/zongnanchen/Desktop/Graduate/JavaProjects/NewBankAccounts.csv";
        List<String[]> newAccountHolders = utilities.CSV.read(file);
        for(String[] accountHolder : newAccountHolders) {
            String name = accountHolder[0];
            String SSN = accountHolder[1];
            String accountType = accountHolder[2];
            double initDeposit = Double.parseDouble(accountHolder[3]);
            if(accountType.equals("Savings")) {
                accounts.add(new Savings(name,SSN,initDeposit));
            } else if(accountType.equals("Checking")) {
                accounts.add(new Checking(name,SSN,initDeposit));
            } else {
                System.out.println("Error Reading Account");
            }
        }

        for(Account acc: accounts) {
            acc.showInfo();
        }
    }
}
