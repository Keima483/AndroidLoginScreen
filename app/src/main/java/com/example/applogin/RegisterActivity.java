package com.example.applogin;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class RegisterActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
    }

    public void home(View view) {

        Intent back=new Intent(RegisterActivity.this,MainActivity.class);
        startActivity(back);
        finish();
    }

    public void backToLogin(View view) {

        Intent backToLog=new Intent(RegisterActivity.this,Main2Activity.class);
        startActivity(backToLog);
        finish();
    }
}
