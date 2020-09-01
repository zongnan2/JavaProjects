package studentdatabaseapp;

import java.util.Scanner;

public class Student {
    private String firstName;
    private String lastName;
    private int gradeYear;
    private String studentID;
    private String courses = "";
    private int tuitionBalance = 0;
    private static int costOfCourse = 600;
    private static int id = 1000;

    // Constructor: prompt user to enter student's name and year
    public Student() {
        Scanner in = new Scanner(System.in);
        System.out.println("Enter student first name: ");
        this.firstName = in.nextLine();
        System.out.println("Enter student last name: ");
        this.lastName = in.nextLine();
        System.out.println("1 - Freshmen\n2 - Sophomore\n3 - Junior\n4 - Senior\nEnter student class level: ");
        this.gradeYear = in.nextInt();
        setStudentID();
    }
    // Generate an ID
    private void setStudentID() {
        // Grade Level + ID
        id ++;
        studentID = gradeYear + "" + id;
    }

    // Enroll in courses
    public void enroll() {
        do {
            System.out.print("Enter course to enroll (Q to quit): ");
            Scanner in = new Scanner(System.in);
            String course = in.nextLine();
            if (!course.equals("Q")) {
                courses = courses + "\n " + course;
                tuitionBalance = tuitionBalance + costOfCourse;
            } else {
                break;
            }
        } while(1 != 0 );
    }

    // View balance
    public void viewTuitionBalance() {
        System.out.println("Tuition Balance: $" + tuitionBalance);
    }

    // Pay tuition
    public void payTuition() {
        viewTuitionBalance();
        System.out.print("Enter your payment: $");
        Scanner in = new Scanner(System.in);
        int amount = in.nextInt();
        tuitionBalance = tuitionBalance-amount;
        System.out.println("Thank you for your payment of $" + amount);
        viewTuitionBalance();
    }


    // Show status
    @Override
    public String toString() {
        return "Name: " + firstName + " " + lastName +
                "\nGrade Level: " + gradeYear +
                "\nStudent ID: " + studentID +
                "\nCourses Enrolled: " + courses +
                "\nBalance: " + tuitionBalance;
    }
}
