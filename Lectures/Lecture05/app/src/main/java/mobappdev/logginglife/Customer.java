package mobappdev.logginglife;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Bobby on 9/7/2015.
 */
public class Customer {
    private final String mFirstName;
    private final String mLastName;
    private final List<BankAccount> mBankAccountList;

    public Customer(String firstName, String lastName) {
        mFirstName = firstName;
        mLastName = lastName;

        mBankAccountList = new ArrayList<>();
    }

    public String getFirstName() {
        return mFirstName;
    }

    public String getLastName() {
        return mLastName;
    }

    public List<BankAccount> getBankAccountList() {
        return mBankAccountList;
    }

    public void addBankAccount(BankAccount account) {
        mBankAccountList.add(account);
    }
}
