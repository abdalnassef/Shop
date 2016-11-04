package com.example.ema.myshop;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

public class unlogin extends AppCompatActivity {
    private LinearLayout untoin;
    private LinearLayout untoreg;
    String[] itemname ={
            "Safari",
            "Camera",
            "Global",
            "FireFox",
            "UC Browser",
            "Android Folder",
            "VLC Player",
            "Cold War"
    };
    String[] itemsalary ={
            "50 $",
            "10 $",
            "70 $",
            "50 $",
            "40 $",
            "90 $",
            "20 $",
            "120 $"
    };

    Integer[] imgid={
            R.drawable.pic1,
            R.drawable.pic2,
            R.drawable.pic3,
            R.drawable.pic4,
            R.drawable.pic5,
            R.drawable.pic6,
            R.drawable.pic7,
            R.drawable.pic8,
    };

    private TextView mname;
    private TextView memail;
    private SharedPreferences namepass;
    private LinearLayout search;
    private ListView list;
    final Context context = this;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_unlogin);


        untoin = (LinearLayout) findViewById(R.id.regtoin);
        untoreg = (LinearLayout) findViewById(R.id.regtoreg);
        untoin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(unlogin.this, login.class));
            }
        });
        untoreg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(unlogin.this, SignUp.class));
            }
        });


        namepass = getSharedPreferences("Data", MODE_PRIVATE);
        int ID = namepass.getInt("ID", -1);

        list = (ListView) findViewById(R.id.regproducts);
        search = (LinearLayout) findViewById(R.id.regsearch);
        search.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(unlogin.this, searching.class));
            }
        });


        CustomListAdapter adapter = new CustomListAdapter(this, itemname, itemsalary, imgid);
        list.setAdapter(adapter);

        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> parent, View view,
                                    int position, long id) {
                // TODO Auto-generated method stub
                String Slecteditem = itemname[+position];
                Toast.makeText(getApplicationContext(), Slecteditem, Toast.LENGTH_SHORT).show();
                startActivity(new Intent(unlogin.this, product.class));
            }
        });


    }
    }
