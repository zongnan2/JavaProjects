package emailapp;
import java.util.Scanner;

public class Email {
    private String firstName;
    private String lastName;
    private String password;
    private int defaultPasswordLength = 10;
    private String department;
    private String email;
    private int mailboxCapacity = 500;
    private String alternateEmail;
    private String companySuffix = "aeycompany.com";

    /** Constructor to receive firstName and lastName. */
    public Email(String setFirstName, String setLastName) {
        this.firstName = setFirstName;
        this.lastName = setLastName;

        //Call a method asking for department - return the department
        this.department = setDepartment();

        //Call a method that returns a random password
        this.password = randomPassword(defaultPasswordLength);
        System.out.println("Your password: " + this.password);

        //Combine elements to generate email
        this.email = firstName.toLowerCase() + "." + lastName.toLowerCase() + "@" + department + "." + companySuffix;
    }

    /** Ask for the department. */
    private String setDepartment() {
        System.out.print("New worker: " + firstName + ". Department Codes:\n1 for Sales\n2 for Development\n3 for Accounting\n0 for none\nEnter department code: ");
        Scanner in = new Scanner(System.in);
        int depChoice = in.nextInt();
        if(depChoice == 1) { return "sales"; }
        else if(depChoice == 2) { return "dev"; }
        else if(depChoice == 3) { return "acct"; }
        else { return ""; }
    }

    /** Generate a random password. */
    private String randomPassword(int length) {
        String passwordSet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789!@#$%";
        char[] password = new char[length];
        for(int i=0; i<length; i++) {
            int rand = (int) (Math.random() * passwordSet.length());
            password[i] = passwordSet.charAt(rand);
        }
        return new String(password);
    }

    /** Change the password. */
    public void changePassword(String password) {
        this.password = password;
    }

    /** Get the password. */
    public String getPassword() {
        return password;
    }

    /** Set the mailbox capacity. */
    public void setMailboxCapacity(int capacity) {
        this.mailboxCapacity = capacity;
    }

    /** Get the mailbox capacity. */
    public int getMailboxCapacity() {
        return mailboxCapacity;
    }

    /** Set the alternate email. */
    public void setAlternateEmail(String altEmail) {
        this.alternateEmail = altEmail;
    }

    /** Get the alternate email. */
    public String getAlternateEmail() {
        return alternateEmail;
    }

    /** Display info. */
    public String showInfo() {
        return "DISPLAY NAME: " + firstName + " " + lastName +
                "\nCOMPANY EMAIL: " + email +
                "\nMAILBOX CAPACITY: " + mailboxCapacity + "mb";
    }
}
