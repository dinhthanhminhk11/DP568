package com.example.dp568dapp.ui.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.TextView;

import com.example.dp568dapp.R;
import com.google.android.material.textfield.TextInputLayout;

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
    private TextInputLayout contentInputLayout;
    private AutoCompleteTextView autoComplete;
    private ArrayAdapter<String> adapterItems;
    String[] items = {
            "Đồng Việt Nam",
            "Đồng Usa"
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_resigiter);

        Window window = this.getWindow();
        window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
        window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
        window.setStatusBarColor(ContextCompat.getColor(this, R.color.white_F6F7FE));

        autoComplete = (AutoCompleteTextView) findViewById(R.id.autoComplete);
        logo = (ImageView) findViewById(R.id.logo);
        titleLogin = (TextView) findViewById(R.id.titleLogin);
        username = (EditText) findViewById(R.id.username);
        password = (EditText) findViewById(R.id.password);
        passwordver2 = (EditText) findViewById(R.id.passwordver2);
        phone = (EditText) findViewById(R.id.phone);
        content = (LinearLayout) findViewById(R.id.content);
        textAccuracy = (EditText) findViewById(R.id.text_accuracy);
        accuracy = (EditText) findViewById(R.id.accuracy);
        login = (Button) findViewById(R.id.login);
        textDangKi = (TextView) findViewById(R.id.textDangKi);
        adapterItems = new ArrayAdapter<String>(this, R.layout.list_item, items);
        autoComplete.setAdapter(adapterItems);

        autoComplete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

        textDangKi.setOnClickListener(v -> {
            onBackPressed();
        });

    }
}