package Bank;

public class AccountOperations {
    public static void deposit(BankAccount acc,double amt){
        if(amt<0){
            System.out.println("Invalid Account");
            return;
        }

        acc.setBalance(acc.getBalance()+amt);
        Transaction t = new Transaction("Deposited",amt);
        acc.getHistory().add(t);
        System.out.println("Money Deposited Successfully");
    }

    public static void withdraw(BankAccount acc,double amt){
        if(amt<=0){
            System.out.println("Mad how can you withdraw zero rupees");
            return;
        }
        if(amt>acc.getBalance()){
            System.out.println("Insufficient balance");
            return;
        }
        acc.setBalance(acc.getBalance() - amt);
        Transaction t = new Transaction("Withdraw",amt);
        acc.getHistory().add(t);
        System.out.println("Money withdraw successfully");
    }

    public static void transfer(BankAccount sender ,BankAccount Receiver,double amt){
        if(amt<=0){
            System.out.println("U cant transfer zero rupees");
            return;
        }

        sender.setBalance(sender.getBalance() - amt);
        Receiver.setBalance(Receiver.getBalance() + amt);
        sender.getHistory().add(new Transaction("Tranferred",amt));
        Receiver.getHistory().add(new Transaction("Received",amt));
        System.out.println("Transferred Successfully");
    }

    public static void showTranscations(BankAccount acc){
        if(acc.getHistory().isEmpty()){
            System.out.println("No Transcations");
            return;
        }
        System.out.println("----- TRANSACTION HISTORY---------");
        for(Transaction t : acc.getHistory()) {
            System.out.println(t);
        }
    }

}
