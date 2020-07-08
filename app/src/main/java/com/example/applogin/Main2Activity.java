package com.example.applogin;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.hardware.biometrics.BiometricPrompt;
import android.os.Build;
import android.os.Bundle;
import android.os.CancellationSignal;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
import java.util.jar.Attributes;

public class Main2Activity extends AppCompatActivity {

    private EditText name;
    private EditText password;
    private Button login;

    @RequiresApi(api = Build.VERSION_CODES.P)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);


        final Executor executor = Executors.newSingleThreadExecutor();

        final BiometricPrompt biometricPrompt = new BiometricPrompt.Builder(this)
                .setTitle("Finger Print Authentication")
                .setSubtitle("To register a new user")
                .setDescription("This is important for your security")
                .setNegativeButton("Cancel", executor, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                    }
                }).build();

        name= (EditText) findViewById(R.id.editText);
        password= (EditText) findViewById(R.id.editText2);
        login=(Button) findViewById(R.id.button3);

        TextView authenticate = findViewById(R.id.registerNew);

        authenticate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                biometricPrompt.authenticate(new CancellationSignal(), executor, new BiometricPrompt.AuthenticationCallback() {
                    @Override
                    public void onAuthenticationSucceeded(BiometricPrompt.AuthenticationResult result) {

                        Intent reg = new Intent(Main2Activity.this,RegisterActivity.class);
                        startActivity(reg);
                        finish();
                    }
                });
            }
        });

    }

    public void back(View view)
    {
        Intent back=new Intent(Main2Activity.this,MainActivity.class);
        startActivity(back);
        finish();
    }

    public void validate(String usrnm,String usrps)
    {
        if (usrnm.equals("sahilanime483@gmail.com") && usrps.equals("Keima483"))
        {
            Intent log=new Intent(Main2Activity.this,FinalActivity.class);
            startActivity(log);
            finish();
        }
        else
        {
            Toast.makeText(Main2Activity.this,"Incorrect Password or eMail ID",Toast.LENGTH_SHORT).show();
        }
    }

    public void test(View view)
    {
        validate(name.getText().toString(),password.getText().toString());
    }

}
