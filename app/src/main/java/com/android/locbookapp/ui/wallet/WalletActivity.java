package com.android.locbookapp.ui.wallet;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.IdRes;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import com.android.locbookapp.R;
import com.android.locbookapp.data.LocBookDatabase;
import com.android.locbookapp.ui.signin.Signin;
import com.android.locbookapp.ui.signup.Signup;
import com.github.clans.fab.FloatingActionButton;
import com.github.clans.fab.FloatingActionMenu;
import com.google.android.material.textfield.TextInputLayout;

public class WalletActivity extends AppCompatActivity implements View.OnClickListener {

    public TextInputLayout tlAccountNumber, tlCvv, tlAmount, tlCardHolder;
    public TextView walletAmount;
    String[] mCount = {"    01 ", "    02 ", "    03 ", "    04 ", "    05 ", "    06 ", "    07 ", "    08 ", "    09 ", "    10 ", "    11 ", "    12 "};
    String[] yCount = {" 2015 ", " 2016 ", " 2017 ", " 2018 ", " 2019 ", " 2020 ", " 2021 "};
    ArrayAdapter<String> monthAdapter, yearAdapter;
    private FloatingActionMenu fam;
    private FloatingActionButton fabPin;
    private Toolbar toolbar;
    private Spinner monthSpinner, yearSpinner;
    private RadioGroup cardType;
    private Button addMoney;
    private String strCardType, strCardHolderName;
    private Editable numAccountNumber, numCvv, numAmount;
    private EditText accountNumber, cvv, amount, cardHolderName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_wallet);
        toolbar = (Toolbar) findViewById(R.id.tool_bar);

        // Wallet Fields
        cardType = (RadioGroup) findViewById(R.id.card_type_radio);
        // text input layouts
        tlAccountNumber = (TextInputLayout) findViewById(R.id.tl_account_number);
        tlCvv = (TextInputLayout) findViewById(R.id.tl_cvv);
        tlAmount = (TextInputLayout) findViewById(R.id.tl_withdrawl_amount);
        tlCardHolder = (TextInputLayout) findViewById(R.id.tl_card_holder_name);
        // edit text
        accountNumber = (EditText) findViewById(R.id.account_number);
        cvv = (EditText) findViewById(R.id.cvv);
        amount = (EditText) findViewById(R.id.withdrawl_amount);
        cardHolderName = (EditText) findViewById(R.id.card_holder_name);

        walletAmount = (TextView) findViewById(R.id.wallet_amount);
        addMoney = (Button) findViewById(R.id.add_money_btn);
        Signin s = new Signin();

        walletAmount.setText(s.walletAmount);
        // edit text to int
        numAccountNumber = accountNumber.getText();
        numCvv = cvv.getText();
        numAmount = amount.getText();

        cardType.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, @IdRes int checkedId) {
                switch (checkedId) {
                    case R.id.credit:
                        strCardType = "credit";
                        break;
                    case R.id.debit:
                        strCardType = "debit";
                        break;
                }
            }
        });

        addMoney.setOnClickListener(this);

        // month spinner
        monthSpinner = (Spinner) findViewById(R.id.month_spinner);
        monthAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, mCount);
        monthAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        monthSpinner.setAdapter(monthAdapter);
        monthSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        // year spinner
        yearSpinner = (Spinner) findViewById(R.id.year_spinner);
        yearAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, yCount);
        yearAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        yearSpinner.setAdapter(yearAdapter);
        yearSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        setSupportActionBar(toolbar);
        setTitle("Wallet");

        if (getSupportActionBar() != null) {
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
            getSupportActionBar().setDisplayShowHomeEnabled(true);
        }


        //floating action menu code
        fabPin = (FloatingActionButton) findViewById(R.id.fab_pin);
        fam = (FloatingActionMenu) findViewById(R.id.fab_menu);

        //fab color
        fam.setMenuButtonColorNormalResId(R.color.colorPrimary);
        fabPin.setColorNormalResId(R.color.fabColor);

        //handling menu status (open or close)
        fam.setOnMenuToggleListener(new FloatingActionMenu.OnMenuToggleListener() {
            @Override
            public void onMenuToggle(boolean opened) {
                if (opened) {
                } else {
                }
            }
        });

        //handling each floating action button clicked
        fabPin.setOnClickListener(onButtonClick());

        fam.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (fam.isOpened()) {
                    fam.close(true);
                }
            }
        });

    }

    private View.OnClickListener onButtonClick() {
        return new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (view == fabPin) {
                    fam.close(true);

                }
            }
        };

    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        if (item.getItemId() == android.R.id.home)
            finish();
        return super.onOptionsItemSelected(item);
    }

    private boolean ValidateFields() {
        Signup s = new Signup();

        // Account number
        if (accountNumber.length() == 0) {
            tlAccountNumber.setErrorEnabled(false);
            tlAccountNumber.setError("Empty Field ");
            accountNumber.addTextChangedListener(new TextWatcher() {
                @Override
                public void beforeTextChanged(CharSequence s, int start, int count, int after) {

                }

                @Override
                public void onTextChanged(CharSequence s, int start, int before, int count) {

                }

                @Override
                public void afterTextChanged(Editable s) {
                    if (accountNumber.length() > 0) {
                        tlAccountNumber.setError(null);
                    }
                }
            });
            return false;
        }

        // Card Holder name
        if (cardHolderName.length() == 0) {
            tlCardHolder.setErrorEnabled(false);
            tlCardHolder.setError("Empty Field ");
            cardHolderName.addTextChangedListener(new TextWatcher() {
                @Override
                public void beforeTextChanged(CharSequence s, int start, int count, int after) {

                }

                @Override
                public void onTextChanged(CharSequence s, int start, int before, int count) {

                }

                @Override
                public void afterTextChanged(Editable s) {
                    if (cardHolderName.length() > 0) {
                        tlCardHolder.setError(null);
                    }
                }
            });
            return false;
        }

        // CVV
        else if (cvv.length() == 0) {
            tlCvv.setErrorEnabled(false);
            tlCvv.setError("Empty Field ");
            cvv.addTextChangedListener(new TextWatcher() {
                @Override
                public void beforeTextChanged(CharSequence s, int start, int count, int after) {

                }

                @Override
                public void onTextChanged(CharSequence s, int start, int before, int count) {

                }

                @Override
                public void afterTextChanged(Editable s) {
                    if (cvv.length() > 0) {
                        tlCvv.setError(null);
                    }
                }
            });
            return false;
        }

        // Amount
        else if (amount.length() == 0) {
            tlAmount.setErrorEnabled(false);
            tlAmount.setError("Empty Field ");
            amount.addTextChangedListener(new TextWatcher() {
                @Override
                public void beforeTextChanged(CharSequence s, int start, int count, int after) {

                }

                @Override
                public void onTextChanged(CharSequence s, int start, int before, int count) {

                }

                @Override
                public void afterTextChanged(Editable s) {
                    if (amount.length() > 0) {
                        tlAmount.setError(null);
                    }
                }
            });
            return false;
        } else if (numAmount.equals("0")) {
            tlAmount.setError("Zero amount");
            return false;
        }

        // card type radio button validation
        else if (cardType.getCheckedRadioButtonId() == -1) {
            Toast.makeText(WalletActivity.this, "Select Card Type", Toast.LENGTH_SHORT).show();
            return false;
        } else if (monthSpinner.getSelectedItemPosition() < 0 && yearSpinner.getSelectedItemPosition() < 0) {
            Toast.makeText(WalletActivity.this, "Select Expiry Date", Toast.LENGTH_SHORT).show();
            return false;
        } else {
            tlAmount.setError(null);
            tlCvv.setError(null);
        }

        return true;
    }

    // add actions to add_money button

    @Override
    public void onClick(View v) {
        if (v == addMoney) {
            boolean validationResults = ValidateFields();

            if (validationResults == true)  // send wallet details to DB
            {
                LocBookDatabase d = new LocBookDatabase(getBaseContext());

                String wm = String.valueOf(numAmount);
                Signin s = new Signin();
                if (s.walletAmount.equals("")) {
                    String Sql = "Insert into lb_wallet (card_type,account_number,expiry_date,wallet_amount,card_holder_name) " +
                            " Values('" + cardType.toString() + "','" + accountNumber.getText().toString() + "','01/2020','" + amount.getText().toString() + "','" + cardHolderName.getText().toString() + "') ";
                    d.ExecuteDB(Sql, getBaseContext());
                    walletAmount.setText(amount.getText().toString());
                } else {
                    Integer Amt = Integer.parseInt(s.walletAmount) + Integer.parseInt(amount.getText().toString());
                    String Sql = "Update lb_wallet set wallet_amount = '" + Amt + "' ";

                    d.ExecuteDB(Sql, getBaseContext());
                    walletAmount.setText(Amt);
                }
                Toast.makeText(WalletActivity.this, "Validation !!", Toast.LENGTH_SHORT).show();
            }
        }
    }
}