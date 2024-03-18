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
        System.out.print("Sex: ");
        String sex  = scanner.next();


        String insertQuery = "INSERT INTO PATIENT(name,sex,age) VALUES (?,?,?)";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(insertQuery);
            preparedStatement.setString(1,name);
            preparedStatement.setString(2,sex);
            preparedStatement.setInt(3,age);
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
        String viewQuery = "SELECT * FORM PATIENT";





        try {
        PreparedStatement preparedStatement = connection.prepareStatement(viewQuery);
        ResultSet result = preparedStatement.executeQuery();
        while (result.next()) {
            int id = result.getInt("ID");
            int age = result.getInt("AGE");
            String name = result.getString("NAME");
            String sex = result.getString("SEX");


            System.out.println(result.getRow());
        }


        }catch (SQLException e ) {
            System.out.println(e.getStackTrace());
        }
    }

    public boolean  getPatientByID(int id) {
        String getPatientByID = "SELECT * FROM PATIENT WHERE ID = ? ";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(getPatientByID);
            preparedStatement.setInt(1,id);
            ResultSet resultSet = preparedStatement.executeQuery();
//            int ID = resultSet.getInt("id");
//            int AGE = resultSet.getInt("age");
//            String NAME = resultSet.getString("name");
//            String SEX = resultSet.getString("sex");
            if (resultSet.next())
                return  true;

        }catch (SQLException e ) {
            System.out.println(e.getStackTrace());
        }
        return false;
    }
}
