package Bank;

import java.util.ArrayList;

public class BankAccount{
    private static int idCounter = 0;
    private int accountNumber;
    private String name;
    private String password;
    private double balance;

    public BankAccount(String name,String password,double balance){
        this.accountNumber = ++idCounter;
        this.name = name;
        this.password = password;
        this.balance = balance;
    }

    public int getAccountNumber(){
        return accountNumber;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    private ArrayList<Transaction> history = new ArrayList<>();
    public ArrayList<Transaction> getHistory() {
        return history;
    }


    public void showDetails() {
        System.out.println("Account Number : " + accountNumber);
        System.out.println("Name           : " + name);
        System.out.println("Balance        : " + balance);
    }

    public boolean login(String password) {
        return this.password.equals(password);
    }


}
