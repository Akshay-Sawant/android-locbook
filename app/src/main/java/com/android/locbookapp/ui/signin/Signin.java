package com.android.locbookapp.ui.signin;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AlertDialog;
import androidx.fragment.app.Fragment;

import com.android.locbookapp.R;
import com.android.locbookapp.data.LocBookDatabase;
import com.android.locbookapp.ui.navigation.NavigationDrawer;
import com.android.locbookapp.ui.registration.RegistrationActivity;
import com.android.locbookapp.ui.signup.Signup;
import com.android.locbookapp.ui.wallet.WalletActivity;

import org.json.JSONArray;
import org.json.JSONObject;

public class Signin extends Fragment {

    public String walletAmount = "";
    private EditText username, password;
    private TextView forgetPass;
    private Button login, skip;
    private LocBookDatabase locBookDatabase;

    public Signin() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_signin, container, false);

        username = (EditText) v.findViewById(R.id.user_name);
        password = (EditText) v.findViewById(R.id.user_password);
        forgetPass = (TextView) v.findViewById(R.id.forget_pass_text);
        login = (Button) v.findViewById(R.id.login_button);
        skip = (Button) v.findViewById(R.id.skip_button);
        locBookDatabase = new LocBookDatabase(getContext());

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SignInToApp();
            }
        });

        skip.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                LayoutInflater li = LayoutInflater.from(getContext());
                View promptView = li.inflate(R.layout.project_intro, null);
                final AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(getContext(), R.style.Theme_AppCompat_Light_Dialog_Alert);
                alertDialogBuilder.setView(promptView);
                //set dialog message
                alertDialogBuilder.setCancelable(false).setPositiveButton("ok, I got it", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        startActivity(new Intent(getActivity(), NavigationDrawer.class));
                    }
                });
                AlertDialog alertDialog = alertDialogBuilder.create();
                alertDialog.show();
            }
        });

        forgetPass.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Signup s = new Signup();
                s.otpDialog();
            }
        });

        return v;
    }

    public void SignInToApp() {
        try {
            LocBookDatabase db = new LocBookDatabase(getContext());
            String Sql = " Select * from User_Secure";
            JSONArray DataArray = db.QueryDB(Sql, getContext());
            for (int i = 0; i < DataArray.length(); i++) {
                JSONObject Obj = DataArray.getJSONObject(i);
                String UserName = username.getText().toString();
                String Pwd = password.getText().toString();

                if (UserName.equals(Obj.getString("user_name")) || Pwd.equals(Obj.getString("user_password"))) {
                    if (Obj.getString("status").equals("0")) {
                        Log.e("Please confirm", "Otp");
                        Toast.makeText(getContext(), "Please Confirm Otp", Toast.LENGTH_LONG).show();
                    } else {
                        RegistrationActivity R = new RegistrationActivity();
                        R.Username = Obj.getString("user_name");
                        R.Userid = Obj.getString("user_id");
                        String Sql2 = "select * from lb_wallet";
                        JSONArray Array = db.QueryDB(Sql2, getContext());
                        if (Array.length() > 0) {
                            JSONObject obj = Array.getJSONObject(0);
                            WalletActivity w = new WalletActivity();
                            walletAmount = obj.getString("wallet_amount");
                        }
                        Intent MyIntent = new Intent(getActivity(), NavigationDrawer.class);
                        startActivity(MyIntent);
                        Toast.makeText(getContext(), "Login Successfull", Toast.LENGTH_SHORT).show();
                    }
                }
            }
        } catch (Exception e) {
            Log.e("Error", "Signin" + e.getMessage());
        }

    }
}