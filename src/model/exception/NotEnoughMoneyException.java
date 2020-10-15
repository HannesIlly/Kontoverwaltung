package model.exception;

public class NotEnoughMoneyException extends IllegalArgumentException {
    public NotEnoughMoneyException(double balance, double amount) {
        super("Not enough money in the account! (balance=" + balance + ", amount=" + amount + ")");
    }
}
