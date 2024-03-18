package Hostpital.Management.System;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Scanner;

public class Hospital {
    private static final String url = "jdbc:mysql://localhost:3306/hospital";
    private static final String user = "root";
    private static final String password = "Sugat@2002";
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection connection = DriverManager.getConnection(url, user, password);




            Patient patient = new Patient(scanner,connection);
            Doctor doctor = new Doctor(scanner,connection);



            while (true) {
                System.out.println("1. Add Patient");
                System.out.println("2. View Patient");
                System.out.println("3. View Doctors");
                System.out.println("4. Book Appointment");
                System.out.println("5. Exit");
                System.out.println("Enter the Number: ");

                int choice = scanner.nextInt();

                switch (choice) {
                    case 1 :
                        patient.addPatient();
                        break;
                    case 2 :
                        patient.viewPatient();
                        break;
                    case 3 :
                        doctor.viewDoctor();
                        break;
                    case 4 :
                        break;
                    case 5 :
                        break;
                    default:
                        System.out.println("Enter the Choice: ");
                }
            }









        }catch (ClassNotFoundException e ) {
            System.out.println(e.getMessage());
        }
        catch (SQLException e ) {
            System.out.println(e.getStackTrace());
        }

    }
}
