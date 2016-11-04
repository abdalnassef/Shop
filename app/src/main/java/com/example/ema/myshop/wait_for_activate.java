package com.example.ema.myshop;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class wait_for_activate extends AppCompatActivity {

    private TextView Activate;
    private TextView password;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_wait_for_activate);

        Intent x=getIntent();
        final String email=x.getStringExtra("RepassEmail");

        Activate=(TextView)findViewById(R.id.assume);
        password=(TextView)findViewById(R.id.yourpass);
        Activate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SQLiteDatabase db=openOrCreateDatabase("profilesdate",MODE_PRIVATE,null);
                final Cursor c=db.rawQuery("select * from Persons", null);

                while (c.moveToNext()) {
                    int passindex = c.getColumnIndexOrThrow("Password");
                    int emailindex = c.getColumnIndexOrThrow("Phone");

                    String passs = c.getString(passindex);
                    String emaill = c.getString(emailindex);
                    if(emaill.equals(email)){
                        password.setText(passs);
                    }
                }
            }
        });
    }
}
