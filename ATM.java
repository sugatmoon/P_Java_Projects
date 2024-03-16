import java.util.Scanner;

class Machine {
    Scanner sc = new Scanner(System.in);
    int PIN;
    float balance;

    public Machine(float balance, int PIN) {
        this.balance = balance;
        this.PIN = PIN;
    }



    public void meth() {
        System.out.println("Enter the Number: ");
        System.out.println("1. Balance Enquiry");
        System.out.println("2. Withdrawn Money");
        System.out.println("3. Deposit Money");
        System.out.println("4. Exit");
        int input = sc.nextInt();

        if (input == 1 ) {
            balance();
        }
        else if( input == 2 ) {
            withdrawn();
        }
        else if(input == 3 ){
            deposit();
        }
        else if( input == 4 ) {
            exit();
        }
        else{
            System.out.println("Please Enter the correct input: ");
        }
    }
    public void balance() {
        System.out.println("Your balance is: "+ this.balance);
        meth();
    }
    public void withdrawn() {
        System.out.println("Enter the Amount to withdrawn: ");
        int with = sc.nextInt();
        if (this.balance < with ) {
            System.out.println("You account is low!!!!!!!!!!!!!");
            meth();
        }else {
            this.balance -= with;
            meth();

        }

    }
    public void deposit() {
        System.out.println("Enter the Amount for deposit: ");
        int depo = sc.nextInt();
        this.balance += depo;
        System.out.println("Money Deposit Successfully");
        meth();
    }
    public void exit() {
        System.out.println("Thank You for Visiting!!!!!!");
    }
}
public class ATM {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Machine inst = new Machine(100f,5023);
        System.out.println("Enter the PIN");
        int ePIN = sc.nextInt();
        if(ePIN == inst.PIN) {
            inst.meth();
        }else {

        System.out.println("PIN incorrect");
        }
    }
}
