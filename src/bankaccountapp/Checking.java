package bankaccountapp;

public class Checking extends Account{
    // List properties specific for a checking account
    private long debitCardNumber;
    private int debitCardPin;

    // Constructor to initialize checking account properties
    public Checking(String name, String SSN, double initDeposit) {
        super(name, SSN, initDeposit);
        accountNumber = "2" + accountNumber;
        setDebitCard();
    }

    private void setDebitCard() {
        debitCardNumber = (long) (Math.random() * Math.pow(10,12));
        debitCardPin = (int) (Math.random() * Math.pow(10,4));
    }

    @Override
    public void setRate() {
        rate = getBaseRate() * 0.15;
    }

    // List methods specific for checking
    @Override
    public void showInfo() {
        super.showInfo();
        System.out.println(" Checking Account Features: " +
                            "\n Debit Card Number: " + debitCardNumber +
                            "\n Debit Card Pin: " + debitCardPin);
        System.out.println("************************************");
    }
}
