package model;

import model.exception.NoSuchAccountException;

import java.util.ArrayList;

public class Bank {

    private String name;
    private Person manager;
    private ArrayList<Account> accounts;

    public Bank(String name, Person manager) {
        if (manager == null) {
            throw new NullPointerException("The manager of a bank must not be null!");
        }

        this.name = name;
        this.manager = manager;
        this.accounts = new ArrayList<>();
    }

    public void addAccount(Account account) {
        this.accounts.add(account);
    }

    public void removeAccount(Account account) {
        this.accounts.remove(account);
    }

    public double getTotalBalance() {
        double total = 0;

        for (Account account : accounts) {
            total += account.getBalance();
        }

        return total;
    }

    public void transferMoney(String fromAccountNr, String toAccountNr, double amount) {
        Account fromAccount = this.getAccountByNr(fromAccountNr);
        Account toAccount = this.getAccountByNr(toAccountNr);

        if (fromAccount == null) {
            throw new NoSuchAccountException(fromAccountNr);
        }
        if (toAccount == null) {
            throw new NoSuchAccountException(toAccountNr);
        }


        this.transferMoney(fromAccount, toAccount, amount);
    }

    public void transferMoney(Account fromAccount, Account toAccount, double amount) {
        if (fromAccount == null) {
            throw new NullPointerException("Transfer account is null! (fromAccount=null)");
        }
        if (toAccount == null) {
            throw new NullPointerException("Transfer account is null! (toAccount=null)");
        }

        fromAccount.transferMoneyTo(toAccount, amount);
    }


    public String getName() {
        return name;
    }

    public Person getManager() {
        return manager;
    }

    public ArrayList<Account> getAccounts() {
        return accounts;
    }

    public Account getAccountByNr(String nr) {

        for (Account account : accounts) {
            if (account.isAccountWithNr(nr)) {
                return account;
            }
        }

        return null;
    }


    @Override
    public String toString() {
        return "Bank{" +
                "name='" + name + '\'' +
                ", manager=" + manager +
                ", accounts=" + accounts +
                '}';
    }
}
