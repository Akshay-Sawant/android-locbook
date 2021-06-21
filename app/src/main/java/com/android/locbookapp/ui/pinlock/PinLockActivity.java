package com.android.locbookapp.ui.pinlock;

import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.android.locbookapp.R;
import com.android.locbookapp.ui.wallet.WalletActivity;
import com.nightonke.blurlockview.BlurLockView;
import com.nightonke.blurlockview.Directions.HideType;
import com.nightonke.blurlockview.Eases.EaseType;
import com.nightonke.blurlockview.Password;

public class PinLockActivity extends AppCompatActivity {

    private ImageView imageView;
    private BlurLockView blurLockView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pin_lock);

        blurLockView = (BlurLockView) findViewById(R.id.blur_lock_view);
        blurLockView.setBlurredView(imageView);

        imageView = (ImageView) findViewById(R.id.pin_lock_bg);

        blurLockView.setCorrectPassword("0000");
        blurLockView.setTitle("Enter your PIN");
        blurLockView.setLeftButton("");
        blurLockView.setRightButton("");
        blurLockView.setType(Password.NUMBER, false);
        blurLockView.setTypeface(Typeface.DEFAULT);

        blurLockView.setOnPasswordInputListener(new BlurLockView.OnPasswordInputListener() {
            @Override
            public void correct(String inputPassword) {
                blurLockView.hide(1000, HideType.FADE_OUT, EaseType.EaseInBounce);
                startActivity(new Intent(PinLockActivity.this, WalletActivity.class));
                finish();
            }

            @Override
            public void incorrect(String inputPassword) {
                Toast.makeText(PinLockActivity.this, " Incorrect Pin ", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void input(String inputPassword) {

            }
        });

    }
}