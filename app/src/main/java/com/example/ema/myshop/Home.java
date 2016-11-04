package com.example.ema.myshop;

import android.content.Context;
import android.content.Intent;
import android.provider.Telephony;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.telephony.TelephonyManager;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.Toast;

public class Home extends AppCompatActivity {
    private Button search;
    private Button signup;
    private Button signin;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_home);

//        TelephonyManager mynumber=(TelephonyManager) getSystemService(Context.TELEPHONY_SERVICE);
//        String h=""+mynumber.getLine1Number();
//        Toast.makeText(Home.this,h , Toast.LENGTH_SHORT).show();

        search=(Button)findViewById(R.id.homesearch);
        signup=(Button)findViewById(R.id.homesignup);
        signin=(Button)findViewById(R.id.homesignin);

        search.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Home.this,searching.class));
                finish();
            }
        });
        signin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Home.this,login.class));
                finish();
            }
        });
        signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Home.this,SignUp.class));
                finish();
            }
        });


    }
}
