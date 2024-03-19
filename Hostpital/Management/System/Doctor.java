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
        String viewQuery = "SELECT * FROM doctor";

        try {
            PreparedStatement preparedStatement = connection.prepareStatement(viewQuery);
            ResultSet result = preparedStatement.executeQuery();
                System.out.println("+---------------------------------------------+");
                System.out.println("|    ID    |     NAME     |   SPECIALIZATION  |");
                System.out.println("+---------------------------------------------+");
            while (result.next()) {
                int id = result.getInt("id");
                String name = result.getString("name");
                String speacialization = result.getString("speacialization");
                System.out.printf("|   %-7s|    %-7s|      %-5s|\n",id,name,speacialization);
                System.out.println("+---------------------------------------------+");
            }


        }catch (SQLException e ) {
            System.out.println(e.getStackTrace());
        }
    }

    public boolean  getDoctorByID(int id) {
        String getDoctorByID = "SELECT * FROM doctor WHERE id = ?";
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
