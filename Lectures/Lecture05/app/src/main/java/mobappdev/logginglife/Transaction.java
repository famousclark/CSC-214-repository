package mobappdev.logginglife;

import java.util.Date;

/**
 * Created by Bobby on 9/7/2015.
 */
public class Transaction {
    private final Date mDate;
    private final double mAmount;
    private final String mDescription;

    public Transaction(double amount, String description) {
        this(new Date(), amount, description);
    }

    public Transaction(Date date, double amount, String description) {
        mDate = date;
        mAmount = amount;
        mDescription = description;
    }

    public Date getDate() {
        return mDate;
    }

    public double getAmount() {
        return mAmount;
    }

    public String getDescription() {
        return mDescription;
    }
}
