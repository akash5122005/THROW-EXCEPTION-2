import java.util.Scanner;

class InsufficientFundsException extends Exception{
    public InsufficientFundsException(String message){
        super(message);
    }
}
class BankAccount{
    private double balance;

    public BankAccount(double initialBalance){
        this.balance = initialBalance;
    }
    public void deposit(double amount){
        if(amount > 0){
            balance += amount;
        }
    }
    public void withdraw(double amount) throws InsufficientFundsException{
        if (amount > balance){
            throw new InsufficientFundsException("Error: Insufficient funds for withdrawal");
        }
        balance -= amount;
    }
    public double getBalance(){
        return balance;
    }
}
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        double initialBalance = Double.parseDouble(scanner.nextLine());
        double withdrawalAmount = Double.parseDouble(scanner.nextLine());

        BankAccount account = new BankAccount(initialBalance);
        try{
            account.withdraw(withdrawalAmount);
            System.out.println("Withdrawal successful. ");
            System.out.println("Remaining balance: "+ account.getBalance());
        } catch(InsufficientFundsException e){
            System.out.println(e.getMessage());
        } catch(Exception e){
            System.out.println("An unexcepted error occured: "+e.getMessage());
        } finally{
            scanner.close();
        }
    }
}
