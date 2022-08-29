package com.example.dp568dapp.ui.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import android.content.Intent;
import android.os.Bundle;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.dp568dapp.R;

public class LoginActivity extends AppCompatActivity {
    private ImageView logo;
    private TextView titleLogin;
    private EditText username;
    private EditText password;
    private LinearLayout content;
    private EditText textAccuracy;
    private EditText accuracy;
    private TextView orThor;
    private TextView forgotpassword;
    private Button login;
    private TextView textDangKi;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        Window window = this.getWindow();
        window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
        window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
        window.setStatusBarColor(ContextCompat.getColor(this, R.color.white_F6F7FE));

        logo = (ImageView) findViewById(R.id.logo);
        titleLogin = (TextView) findViewById(R.id.titleLogin);
        username = (EditText) findViewById(R.id.username);
        password = (EditText) findViewById(R.id.password);
        content = (LinearLayout) findViewById(R.id.content);
        textAccuracy = (EditText) findViewById(R.id.text_accuracy);
        accuracy = (EditText) findViewById(R.id.accuracy);
        orThor = (TextView) findViewById(R.id.orThor);
        forgotpassword = (TextView) findViewById(R.id.forgotpassword);
        login = (Button) findViewById(R.id.login);
        textDangKi = (TextView) findViewById(R.id.textDangKi);

        textDangKi.setOnClickListener(v -> {
            startActivity(new Intent(LoginActivity.this, ResigiterActivity.class));
        });
        orThor.setOnClickListener(v -> {
            startActivity(new Intent(LoginActivity.this, FreeTrialActivity.class));
        });
        login.setOnClickListener(v -> {
            startActivity(new Intent(LoginActivity.this, MainActivity.class));
        });


    }
}