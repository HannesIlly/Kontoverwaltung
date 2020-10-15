package model;

import model.exception.NotEnoughMoneyException;

import java.util.Objects;

public class Account {

    private Person owner;
    private String nr;
    private double balance;
    private String test;

    public Account(Person owner, String nr, double balance) {
        this.owner = owner;
        this.nr = nr;
        this.balance = balance;
    }

    public Person getOwner() {
        return owner;
    }

    public String getNr() {
        return nr;
    }

    public boolean isAmountAvailable(double amount) {
        if (amount < 0) {
            throw new IllegalArgumentException("Amount cannot be smaller that zero! (amount=" + amount + ")");
        }
        return this.balance >= amount;
    }

    public double getBalance() {
        return balance;
    }

    public void transferMoneyTo(Account other, double amount) {
        if (other == null) {
            throw new NullPointerException("Account to transfer money to doesn't exist! (other=null)");
        }
        if (isAmountAvailable(amount)) {
            throw new NotEnoughMoneyException(this.balance, amount);
        }

        this.balance -= amount;
        other.balance += amount;
    }

    public boolean isAccountWithNr(String nr) {
        return this.nr.equals(nr);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Account that = (Account) o;
        return Objects.equals(nr, that.nr);
    }

    @Override
    public String toString() {
        return "Account{" +
                "owner=" + owner +
                ", nr='" + nr + '\'' +
                ", balance=" + balance +
                '}';
    }
}
