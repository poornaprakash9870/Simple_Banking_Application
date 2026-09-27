package Bank;

import java.util.ArrayList;
import java.util.Scanner;

public class services {
    static ArrayList<BankAccount> accounts = new ArrayList<>();

    public static BankAccount findAcc(int accNo){
        for(BankAccount bc : accounts){
            if(bc.getAccountNumber() == accNo){
                return bc;
            }
        }
        return null;
    }

    public static void createAcc(Scanner sc){
        sc.nextLine();
        System.out.print("Enter Name : ");
        String name = sc.nextLine();
        System.out.print("Create Password : ");
        String password = sc.nextLine();
        System.out.print("Enter Initial Balance : ");
        double balance = sc.nextDouble();
        BankAccount acc = new BankAccount(name, password, balance);
        accounts.add(acc);
        System.out.println("Account Created Successfully");
        System.out.println("Account Number : " + acc.getAccountNumber());
    }

    public static BankAccount login(Scanner sc) {
        System.out.print("Enter Account Number : ");
        int accNo = sc.nextInt();
        sc.nextLine();
        System.out.print("Enter Password : ");
        String password = sc.nextLine();
        BankAccount acc = findAcc(accNo);
        if(acc == null) {
            System.out.println("Account Not Found");
            return null;
        }
        if(!acc.login(password)) {
            System.out.println("Incorrect Password");
            return null;
        }
        System.out.println("Login Successful");
        return acc;
    }

    public static void accountMenu(Scanner sc, BankAccount acc) {
        while(true) {
            System.out.println("------ ACCOUNT MENU --------");
            System.out.println("1. Deposit");
            System.out.println("2. Withdraw");
            System.out.println("3. Transfer");
            System.out.println("4. Balance");
            System.out.println("5. Details");
            System.out.println("6. Transactions");
            System.out.println("7. Logout");

            System.out.print("Enter Choice : ");
            int choice = sc.nextInt();
            switch(choice) {
                case 1:
                    System.out.print("Enter Amount : ");
                    double dep = sc.nextDouble();
                    AccountOperations.deposit(acc, dep);
                    break;
                case 2:
                    System.out.print("Enter Amount : ");
                    double with = sc.nextDouble();
                    AccountOperations.withdraw(acc, with);
                    break;
                case 3:
                    System.out.print("Enter Receiver Account Number : ");
                    int receiverNo = sc.nextInt();
                    BankAccount receiver = findAcc(receiverNo);
                    if(receiver == null) {
                        System.out.println("Receiver Account Not Found");
                        break;
                    }
                    System.out.print("Enter Amount : ");
                    double amount = sc.nextDouble();
                    AccountOperations.transfer(acc, receiver, amount);
                    break;
                case 4:
                    System.out.println("Balance : " + acc.getBalance());
                    break;
                case 5:
                    acc.showDetails();
                    break;
                case 6:
                    AccountOperations.showTranscations(acc);
                    break;
                case 7:
                    System.out.println("Logged Out");
                    return;
                default:
                    System.out.println("Invalid Choice");
            }
        }
    }
}


