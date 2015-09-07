package mobappdev.logginglife;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Bobby on 9/7/2015.
 */
public class BankAccount {
    public static final int CHECKING = 2;
    public static final int SAVINGS = 4;

    private static int LAST_ACCOUNT_NUMBER = 100000;

    private int mType;
    private int mAccountNumber;
    private double mBalance;
    private List<Transaction> mTransactionList;

    public BankAccount(int type) {
        this(type, ++LAST_ACCOUNT_NUMBER, 0.0d);
    }

    public BankAccount(int type, int accountNumber, double balance) {
        mType = type;
        mAccountNumber = accountNumber;
        mBalance = balance;
        mTransactionList = new ArrayList<>();
    }

    public void deposit(double amount) {
        Transaction transaction = new Transaction(amount, "Deposit");
        mTransactionList.add(transaction);
        mBalance = mBalance + amount;
    }

    public void withdraw(double amount) {
        Transaction transaction = new Transaction(amount, "Withdrawal");
        mTransactionList.add(transaction);
        mBalance = mBalance = amount;
    }

    public double getBalance() {
        return mBalance;
    }

    public List<Transaction> getTransactionList() {
        return mTransactionList;
    }

    public int getType() {
        return mType;
    }

    public int getAccountNumber() {
        return mAccountNumber;
    }
}
