package org.example;
import java.sql.*;

/**
 * A class to manage operations related to students in a database.
 */
public class Students {
    // Login info to access database
    String url = "jdbc:postgresql://localhost:5432/Students";
    String user = "postgres";
    String password = "Tarvizzle123$$$";

    /**
     * Retrieves all students from the database and prints their details.
     */
    public void getAllStudents() {
        try {
            Class.forName("org.postgresql.Driver");
            Connection c = DriverManager.getConnection(url, user, password); // connect to db
            Statement s = c.createStatement();
            s.executeQuery("SELECT * FROM students"); // display table query
            ResultSet result = s.getResultSet();

            while (result.next()) {

                // get all attributes
                int student_id = result.getInt("student_id");
                String first_name = result.getString("first_name");
                String last_name = result.getString("last_name");
                String student_email = result.getString("email");
                Date date = result.getDate("enrollment_date");

                // Print table
                System.out.println("student_id: " + student_id + ", first_name: " + first_name +
                        ", last_name: " + last_name + ", student_email: " + student_email +
                        ", enrollment_date: " + date);
            }

        } catch (ClassNotFoundException | SQLException e) {
            System.out.println(e);
        }
    }

    /**
     * Adds a new student to the database.
     *
     * @param first_name      The first name of the student.
     * @param last_name       The last name of the student.
     * @param student_email   The email of the student.
     * @param enrollment_date The enrollment date of the student.
     */
    public void addStudent(String first_name, String last_name, String student_email, String enrollment_date) {

        // create the sql query statement
        String insertSQL = "INSERT INTO students (first_name, last_name, email, enrollment_date) VALUES (?, ?, ?, ?)";
        Date date = Date.valueOf(enrollment_date);

        try {
            Class.forName("org.postgresql.Driver");
            Connection c = DriverManager.getConnection(url, user, password);
            PreparedStatement s = c.prepareStatement(insertSQL);
            //set variables
            s.setString(1, first_name);
            s.setString(2, last_name);
            s.setString(3, student_email);
            s.setDate(4, date);
            s.executeUpdate();
            s.close();
            c.close();

        } catch (ClassNotFoundException | SQLException e) {
            System.out.println(e);
        }
    }

    /**
     * Updates the email of a student in the database.
     *
     * @param student_id      The ID of the student.
     * @param student_email   The new email of the student.
     */
    public void updateStudentEmail(int student_id, String student_email){

        // create the sql query statement
        String insertSQL = "UPDATE students SET email = ? WHERE student_id = ?";

        try {
            Class.forName("org.postgresql.Driver");
            Connection c = DriverManager.getConnection(url, user, password);
            PreparedStatement s= c.prepareStatement(insertSQL);
            s.setString(1, student_email);
            s.setInt(2, student_id);
            s.executeUpdate();
            s.close();
            c.close();

        } catch (ClassNotFoundException | SQLException e){
            System.out.println(e);
        }
    }

    /**
     * Deletes a student from the database.
     *
     * @param student_id The ID of the student to delete.
     */
    public void deleteStudent(int student_id){

        // create the sql query statement
        String insertSQL = "DELETE FROM students WHERE student_id = ?";

        try {
            Class.forName("org.postgresql.Driver");
            Connection c = DriverManager.getConnection(url, user, password);
            PreparedStatement s = c.prepareStatement(insertSQL);
            s.setInt(1, student_id); // select student to remove
            int rowsDeleted = s.executeUpdate();
            if (rowsDeleted > 0) {
                System.out.println("Student deleted successfully");
            } else {
                System.out.println("No student found with student_id: " + student_id);
            }
            s.close();
            c.close();
        }
        catch (ClassNotFoundException | SQLException e){
            System.out.println(e);
        }
    }
}