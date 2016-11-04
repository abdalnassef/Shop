package com.example.ema.myshop;

import android.Manifest;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

public class searching extends AppCompatActivity {
    private LinearLayout unloginlay;
    private AutoCompleteTextView Type;
    private SharedPreferences namepass;
    private Button home;
    private Button search;

    String[] itemowner ={
            "shopahmed",
            "shopali",
            "shopibrahim",
            "shopsara",
            "abdalnassef"
    };
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_searching);


        Type=(AutoCompleteTextView)findViewById(R.id.auto);
        home=(Button)findViewById(R.id.searchhome);
        home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(searching.this,Home.class));
                finish();
            }
        });
        search=(Button)findViewById(R.id.searchbutton);
        search.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent cc=new Intent(searching.this, otherprofiles.class);
                cc.putExtra("Namee",Type.getText().toString());
                cc.putExtra("serach",true);

                startActivity(cc);
                finish();
            }
        });
        Type.setAdapter(new ArrayAdapter<String>(this, android.R.layout.simple_dropdown_item_1line,itemowner));

        namepass =getSharedPreferences("Data",MODE_PRIVATE);
        int ID= namepass.getInt("ID", -1);

        unloginlay=(LinearLayout)findViewById(R.id.unloginlay);
        if(ID==-1)unloginlay.setVisibility(View.VISIBLE);
        else unloginlay.setVisibility(View.INVISIBLE);
    }

}
