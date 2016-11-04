package com.example.ema.myshop;

import android.content.Intent;
import android.content.SharedPreferences;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class SignUp extends AppCompatActivity {

    private EditText Phone;
    private EditText Name;
    private EditText Pass;
    private EditText PassCF;
    private EditText Shopname;
    private Button SignUp;
    private Button Home;
    private TextView SignIn;
    private GPSTracker gps;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);

        Phone =(EditText)findViewById(R.id.signup_phone);
        Name=(EditText)findViewById(R.id.signup_name);
        Pass=(EditText)findViewById(R.id.signup_pass);
        PassCF=(EditText)findViewById(R.id.signup_passcf);
        Shopname=(EditText)findViewById(R.id.signup_shopname);
        SignUp=(Button)findViewById(R.id.signup_signup);
        Home=(Button)findViewById(R.id.signup_home);
        SignIn=(TextView)findViewById(R.id.signup_signin);

        SignIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(SignUp.this,login.class);
                startActivity(i);
                finish();
            }
        });
//        SignUp.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//
//            }
//        });
        Home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(SignUp.this, Home.class);
                startActivity(i);
                finish();
            }
        });
    }
    public void signup_shop(View view){
        //For Location
        gps = new GPSTracker(SignUp.this);
        // check if GPS enabled
        double latitude=0;
        double longitude=0;
        if(gps.canGetLocation()){
            latitude = gps.getLatitude();
            longitude = gps.getLongitude();
            Toast.makeText(getApplicationContext(), "Your Location is - \nLat: " + latitude + "\nLong: " + longitude, Toast.LENGTH_LONG).show();
        }else{
            gps.showSettingsAlert();
        }
        String phone= Phone.getText().toString();
        String username=Name.getText().toString().trim().toLowerCase();
        String password=Pass.getText().toString();
        String passwordcf=PassCF.getText().toString();
        Shopname.setVisibility(View.VISIBLE);
        String shopName=Shopname.getText().toString().trim().toLowerCase();
        String lati=""+latitude;
        String longi=""+longitude;
        if(!password.equals(passwordcf)){
            Toast.makeText(getApplicationContext(),"Two passwords not matched check them ,Sir",Toast.LENGTH_SHORT).show();
        }else if(phone.equals("")||username.equals("")||password.equals("")||shopName.equals("")) {
            Toast.makeText(getApplicationContext(), "Fill all Fields , Sir", Toast.LENGTH_SHORT).show();
        }else {
            String method = "shop_register";
            //********************************************** this *****************************************
            BackgroundTask bt = new BackgroundTask(this);
            bt.execute(method, username, password, shopName, phone, lati, longi);

            Toast.makeText(SignUp.this, "Done", Toast.LENGTH_SHORT).show();
        }
    }
    public void signup_user(View view){
        //For Location
        gps = new GPSTracker(SignUp.this);
        // check if GPS enabled
        double latitude=0;
        double longitude=0;
        if(gps.canGetLocation()){
            latitude = gps.getLatitude();
            longitude = gps.getLongitude();
            Toast.makeText(getApplicationContext(), "Your Location is - \nLat: " + latitude + "\nLong: " + longitude, Toast.LENGTH_LONG).show();
        }else{
            gps.showSettingsAlert();
        }
        String phone= Phone.getText().toString();
        String username=Name.getText().toString().trim().toLowerCase();
        String password=Pass.getText().toString();
        String passwordcf=PassCF.getText().toString();
        Shopname.setVisibility(View.INVISIBLE);
        String lati=""+latitude;
        String longi=""+longitude;
        if(!password.equals(passwordcf)){
            Toast.makeText(getApplicationContext(),"Two passwords not matched check them ,Sir",Toast.LENGTH_SHORT).show();
        }else if(phone.equals("")||username.equals("")||password.equals("")) {
            Toast.makeText(getApplicationContext(), "Fill all Fields , Sir", Toast.LENGTH_SHORT).show();
        }else {
            String method = "user_register";
            //********************************************** this *****************************************
            BackgroundTask bt = new BackgroundTask(this);
            bt.execute(method, username, password, phone, lati, longi);

            Toast.makeText(SignUp.this, "Done", Toast.LENGTH_SHORT).show();
        }
    }

}
