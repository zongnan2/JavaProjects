package bankaccountapp;

public abstract class Account implements IBaseRate{
    // List common properties for checking and savings account
    private String name;
    private String SSN;
    private double balance;

    private static int index = 10000;
    protected String accountNumber;
    protected double rate;


    // Constructor to set the base properties and initialize the account
    public Account(String name, String SSN, double initialDeposit) {
        this.name = name;
        this.SSN = SSN;
        this.balance = initialDeposit;

        // Set account number
        index++;
        this.accountNumber = setAccountNumber();
        setRate();
    }

    public abstract void setRate();

    private String setAccountNumber() {
        String lastTwoOfSSN = SSN.substring(SSN.length()-2,SSN.length());
        int uniqueID = index;
        int randomNumber = (int) (Math.random() * Math.pow(10,3));
        return lastTwoOfSSN + uniqueID + randomNumber;
    }

    public void compound() {
        balance = balance * (1 + rate/100);
    }

    // List common methods - transactions
    public void deposit(double amount) {
        balance = balance + amount;
        System.out.println("Depositing $" + amount);
    }

    public void withdraw(double amount) {
        balance = balance - amount;
        System.out.println("Withdrawing $" + amount);
    }

    public void transfer(double amount, Account recipient) {
        this.balance = this.balance - amount;
        recipient.balance = recipient.balance + amount;
        System.out.println("Transfering $" + amount + " to " + recipient.name);
    }

    public void printBalance() {
        System.out.println("Your Balance: $" + balance);
    }

    public void showInfo() {
        System.out.println("Name: " + this.name +
                            "\nAccount Number: " + this.accountNumber +
                            "\nBalance: " + this.balance +
                            "\nRate: " + this.rate + "%");
    }
}
