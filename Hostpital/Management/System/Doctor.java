package Hostpital.Management.System;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class Doctor {

    private Scanner scanner;
    private Connection connection;
    public Doctor(Scanner scanner, Connection connection) {
        this.scanner = scanner;
        this.connection = connection;
    }
    public void viewDoctor() {
        String viewQuery = "SELECT * FORM DOCTOR";

        try {
            PreparedStatement preparedStatement = connection.prepareStatement(viewQuery);
            ResultSet result = preparedStatement.executeQuery();
            while (result.next()) {
                int id = result.getInt("ID");
                String name = result.getString("NAME");
                String speacialization = result.getString("SPEACIALIZATION");


                System.out.println(result.getRow());
            }


        }catch (SQLException e ) {
            System.out.println(e.getStackTrace());
        }
    }

    public boolean  getDoctorByID(int id) {
        String getDoctorByID = "SELECT * FROM DOCTOR WHERE ID = ? ";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(getDoctorByID);
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
