package Hostpital.Management.System;

import com.mysql.cj.util.StringInspector;

import java.sql.*;
import java.util.Scanner;

public class Hospital {
    private static final String url = "jdbc:mysql://localhost:3306/hospital";
    private static final String user = "root";
    private static final String password = "Pass@123";
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
                        bookAppointment(patient, doctor,scanner,connection);
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
    public static void bookAppointment (Patient patient, Doctor doctor,Scanner scanner,Connection connection){
        System.out.println("Enter the Patient ID: ");
        int Patient_Id = scanner.nextInt();
        System.out.println("Enter the Doctor ID: ");
        int Doctor_Id = scanner.nextInt();
        System.out.println("Enter the Date of Appointment: ");
        String Appointment_Date = scanner.next();


        if (patient.getPatientByID(Patient_Id) && doctor.getDoctorByID(Doctor_Id)) {
            if (checkAvailability(Doctor_Id,Appointment_Date,connection)){

            }
                try {

                String query = " INSERT INTO appointment (patient_id,doctor_id,appointment_date) VALUES (?,?,?)";
                PreparedStatement preparedStatement = connection.prepareStatement(query);

                preparedStatement.setInt(1,Patient_Id);
                preparedStatement.setInt(2,Doctor_Id);
                preparedStatement.setString(3,Appointment_Date);

                int value = preparedStatement.executeUpdate();
                if (value > 0) {
                    System.out.println("Successfully Appointment Booked....");
                }
                else {
                    System.out.println("Something Went Wrong........");
                }


                }catch (SQLException e ) {
                    System.out.println(e.getStackTrace());
                }
        }else System.out.println("Something Went Wrong........");
    }
    public static boolean checkAvailability (int Doctor_ID, String Appointment_Date,Connection connection) {
        String query = "SELECT count(id) FROM appointment where doctor_id = ? and appointment_date = ?";
        try {
        PreparedStatement preparedStatement = connection.prepareStatement(query);
        preparedStatement.setInt(1,Doctor_ID);
        preparedStatement.setString(2,Appointment_Date);
        ResultSet resultSet = preparedStatement.executeQuery();
        if (resultSet.next()) {
            int count = resultSet.getInt(1);
            if (count  == 0 ) {
                    return true;
            }
        }

        }catch (SQLException e ) {
            System.out.println(e);
        }
        return false;

    }


}
