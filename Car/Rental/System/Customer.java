package Car.Rental.System;

import java.util.Scanner;

public class Customer {
    private String name;
    private String id;

    public Customer(Scanner sc) {
        System.out.println("Enter the Full Name: ");
        this.name = sc.next();
        System.out.println("Enter the id Number: ");
        this.id  = sc.next();
    }

    public String getName() {
        return name;
    }
    public String getId() {
        return id;
    }


}
