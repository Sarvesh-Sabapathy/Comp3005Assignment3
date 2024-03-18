package org.example;

public class Main {

    public static void main(String[] args) {

        Students info = new Students();

        // Getting all students from initial example
        info.getAllStudents();
        System.out.print("\n");

        // Adding a student
        info.addStudent("Sarvesh", "Sabapathy", "testemail@email.com", "2024-03-18");
        info.getAllStudents();
        System.out.print("\n");

        // Update students email
        info.updateStudentEmail(4, "testemail@gmail.com");
        info.getAllStudents();
        System.out.print("\n");

        // Remove student
        info.deleteStudent(4);
        info.getAllStudents();
    }
}
