package com.keshar.mvvmdemo;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import android.database.Observable;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private TextView showUsername,showPassword;
    private EditText usernameEdt,passwordEdt;
    private Button clickmeBtn;
    private DemoViewModel demoViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        showUsername=findViewById(R.id.show_username);
        showPassword=findViewById(R.id.show_password);
        usernameEdt=findViewById(R.id.username_edt);
        passwordEdt=findViewById(R.id.password_edt);
        clickmeBtn=findViewById(R.id.click_btn);

        demoViewModel= ViewModelProviders.of(this).get(DemoViewModel.class);

        clickmeBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                demoViewModel.setData(usernameEdt.getText().toString(),passwordEdt.getText().toString());
            }
        });

        demoViewModel.getPassword().observe(this, new Observer<String>() {
            @Override
            public void onChanged(String s) {
                showPassword.setText(s);
            }
        });
        demoViewModel.getUsername().observe(this, new Observer<String>() {
            @Override
            public void onChanged(String s) {
                showUsername.setText(s);
            }
        });
    }
}
