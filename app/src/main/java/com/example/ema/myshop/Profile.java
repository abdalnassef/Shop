package com.example.ema.myshop;

import android.content.ContentValues;
import android.content.Intent;
import android.content.SharedPreferences;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.design.widget.NavigationView;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class Profile extends AppCompatActivity implements View.OnClickListener {

    private Button back;
    private Button recieved;
    private Button sented;
    private Button mydata;
    private Button saved;
    private TextView id;
    private TextView mname;
    private TextView mephone;
    private EditText name;
    private EditText phone;
    private EditText shopname;
    private EditText location;
    private LinearLayout data;
    private SharedPreferences namepass;
    private ListView msg;
    private String longitude;
    private String latitude;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

        id=(TextView)findViewById(R.id.MyID);
        name=(EditText)findViewById(R.id.MyName);
        phone =(EditText)findViewById(R.id.MyEmail);
        shopname=(EditText)findViewById(R.id.MyShop);
        location=(EditText)findViewById(R.id.MyLocation);
        id.setOnClickListener(this);
        name.setOnClickListener(this);
        phone.setOnClickListener(this);
        shopname.setOnClickListener(this);
        location.setOnClickListener(this);


        back=(Button)findViewById(R.id.Mback);
        recieved=(Button)findViewById(R.id.received);
        sented=(Button) findViewById(R.id.sented);
        data=(LinearLayout)findViewById(R.id.mydata);
        mydata=(Button)findViewById(R.id.mydatabtn);
        saved=(Button)findViewById(R.id.myedit);
        msg=(ListView)findViewById(R.id.messages);

        final SQLiteDatabase profiles = openOrCreateDatabase("profilesdate", MODE_PRIVATE, null);

        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Profile.this,Seller.class));
                finish();
            }
        });
        namepass =getSharedPreferences("Data",MODE_PRIVATE);
        final int ID= namepass.getInt("ID", -1);

        sented.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                data.setVisibility(View.INVISIBLE);
                msg.setVisibility(View.VISIBLE);
                Cursor c = profiles.rawQuery("select * from chat where idfrom="+ID, null);
                int index=0;
                List<String> msglist = new ArrayList<String>();
                while(c.moveToNext()){
                    String name="";String shop = "";
                    int idto=c.getInt(c.getColumnIndex("idto"));
                    Cursor cx = profiles.rawQuery("select * from persons where ID=" + idto, null);
                    while (cx.moveToNext()) {
                        name=cx.getString(cx.getColumnIndexOrThrow("UserName"));
                        shop=cx.getString(cx.getColumnIndexOrThrow("ShopName"));
                    }
                    msglist.add(name+" > "+c.getString(c.getColumnIndex("msg")));
                }
                ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(Profile.this,android.R.layout.simple_list_item_1,msglist);
                msg.setAdapter(arrayAdapter);
            }
        });
        recieved.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                data.setVisibility(View.INVISIBLE);
                msg.setVisibility(View.VISIBLE);
                Cursor c = profiles.rawQuery("select * from chat where idto="+ID, null);
                int index=0;
                List<String> msglist = new ArrayList<String>();
                while(c.moveToNext()){
                    String name="";String shop = "";
                    int idfrom=c.getInt(c.getColumnIndex("idfrom"));
                    Cursor cx = profiles.rawQuery("select * from persons where ID=" + idfrom, null);
                    while (cx.moveToNext()) {
                        name=cx.getString(cx.getColumnIndexOrThrow("UserName"));
                        shop=cx.getString(cx.getColumnIndexOrThrow("ShopName"));
                    }
                    msglist.add(name+" > "+c.getString(c.getColumnIndex("msg")));
                }
                ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(Profile.this,android.R.layout.simple_list_item_1,msglist);
                msg.setAdapter(arrayAdapter);
          }
        });
        mydata.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                data.setVisibility(View.VISIBLE);
                msg.setVisibility(View.INVISIBLE);
            }
        });



        if(ID==-1) Toast.makeText(getApplicationContext(),"Some Thing Wrong",Toast.LENGTH_SHORT).show();

        final Cursor c = profiles.rawQuery("select * from persons", null);

        while (c.moveToNext()) {
            int idd = c.getInt(c.getColumnIndex("ID"));
            if (ID == idd) {
                id.setText(c.getString(c.getColumnIndexOrThrow("ID")));
                name.setText(c.getString(c.getColumnIndexOrThrow("UserName")));
                phone.setText(c.getString(c.getColumnIndexOrThrow("Phone")));
                shopname.setText(c.getString(c.getColumnIndexOrThrow("ShopName")));
                latitude=c.getString(c.getColumnIndex("latitude"));
                longitude=c.getString(c.getColumnIndex("longitude"));
                String locations=c.getString(c.getColumnIndex("latitude"))+" : "+c.getString(c.getColumnIndex("longitude"));
                location.setText(locations);
            }
        }


    }

    @Override
    public void onClick(View v) {
        final SQLiteDatabase profiles = openOrCreateDatabase("profilesdate", MODE_PRIVATE, null);
        String ID=id.getText().toString();
        ContentValues args=new ContentValues();
//        if(v==name)
//        else if(v==shopname)
//        else if(v==phone)
//        else if(v==location)
        if(v==saved) {
            args.put("ShopName",shopname.getText().toString());
            args.put("UserName",name.getText().toString());
            args.put("Phone",phone.getText().toString());
            args.put("latitude", latitude);
            args.put("longitude", longitude);
            profiles.update("Persons", args, "ID" + "=" + ID, null);
        }
    }
    public void savedd(View v) {
       final SQLiteDatabase profiles = openOrCreateDatabase("profilesdate", MODE_PRIVATE, null);
        String ID=id.getText().toString();
        ContentValues args=new ContentValues();
            args.put("ShopName",shopname.getText().toString());
            args.put("UserName",name.getText().toString());
            args.put("Phone",phone.getText().toString());
            args.put("latitude", latitude);
            args.put("longitude", longitude);
            profiles.update("Persons", args, "ID" + "=" + ID, null);

    }
}
