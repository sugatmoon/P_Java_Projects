package Hostpital.Management.System;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class Patient
{
    private Scanner scanner;
    private Connection connection;
    public Patient(Scanner scanner, Connection connection) {
        this.scanner = scanner;
        this.connection = connection;
    }
    public void addPatient() {
        System.out.print("Name: ");
        String name = scanner.next();
        System.out.print("Age: ");
        int age     = scanner.nextInt();
        System.out.print("Gender: ");
        String gender  = scanner.next();


        String insertQuery = "INSERT INTO patient(name,age,gender) VALUES (?,?,?)";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(insertQuery);
            preparedStatement.setString(1,name);
            preparedStatement.setInt(2,age);
            preparedStatement.setString(3,gender);
            int result = preparedStatement.executeUpdate();
            if (result > 0 )
                System.out.println("Patient is Added...........");
            else
                System.out.println("Something Wrong........");
        }
        catch ( SQLException e) {
            System.out.println(e.getStackTrace());
        }
    }
    public void viewPatient() {
        String viewQuery = "SELECT * FROM patient";


        try {
        PreparedStatement preparedStatement = connection.prepareStatement(viewQuery);
        ResultSet result = preparedStatement.executeQuery();
            System.out.println("+---------------------------------------------+");
            System.out.println("|    ID   |     NAME     |   AGE   |  GENDER  |");
            System.out.println("+---------------------------------------------+");
        while (result.next()) {
            int id = result.getInt("ID");
            String name = result.getString("NAME");
            int age = result.getInt("AGE");
            String gender = result.getString("gender");
            System.out.printf("|    %-5s|   %-11s|   %-6s|   %-7s|\n",id,name,age,gender);
            System.out.println("+---------------------------------------------+");
        }

        }catch (SQLException e ) {
            System.out.println(e);
        }
    }

    public boolean  getPatientByID(int id) {
        String getPatientByID = "SELECT * FROM patient WHERE ID = ? ";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(getPatientByID);
            preparedStatement.setInt(1,id);
            ResultSet resultSet = preparedStatement.executeQuery();
//            int ID = resultSet.getInt("id");
//            int AGE = resultSet.getInt("age");
//            String NAME = resultSet.getString("name");
//            String gender = resultSet.getString("gender");
            if (resultSet.next())
                return  true;

        }catch (SQLException e ) {
            System.out.println(e.getStackTrace());
        }
        return false;
    }
}
