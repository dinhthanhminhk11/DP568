package com.example.dp568dapp.ui.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.TextView;

import com.example.dp568dapp.R;

public class ResigiterActivity extends AppCompatActivity {
    private ImageView logo;
    private TextView titleLogin;
    private EditText username;
    private EditText password;
    private EditText passwordver2;
    private EditText phone;
    private Spinner spinner2;
    private LinearLayout content;
    private EditText textAccuracy;
    private EditText accuracy;
    private Button login;
    private TextView textDangKi;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_resigiter);


        logo = (ImageView) findViewById(R.id.logo);
        titleLogin = (TextView) findViewById(R.id.titleLogin);
        username = (EditText) findViewById(R.id.username);
        password = (EditText) findViewById(R.id.password);
        passwordver2 = (EditText) findViewById(R.id.passwordver2);
        phone = (EditText) findViewById(R.id.phone);
        spinner2 = (Spinner) findViewById(R.id.spinner2);
        content = (LinearLayout) findViewById(R.id.content);
        textAccuracy = (EditText) findViewById(R.id.text_accuracy);
        accuracy = (EditText) findViewById(R.id.accuracy);
        login = (Button) findViewById(R.id.login);
        textDangKi = (TextView) findViewById(R.id.textDangKi);
        String[] years = {"1996","1997","1998","1998"};
        ArrayAdapter<CharSequence> langAdapter = new ArrayAdapter<CharSequence>(this, R.layout.spinner_text, years );
        langAdapter.setDropDownViewResource(R.layout.simple_spinner_dropdown);
        spinner2.setAdapter(langAdapter);

    }
}