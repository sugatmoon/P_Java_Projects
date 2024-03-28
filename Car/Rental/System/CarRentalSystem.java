package Car.Rental.System;

import java.util.ArrayList;
import java.util.Scanner;

public class CarRentalSystem {
    static ArrayList<Car> cars;
    static ArrayList<Rental> rentals;
    static ArrayList<Customer> customers;
    Scanner sc;

    public static void main(String[] args) {
        Customer info_customer = new Customer(sc);
        customers.add(info_customer);
        System.out.println(info_customer);

        Rental info_rental = new Rental(sc);
        rentals.add(info_rental);

//        Car info_cars = new Car(sc);
//        cars.add(info_cars);

    }
}
