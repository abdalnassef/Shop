package com.example.ema.myshop;

import android.Manifest;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.content.res.Resources;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class login extends AppCompatActivity {

    private SharedPreferences namepass;
    private Button signin;
    private EditText myname;
    private EditText mypass;
    private TextView signup;
    private TextView passforget;
    private Button Home;
    private String name,pass;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.loginx);

        signin = (Button) findViewById(R.id.signin);
        signup = (TextView) findViewById(R.id.signup);
        passforget = (TextView) findViewById(R.id.passforget);
        myname = (EditText) findViewById(R.id.name);
        mypass = (EditText) findViewById(R.id.password);
        Home=(Button)findViewById(R.id.loginhome);

        namepass = getSharedPreferences("Data", MODE_PRIVATE);

//        Resources res=getResources();
//        final String[] names=res.getStringArray(R.array.namearray);
//        final String[] passwords=res.getStringArray(R.array.passwordarray);
//        final int[] id=res.getIntArray(R.array.IDarray);

        final SQLiteDatabase profiles = openOrCreateDatabase("profilesdate", MODE_PRIVATE, null);
/*
      String x="CREATE TABLE Persons(ID int AUTO_INCREMENT PRIMARY KEY,Email varchar(30) NOT NULL,UserName varchar(20) unique,ShopName varchar(20) NOT NULL,Password varchar(20) NOT NULL,latitude  FLOAT( 10, 6 ) ,longitude FLOAT( 10, 6 ) );";

        profiles.execSQL("drop table persons");
        profiles.execSQL(x);


        profiles.execSQL("insert into Persons values(0,\'abdalnassef@gmail.com\',\'abdalnassef\',\'Softawy\',\'111\',0,0);");
        profiles.execSQL("insert into Persons values(1,\'ahmed@gmail.com\',\'ahmed\',\'Hamooda Soft\',\'000\',0,0);");
        profiles.execSQL("insert into Persons values(2,\'ali@gmail.com\',\'ali\',\'Lolo Shop\',\'111\',0,0);");
*/
        int shareID = namepass.getInt("ID", -1);
        if (shareID != -1) {
            Intent intent = new Intent(login.this, Seller.class);
            startActivity(intent);
            finish();
        }
        if(ID!=""){
            Toast.makeText(login.this, ("ID:"+ID), Toast.LENGTH_SHORT).show();
            try{
                int idd=Integer.parseInt(ID);
                SharedPreferences.Editor edit=namepass.edit();
                edit.putInt("ID", idd);
                edit.commit();
                Intent intent=new Intent(login.this,Seller.class);
                startActivity(intent);
                finish();
            }catch (Exception e){   Toast.makeText(login.this, "Not ID", Toast.LENGTH_SHORT).show();}
        }



        signin.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                name=myname.getText().toString().trim().toLowerCase();
                pass=mypass.getText().toString().trim().toLowerCase();

                if(myname.getText().toString().equals("")||mypass.getText().toString().equals("")){
                    Toast.makeText(login.this, "Fill Fields ,Sir.", Toast.LENGTH_SHORT).show();
                }else{
                    String method="login";
                    BackgroundTask bt=new BackgroundTask(login.this);
                    bt.execute(method, name, pass);
//                    if(name.equals("abdalnassef")){
//                        SharedPreferences.Editor edit=namepass.edit();
//                        edit.putInt("ID", 1);
//                        edit.commit();
//                        Intent intent=new Intent(login.this,Seller.class);
//                        startActivity(intent);
//                        finish();
//                    }
                     }
            }
        });
        signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(login.this,SignUp.class);
                startActivity(intent);
                finish();
            }
        });
        passforget.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(login.this,Forgot_pass.class);
                startActivity(intent);
                finish();
            }
        });
        Home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(login.this, Home.class);
                startActivity(i);
                finish();
            }
        });


    }
    private String ID="";
    public void setID(String result){
        ID=result;
    }

}
