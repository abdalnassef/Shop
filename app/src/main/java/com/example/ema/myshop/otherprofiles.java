package com.example.ema.myshop;

import android.Manifest;
import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class otherprofiles extends AppCompatActivity {
ListView listt;
    LinearLayout MSG;
    final Context context = this;

    String[] itemname ={
            "cheese",
            "Roomi cheese",
            "Molto",
            "Milk",
            "Beans",
            "Chocolate",
            "Meat",
            "Arial"
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

    String[] itemowner ={
            "shopahmed",
            "shopali",
            "shopahmed",
            "shopibrahim",
            "shopsara",
            "abdalnassef",
            "shopahmed",
            "shopahmed"
    };
    String[] itemphone ={
            "01011111112",
            "01199999987",
            "01011111112",
            "01200022213",
            "01022345678",
            "01099982714",
            "01011111112",
            "01011111112"
    };

    TextView myname,myphone,notfound;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_otherprofiles);
        listt=(ListView)findViewById(R.id.hisproducts);
//        MSG=(LinearLayout)findViewById(R.id.MSG);
//        final Dialog dialog = new Dialog(context);
//        final Button dialogButton = (Button) dialog.findViewById(R.id.sends);
//        final EditText textttt = (EditText) dialog.findViewById(R.id.written);

//        MSG.setOnClickListener(new View.OnClickListener() {
//    @Override
//    public void onClick(View v) {
//        dialog.setContentView(R.layout.customdialog);
//        dialog.setTitle("            your Message");
//        dialogButton.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View vv) {
//                Toast.makeText(otherprofiles.this, "Sented" + textttt.getText().toString(), Toast.LENGTH_SHORT).show();
//                dialog.dismiss();
//            }
//        });
//        dialog.show();
//    }
//});

        Intent oo=getIntent();
        String my_name=oo.getStringExtra("Namee");
        boolean see=oo.getBooleanExtra("serach",false);
        int xx=0;
        for(int u=0;u<itemowner.length;u++){
            if(itemowner[u].equals(my_name)){
                xx++;
            }
        }

        String[] imyitemsalary=new String[xx];
        String[] imyitemname=new String[xx];
        Integer[] imyimg=new Integer[xx];
        final int indexes[]=new int[xx];
        String phone="012012";
        int index=0;
        for(int u=0;u<itemowner.length;u++){
            if(itemowner[u].equals(my_name)){
                indexes[index]=u;
                imyimg[index]=imgid[u];
                imyitemname[index]=itemname[u];
                imyitemsalary[index++]=itemsalary[u];
                phone=itemphone[u];
            }
        }



                        myname=(TextView)findViewById(R.id.hisname);
                        myphone=(TextView)findViewById(R.id.hisphone);
                        notfound=(TextView)findViewById(R.id.notfound);
                        myname.setText(my_name);
                        myphone.setText(phone);
        notfound.setVisibility(View.INVISIBLE);

        if(xx<1&&see) {
            Toast.makeText(otherprofiles.this, "Not founded", Toast.LENGTH_SHORT).show();
            notfound.setVisibility(View.VISIBLE);
            myphone.setText("00000000000");
        }

        CustomListAdapter adapter=new CustomListAdapter(this, imyitemname,imyitemsalary, imyimg);
        listt.setAdapter(adapter);

        listt.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> parent, View view,
                                    int position, long id) {
                // TODO Auto-generated method stub
                int newposition=-1;
                      Intent i=new Intent(otherprofiles.this,product.class);
                      newposition=indexes[position];
                      i.putExtra("ID", newposition);
                String Slecteditem = itemname[newposition];
                Toast.makeText(getApplicationContext(), Slecteditem, Toast.LENGTH_SHORT).show();

                startActivity(i);      }
        });

    }
    public void calling(View view){
        Intent callIntent = null;
        try {
            callIntent = new Intent(Intent.ACTION_CALL);
            callIntent.setData(Uri.parse("tel:" + myphone.getText().toString()));
            if (ActivityCompat.checkSelfPermission(otherprofiles.this, Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED) {
                return;
            }
            startActivity(callIntent);
        } catch (Exception e) {
            Toast.makeText(otherprofiles.this, e.getMessage(), Toast.LENGTH_SHORT).show();
        }
    }
    public void messaging(View view){
         final Dialog dialog = new Dialog(context);
         final Button dialogButton = (Button) dialog.findViewById(R.id.sends);
         final EditText texttt = (EditText) dialog.findViewById(R.id.written);
        dialog.setContentView(R.layout.customdialog);
        dialog.setTitle("            your Message");
            dialogButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Toast.makeText(otherprofiles.this, "Sented" + texttt.getText().toString(), Toast.LENGTH_SHORT).show();
                    dialog.dismiss();
                }
            });
            dialog.show();
    }
    public void searchingmethod(View view){
        startActivity(new Intent(otherprofiles.this,searching.class));
    }
}
