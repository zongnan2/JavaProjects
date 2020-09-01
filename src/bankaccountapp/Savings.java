package bankaccountapp;

public class Savings extends Account{
    // List properties specific for savings
    private int safetyDepositBoxID;
    private int safetyDepositBoxKey;

    // Constructor to initialize Savings account properties
    public Savings(String name, String SSN, double initDeposit) {
        super(name, SSN, initDeposit);
        accountNumber = "1" + accountNumber;
        setSafetyDepositBox();
    }

    private void setSafetyDepositBox() {
        safetyDepositBoxID = (int) (Math.random() * Math.pow(10,3));
        safetyDepositBoxKey = (int) (Math.random() * Math.pow(10,4));
    }

    @Override
    public void setRate() {
        rate = getBaseRate() - 0.25;
    }

    // List any methods specific for savings
    @Override
    public void showInfo() {
        super.showInfo();
        System.out.println(" Savings Account Features:" +
                            "\n Box ID: " + safetyDepositBoxID +
                            "\n Box Key: " + safetyDepositBoxKey);
        System.out.println("************************************");
    }

}
