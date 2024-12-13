public class BankTest {
    public static void main(String[] args)  {
        BankAccount0 KarimAccount = new BankAccount0();
        System.out.println("Account Number N°. - " + KarimAccount.getAccountNumber());
        KarimAccount.depositeMoney(600, "checking");
        KarimAccount.depositeMoney(200, "savings");
        KarimAccount.widhdarwMoney(100, "checking");
        KarimAccount.widhdarwMoney(250, "savings");
        KarimAccount.displayAccountBalance();
        System.out.println("Total Money Accounts: " + KarimAccount.totalMoneyAccounts());
        KarimAccount.widhdarwMoney(1000, "checking");

        System.out.println("/AnotherAnotherAnotherAnotherAnotherAnotherAnotherAnotherAnotherAnotherAnotherAnother/");
        BankAccount0 LobnaAccount = new BankAccount0();
        System.out.println("Account Number N°. - " + LobnaAccount.getAccountNumber());
        KarimAccount.depositeMoney(1600, "checking");
        KarimAccount.depositeMoney(500, "savings");
        KarimAccount.widhdarwMoney(700, "checking");
        
        KarimAccount.widhdarwMoney(2500, "savings");
        KarimAccount.displayAccountBalance();
        System.out.println("Total Money Accounts: " + KarimAccount.totalMoneyAccounts());
        KarimAccount.widhdarwMoney(600, "checking");

        System.out.println("/*******************************************************************/");
        System.out.println("Number of Accounts: " + BankAccount0.numberOfAccounts);

    }
}
