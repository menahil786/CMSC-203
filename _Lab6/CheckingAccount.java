// CheckingAccount.java
public class CheckingAccount extends BankAccount {
    private static final double FEE = 0.15; // 15 cents

    public CheckingAccount(String name, double amount) {
        super(name, amount);
        String updatedAccountNumber = super.getAccountNumber() + "-10";
        super.setAccountNumber(updatedAccountNumber);
    }

    @Override
    public boolean withdraw(double amount) {
        amount += FEE;
        return super.withdraw(amount);
    }
}
