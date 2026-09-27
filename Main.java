package Bank;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while(true) {
            System.out.println("------------- BANK MANAGEMENT SYSTEM ------------");
            System.out.println("1. Create Account");
            System.out.println("2. Login");
            System.out.println("3. Exit");
            System.out.print("Enter Choice : ");
            int choice = sc.nextInt();
            switch(choice) {
                case 1:
                    services.createAcc(sc);
                    break;
                case 2:
                    BankAccount acc = services.login(sc);
                    if(acc != null) {
                        services.accountMenu(sc, acc);
                    }
                    break;
                case 3:
                    System.out.println("Thank You");
                    return;
                default:
                    System.out.println("Invalid Choice");
            }
        }
    }
}