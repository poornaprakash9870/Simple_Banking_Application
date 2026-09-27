package Bank;

public class Transaction {
    private String type;
    private double amt;

    public Transaction(String type,double amt){
        this.type = type;
        this.amt = amt;
    }

    public String toString(){
        return type +": "+amt;
    }
}
