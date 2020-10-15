package model.exception;

public class NoSuchAccountException extends IllegalArgumentException {

    public NoSuchAccountException(String accountNumber) {
        super("The account could not be found! (accountNumber=" + accountNumber + ")");
    }
}
