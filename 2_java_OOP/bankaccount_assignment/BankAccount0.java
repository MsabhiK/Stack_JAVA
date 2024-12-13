import java.util.Random;

public class BankAccount0 {
    
    //Instance variables
    private int accountNumber;
    private double checkingBalance;
    private double savingsBalance;

    //static variables
    public static int numberOfAccounts=0;
    public static double totalBalance=0;
    public static double totalMoney=0;

    public BankAccount0() {
        numberOfAccounts += 1;
        this.checkingBalance = 0;
        this.savingsBalance = 0;
        this.accountNumber = BankAccount0.generateId();
    }

    public void depositeMoney(double amount, String typeAccount) {
        if(typeAccount.equalsIgnoreCase("checking")) {
            this.checkingBalance += amount;
        } else if(typeAccount.equalsIgnoreCase("savings")) {
            this.savingsBalance += amount;
        }
        BankAccount0.totalBalance += amount;
    }

    public void widhdarwMoney(double amount, String typeAccount) {
        boolean successfull = false;
        if(typeAccount.equalsIgnoreCase("checking")) {
            if(this.checkingBalance - amount >= 0) {
                System.out.println("Successuful widhdrawMoney " + amount + " from " + checkingBalance + " checking!!!");
                successfull = true;
                this.checkingBalance -= amount;
                
            }
            else {
                System.out.println("Insufficient funds in checking account to widhdraw: " + amount + " from " + checkingBalance + " checking!!!");
            }
        }
        else if(typeAccount.equalsIgnoreCase("savings")) {
            if(this.savingsBalance - amount >= 0) {
                System.out.println("Successful widhdraw money " + amount + " from " + savingsBalance + " savings!!!");
                successfull = true;
                this.savingsBalance -= amount;
            }
            else {
                System.out.println("Insufficient funds in savings account to widhdraw: " + amount + " from " + savingsBalance + " savings!!!");
            }
        }
        BankAccount0.totalBalance -= amount;
    }

    public void displayAccountBalance() {
		// %.2f formats decimal to the 10s place (like for moniez)
		System.out.println(String.format("Savings: %.2f, Checking: %.2f", this.savingsBalance, this.checkingBalance));
    }

    public double totalMoneyAccounts() {
        totalMoney += (checkingBalance + savingsBalance);
        return totalMoney;
    }


    public double getCheckingBalance() {
        return this.checkingBalance;
    }
    public double getSavingsBalance() {
        return this.savingsBalance;
    }

    public int getAccountNumber() {
        return this.accountNumber;
    }

    private static int generateId() {
		Random randGenerator = new Random();
        int randomId = randGenerator.nextInt(1000000000) + 999999999;
		return randomId;
	}
}
