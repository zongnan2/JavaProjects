package studentdatabaseapp;

import java.util.Scanner;

public class StudentDatabaseApp {
    public static void main(String[] args) {
        // Ask how many new users we want to add
        System.out.println("Enter number of students to enroll: ");
        Scanner in = new Scanner(System.in);
        Student[] students = new Student[in.nextInt()];

        // Create n number of new students
        for(int i = 0; i<students.length;i++) {
            students[i] = new Student();
            students[i].enroll();
            students[i].payTuition();
        }

        for(int i = 0; i<students.length;i++) {
            System.out.println(students[i].toString());
        }
    }
}
