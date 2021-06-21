package com.android.locbookapp.ui.signup;

import android.annotation.TargetApi;
import android.app.AlertDialog;
import android.app.DatePickerDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.icu.util.Calendar;
import android.os.Build;
import android.os.Bundle;
import android.telephony.SmsManager;
import android.text.Editable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.IdRes;
import androidx.fragment.app.Fragment;

import com.android.locbookapp.R;
import com.android.locbookapp.data.LocBookDatabase;
import com.google.android.material.textfield.TextInputLayout;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.Random;

public class Signup extends Fragment implements View.OnClickListener {

    public EditText newPhone, newEmail;
    public Button signUp;
    public String genderCheck;
    public String userEmail, userMobileNumber, dob, userName;
    Context context;
    String Gender = "";
    String DOB = "";
    private RadioGroup maleFemale;
    private CheckBox registerationCheck;
    private TextView displayDate;
    private ImageButton datePicker;
    private int mYear, mMonth, mDay;

    public Signup() {
        // Required empty public constructor

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View v = inflater.inflate(R.layout.fragment_signup, container, false);
        displayDate = (TextView) v.findViewById(R.id.dob_new_user);
        datePicker = (ImageButton) v.findViewById(R.id.date_picker);
        newPhone = (EditText) v.findViewById(R.id.new_phone_number);
        newEmail = (EditText) v.findViewById(R.id.new_user_email);
        maleFemale = (RadioGroup) v.findViewById(R.id.male_female_radio);
        registerationCheck = (CheckBox) v.findViewById(R.id.tandc_check);
        signUp = (Button) v.findViewById(R.id.sign_up);
        signUp.setOnClickListener(this);

        // setting up a listener
        datePicker.setOnClickListener(this);

        maleFemale.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, @IdRes int checkedId) {
                switch (checkedId) {
                    case R.id.radio_male:
                        genderCheck = "male";
                        break;
                    case R.id.radio_female:
                        genderCheck = "female";
                        break;
                }
            }
        });

       /* userEmail = newEmail.getText().toString().trim();
        userMobileNumber = newPhone.getText().toString().trim();
        dob = displayDate.getText().toString();
        Gender = genderCheck;*/

        return v;
    }

    @TargetApi(Build.VERSION_CODES.N)
    @Override
    public void onClick(View v) {
        if (v == datePicker) {

            // Get Current Date
            final Calendar c = Calendar.getInstance();
            mYear = c.get(Calendar.YEAR);
            mMonth = c.get(Calendar.MONTH);
            mDay = c.get(Calendar.DAY_OF_MONTH);

            DatePickerDialog datePickerDialog = new DatePickerDialog(getActivity(), R.style.DatePicker,
                    new DatePickerDialog.OnDateSetListener() {
                        @Override
                        public void onDateSet(DatePicker view, int year,
                                              int monthOfYear, int dayOfMonth) {

                            displayDate.setText(dayOfMonth + " / " + (monthOfYear + 1) + " / " + year);
                        }
                    }, mYear, mMonth, mDay);
            datePickerDialog.show();
        }

        if (v == signUp) {
            if (validateFields() == false) {
                newPhone.requestFocus();
            } else {
                otpDialog();
                SignUpToApp();
            }
        }
    }

    // function asking for otp
    public void otpDialog() {
        final LocBookDatabase db = new LocBookDatabase(getContext());
        LayoutInflater li = LayoutInflater.from(getContext());
        View otpPrompt = li.inflate(R.layout.otp_prompt, null);
        final AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(getContext(), R.style.RatingDialog);
        alertDialogBuilder.setView(otpPrompt);
        final Button verifyButton = (Button) otpPrompt.findViewById(R.id.otp_verify_button);
        final EditText otpEditText = (EditText) otpPrompt.findViewById(R.id.otp_edit_text);
        final Editable otpReceived = otpEditText.getText();

        verifyButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (otpReceived.length() > 0) {
                    // verify otp and ask for new password
                    try {
                        String Sql = "select mobile_otp from OTP order by ROWID DESC limit 1 ";
                        JSONArray IDArray = db.QueryDB(Sql, getContext());
                        final JSONObject Obj = IDArray.getJSONObject(0); // get First Object of array
                        if (Obj.getString("mobile_otp").equals(otpReceived.toString())) {
                            Toast.makeText(getContext(), " Verification Successful ", Toast.LENGTH_SHORT).show();
                            AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(getActivity(), R.style.DatePicker);
                            alertDialogBuilder.setMessage("Do you want to Change your Password?");
                            //set dialog message
                            alertDialogBuilder.setCancelable(false).setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialog, int which) {
                                    dialog.cancel();
                                    newPasswordDialog();
                                }
                            }).setNegativeButton("Later", new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialog, int which) {
                                    // save the user name and password without change in user_secure databse
                                    dialog.cancel();
                                    Toast.makeText(getActivity(), "Now you can Successfully login", Toast.LENGTH_SHORT).show();
                                }
                            });
                            AlertDialog alertDialog = alertDialogBuilder.create();
                            alertDialog.show();
                        } else {
                            Toast.makeText(getContext(), " Incorrect Otp. Try again. ", Toast.LENGTH_SHORT).show();
                        }
                    } catch (Exception e) {

                    }


                } else {
                    Toast.makeText(getContext(), " Try again ", Toast.LENGTH_SHORT).show();
                }
            }
        });

        AlertDialog alertDialog = alertDialogBuilder.create();
        alertDialog.show();
    }

    private void newPasswordDialog() {
        final LocBookDatabase db = new LocBookDatabase(getContext());
        LayoutInflater li = LayoutInflater.from(getContext());
        View newPassPrompt = li.inflate(R.layout.new_password_prompt, null);
        AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(getContext(), R.style.RatingDialog);
        alertDialogBuilder.setView(newPassPrompt);
        final EditText newPassword, confirmPassword;
        final TextInputLayout newPass, confirmPass;
        // edit text fields of newPassPrompt
        newPassword = (EditText) newPassPrompt.findViewById(R.id.new_password);
        confirmPassword = (EditText) newPassPrompt.findViewById(R.id.confirm_password);
        newPass = (TextInputLayout) newPassPrompt.findViewById(R.id.tl_new_password);
        confirmPass = (TextInputLayout) newPassPrompt.findViewById(R.id.tl_confirm_password);
        // String variables
        final String strNewPass = newPassword.getText().toString();
        final String strConfirmPass = confirmPassword.getText().toString();
        // dialog for confirmation
        alertDialogBuilder.setCancelable(false).setPositiveButton("Save", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                // verify both the fields and send data to user_secure table and redirect for login
                if (strNewPass.equalsIgnoreCase(strConfirmPass)) {
                    // save updated password to user secure with all details
                    String Sql = " Select * from User_Secure order by ROWID DESC limit 1 ";
                    try {
                        JSONArray UserArray = db.QueryDB(Sql, getContext());
                        final JSONObject Obj = UserArray.getJSONObject(0);
                        //if(Obj.getString("user_password").equals(strConfirmPass))
                        //{
                        String Sq = "update User_Secure set user_password = '" + strNewPass + "' where user_id = '" + Obj.getString("user_id") + "' ";
                        db.ExecuteDB(Sq, getContext());
                        dialog.cancel();

                        Toast.makeText(getActivity(), "Successfully Registered !! Now LogIn", Toast.LENGTH_SHORT).show();
                        // }
                    } catch (Exception e) {

                    }

                } else {
                    confirmPass.setErrorEnabled(false);
                    confirmPass.setError("Password do not match");
                }

            }
        }).setNegativeButton("Ok", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                // save the user name and password without change in user_secure database
                dialog.cancel();
                Toast.makeText(getActivity(), "Please Login with given ID & Password", Toast.LENGTH_SHORT).show();
            }
        });
        AlertDialog alertDialog = alertDialogBuilder.create();
        alertDialog.show();
    }

    private boolean validateFields() {
        String MobilePattern = "[0-9]{10}";
        String emailPattern = "[a-zA-Z0-9._-]+@[a-z]+\\.+[a-z]+";

        if (newEmail.length() == 0 || newPhone.length() == 0) {
            errorDialog("Fields cannot be Empty  ");
            return false;
        } else if (!newEmail.getText().toString().trim().matches(emailPattern) || !newPhone.getText().toString().trim().matches(MobilePattern)) {
            errorDialog("Invalid email id / phone number  ");
            return false;

        } else if (maleFemale.getCheckedRadioButtonId() == -1) {
            errorDialog("Gender is not Selected  ");
            return false;
        } else if (!registerationCheck.isChecked()) {
            errorDialog("Accept Terms and Condition  ");
            return false;
        }
        return true;
    }

    public void errorDialog(String errorMessage) {
        AlertDialog.Builder builder = new AlertDialog.Builder(getContext(), R.style.ErrorDialog);
        builder.setCancelable(true);
        builder.setTitle(errorMessage);
        builder.setIcon(R.drawable.error_icon);
        builder.setPositiveButton(
                "Ok",
                new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        dialog.cancel();
                        newPhone.requestFocus();
                    }
                });
        AlertDialog alert = builder.create();
        alert.show();
    }

    public void SignUpToApp() { // function on sign up button . put validation here
        userEmail = newEmail.getText().toString().trim();
        userMobileNumber = newPhone.getText().toString().trim();
        dob = displayDate.getText().toString();
        Gender = genderCheck;
        final LocBookDatabase db = new LocBookDatabase(getActivity());
        String Sql = " Insert into user_info (user_email,user_mobile,gender,user_dob) Values('" + userMobileNumber + "','" + userEmail + "','" + Gender + "','" + dob + "')";
        String Ex = db.ExecuteDB(Sql, getContext());
        if (Ex.equals("Success")) {
            Log.e("ssss", "ssss");
            GeneratAndSendOtp(userMobileNumber);
        }

    }

    public void GeneratAndSendOtp(final String MobileNumber) {

        try {

            Random generator = new Random();
            int Random_no = 288888;
            Random_no = generator.nextInt(Random_no);

            LocBookDatabase db = new LocBookDatabase(getContext());
            String Sql = "SELECT ROWID from user_info order by ROWID DESC limit 1";
            JSONArray IDArray = db.QueryDB(Sql, getContext());
            final JSONObject Obj = IDArray.getJSONObject(0); // get First Object of array
            String name = newEmail.getText().toString().substring(0, 6);
            Log.e("name_check", name);
            final String UserName = "Lb-" + name;
            final String num = String.valueOf(Random_no);
            final String Password = Obj.getInt("_uid") + 1 + num;
            final int MobileOtp = Random_no;
            final int EmailOtp = generator.nextInt(Random_no + 1);
            SendSmsAndSaveValues(MobileNumber, Obj.getInt("_uid"), UserName, Password, MobileOtp, EmailOtp);
        } catch (Exception e) {
            Log.e("Error", e.getMessage());
        }
    }

    public void SendSmsAndSaveValues(String MobileNumber, int ID, String UserName, String Password, int MobileOTP, int EmailOtp) {

        LocBookDatabase db = new LocBookDatabase(getContext());
        try {
            SmsManager sm = SmsManager.getDefault();
            String number = MobileNumber;
            String msg = "Your Otp is " + MobileOTP + " and Login by User Name : " + UserName + " and Password : " + Password + "  ";
            sm.sendTextMessage(number, null, msg, null, null);

            String Sql = " Insert into User_Secure ( user_id, user_name ,user_password ,status) Values( '" + ID + "', '" + UserName + "' , '" + Password + "' , '1' );";
            String Ex = db.ExecuteDB(Sql, getContext());

            if (Ex.equals("Success")) {
                String Sql1 = " Insert into OTP (user_id,mobile_otp,mail_otp) Values ( '" + ID + "' , '" + MobileOTP + "','" + EmailOtp + "'  ) ;";
                //Sql1 += "Insert into lb_wallet (card_type,account_number,expiry_date,wallet_amount) "
                String Ex1 = db.ExecuteDB(Sql1, getContext());
                //Open  Otp page and Check for otp and marke status of user_secure as 1 which means he can login into app
                Log.d("Successfull", Ex1);
            }

        } catch (Exception e) {
            String errMsg = e.getMessage();
            Log.e("Error", errMsg);
        }


    }
}
