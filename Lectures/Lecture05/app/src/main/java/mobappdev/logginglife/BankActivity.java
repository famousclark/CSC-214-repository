package mobappdev.logginglife;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

import java.text.DateFormat;
import java.util.List;

public class BankActivity extends Activity {

    private TextView mTextViewCustomerName;
    private TextView mTextViewAccountNumber;
    private TextView mTextViewAccountType;
    private TextView mTextViewAccountBalance;
    private TextView mTextViewTransaction01;
    private TextView mTextViewTransaction02;
    private TextView mTextViewTransaction03;
    private TextView mTextViewTransaction04;
    private ImageButton mButtonPrevious;
    private ImageButton mButtonNext;

    private Customer mCustomer;
    private int mAccountIndex;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bank);

        initCustomer();
        mAccountIndex = 0;

        mTextViewCustomerName = (TextView)findViewById(R.id.text_view_customer_name);
        mTextViewCustomerName.setText( mCustomer.getLastName() + ", " + mCustomer.getFirstName());

        mTextViewAccountNumber = (TextView)findViewById(R.id.text_view_account_number);
        mTextViewAccountType = (TextView)findViewById(R.id.text_view_account_type);
        mTextViewAccountBalance = (TextView)findViewById(R.id.text_view_account_balance);
        // obviously there is a better way to display the transaction list, but we
        // won't learn about that for a few lectures...
        mTextViewTransaction01 = (TextView)findViewById(R.id.text_view_transaction01);
        mTextViewTransaction02 = (TextView)findViewById(R.id.text_view_transaction02);
        mTextViewTransaction03 = (TextView)findViewById(R.id.text_view_transaction03);
        mTextViewTransaction04 = (TextView)findViewById(R.id.text_view_transaction04);

        mButtonPrevious = (ImageButton)findViewById(R.id.button_previous);
        mButtonPrevious.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mAccountIndex = mAccountIndex - 1;
                if(mAccountIndex < 0) {
                    mAccountIndex = 2;
                }
                updateBankAccount();
            }
        });


        mButtonNext = (ImageButton)findViewById(R.id.button_next);
        mButtonNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mAccountIndex = mAccountIndex + 1;
                if(mAccountIndex > 2) {
                    mAccountIndex = 0;
                }
                updateBankAccount();
            }
        });

        updateBankAccount();
    }



    private void updateBankAccount() {
        BankAccount account = mCustomer.getBankAccountList().get(mAccountIndex);
        String type;
        switch(account.getType()) {
            case BankAccount.CHECKING:
                type = "Checking";
                break;
            case BankAccount.SAVINGS:
                type = "Savings";
                break;
            default:
                type = "Unknown";
                break;
        }
        mTextViewAccountType.setText(type);
        mTextViewAccountNumber.setText(Integer.toString(account.getAccountNumber()));
        mTextViewAccountBalance.setText(String.format("%.2f", account.getBalance()));
        List<Transaction> transactions = account.getTransactionList();
        updateTransactionTextView(mTextViewTransaction01, transactions.get(0));
        updateTransactionTextView(mTextViewTransaction02, transactions.get(1));
        updateTransactionTextView(mTextViewTransaction03, transactions.get(2));
        updateTransactionTextView(mTextViewTransaction04, transactions.get(3));
    }

    private void updateTransactionTextView(TextView textView, Transaction transaction) {
        String label = DateFormat.getDateTimeInstance().format(transaction.getDate()) + " " +
                transaction.getDescription() + " " + String.format("%.2f", transaction.getAmount());
        textView.setText(label);
    }

    /**
     * The bank account needs to be populated
     */
    private void initCustomer() {
        mCustomer = new Customer("Boba", "Fett");

        BankAccount account01 = new BankAccount(BankAccount.CHECKING);
        account01.deposit(100.0);
        account01.withdraw(55.0);
        account01.withdraw(10.0);
        account01.deposit(101.0);
        mCustomer.addBankAccount(account01);

        BankAccount account02 = new BankAccount(BankAccount.SAVINGS);
        account02.deposit(150.0);
        account02.withdraw(25.0);
        account02.withdraw(20.0);
        account02.withdraw(30.0);
        mCustomer.addBankAccount(account02);

        BankAccount account03 = new BankAccount(BankAccount.CHECKING);
        account03.deposit(130.0);
        account03.withdraw(35.0);
        account03.withdraw(21.0);
        account03.withdraw(31.0);
        mCustomer.addBankAccount(account03);
    }
}
