package com.example.ema.myshop;

import android.Manifest;
import android.app.Dialog;
import android.content.Context;
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
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class product extends AppCompatActivity {
    String[] itemsalary = {
            "ahmed",
            "ahmed ali",
            "abdalnassef",
            "mahamed",
            "ibrahem",
            "bassem",
            "yara",
            "mohamed ahmed"
    };
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

    String[] itemsalary2 ={
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


    private LinearLayout hisphone;
    private LinearLayout hiscomment;
    private LinearLayout hismessage;
    private LinearLayout hisshare;
    private LinearLayout hisprofile;
    private LinearLayout hiscall;
    private LinearLayout hissearch;
    private LinearLayout unloginlay;
    private ImageView productPic ;
    private TextView name;
    private TextView desc;
    private TextView salary;
    private TextView owner;
    private TextView Timing;
    private TextView Phone;
    private TextView Comment;

    String[] itemdesc ={
            "جبنة بيضاء جميلة اهى",
            "جبنة رومى وعندنا نص كيلو بس ",
            "الكرتونة كما اعلاه السعر الكيس ب2 جنيه",
            "اللبن حلو وكويس للصحه",
            "الفول بيدى طاقة فل الفل ",
            "لذيذة هذه الشوكولاته ",
            "اللحمه غاليه اليومين دول بلاش منها",
            "لنظافة افضل"
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
    String[] itemComment ={
            "cheese comments",
            "Roomi cheese comments",
            "Molto comments",
            "Milk comments",
            "Beans comments",
            "Chocolate comments",
            "Meat comments",
            "Arial comments"
    };


    String[] itemTiming ={
            "02-06-2015 To 02-09-2016",
            "11-12-2015 To 02-09-2017",
            "12-02-2015 To 02-09-2018",
            "13-11-2015 To 02-09-2016",
            "18-07-2015 To 02-09-2017",
            "28-06-2015 To 02-09-2018",
            "24-09-2015 To 02-09-2016",
            "07-06-2015 To 02-09-2018"

    };
    private RelativeLayout unsign;
    private SharedPreferences namepass;
    final Context context = this;
    private int ID;
   private Button dialogButton;
    private Dialog dialog;
    private AutoCompleteTextView auto;
    private EditText text;
private int xcc;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_product);
        namepass = getSharedPreferences("Data", MODE_PRIVATE);
        ID = namepass.getInt("ID", -1);

        productPic = (ImageView)findViewById(R.id.showproductpic);
        name=(TextView)findViewById(R.id.showproductname);
        desc=(TextView)findViewById(R.id.showproductdesc);
        salary=(TextView)findViewById(R.id.showproductsalary);
        owner=(TextView)findViewById(R.id.showproductowner);
        Timing=(TextView)findViewById(R.id.showproductTime);
        Phone=(TextView)findViewById(R.id.showproductphone);
        Comment=(TextView)findViewById(R.id.showproductcomments);

        Intent xhh=getIntent();
        xcc=xhh.getIntExtra("ID",-1);
        if(xcc!=-1){
            productPic.setImageResource(imgid[xcc]);
            name.setText(itemname[xcc]);
            desc.setText(itemdesc[xcc]);
            salary.setText(itemsalary2[xcc]);
            owner.setText(itemowner[xcc]);
            Timing.setText(itemTiming[xcc]);
            Phone.setText(itemphone[xcc]);
            Comment.setText(itemComment[xcc]);

        }

        unloginlay = (LinearLayout) findViewById(R.id.unloginlay);
        if (ID == -1) {
            unloginlay.setVisibility(View.VISIBLE);
        } else unloginlay.setVisibility(View.INVISIBLE);


        dialog = new Dialog(context);
        dialog.setContentView(R.layout.customdialog);
        dialog.setTitle("            your Message");
// set the custom dialog components ‐ text, image and button
        text = (EditText) dialog.findViewById(R.id.written);
        auto = (AutoCompleteTextView) dialog.findViewById(R.id.share);
        dialogButton = (Button) dialog.findViewById(R.id.sends);
// if button is clicked, close the custom dialog


        hisprofile = (LinearLayout) findViewById(R.id.hisprofile);
        hisphone = (LinearLayout) findViewById(R.id.hisprofile);
        hiscomment = (LinearLayout) findViewById(R.id.hiscomment);
        hisshare = (LinearLayout) findViewById(R.id.hisshare);
        hismessage = (LinearLayout) findViewById(R.id.hismessage);
        hiscall = (LinearLayout) findViewById(R.id.hiscall);
        hissearch = (LinearLayout) findViewById(R.id.unsearch);
//        unsign = (RelativeLayout) findViewById(R.id.unsignn);





        hissearch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
            }
        });
        hiscall.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


    }
});


        hisprofile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
             }
        });
        hiscomment.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
        hismessage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
        hisshare.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }


        });



    }
    public void searchact(View view){
        Intent cc=new Intent(product.this, searching.class);
        startActivity(cc);

    }

    public void callact(View view){
        Intent callIntent = null;
        try {
            callIntent = new Intent(Intent.ACTION_CALL);
            callIntent.setData(Uri.parse("tel:"+itemphone[xcc]));
            if (ActivityCompat.checkSelfPermission(product.this, Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED) {
                return;
            }
            startActivity(callIntent);
        } catch (Exception e) {
            Toast.makeText(product.this, e.getMessage(), Toast.LENGTH_SHORT).show();
        }
    }
    public void messageact(View view){
        if (ID == -1) {
            auto.setVisibility(View.INVISIBLE);
            text.setVisibility(View.INVISIBLE);
            try {
                unsign.setVisibility(View.VISIBLE);
            }catch (Exception e){
                Toast.makeText(product.this, "Register or login first", Toast.LENGTH_SHORT).show();
            }              dialogButton.setText("Ok");
        }else {
//                    unsign.setVisibility(View.INVISIBLE);
            auto.setVisibility(View.INVISIBLE);
            text.setVisibility(View.VISIBLE);
            dialogButton.setText("Send");
            dialog.setTitle("            your Message");
            dialogButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Toast.makeText(product.this, "Sented" + text.getText().toString(), Toast.LENGTH_SHORT).show();
                    dialog.dismiss();
                }
            });
            dialog.show();
        }
    }
    public void commentact(View view){
        if (ID == -1) {
            auto.setVisibility(View.INVISIBLE);
            text.setVisibility(View.INVISIBLE);
            try {
                unsign.setVisibility(View.VISIBLE);
            }catch (Exception e){
                Toast.makeText(product.this, "Register or login first", Toast.LENGTH_SHORT).show();
            }
            dialogButton.setText("Ok");
        }else{
            //        unsign.setVisibility(View.INVISIBLE);
            auto.setVisibility(View.INVISIBLE);
            text.setVisibility(View.VISIBLE);
//                auto.setAdapter(new ArrayAdapter<String>(product.this, android.R.layout.simple_expandable_list_item_1, itemsalary));

            dialogButton.setText("Comment");
            dialog.setTitle("            your Comment");
            dialogButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Toast.makeText(product.this, "Commented"+text.getText().toString(), Toast.LENGTH_SHORT).show();
                    dialog.dismiss();
                }
            });
            dialog.show();
        }
    }
    public void shareact(View view){
        if (ID == -1) {
            auto.setVisibility(View.INVISIBLE);
            text.setVisibility(View.INVISIBLE);
            try {
                unsign.setVisibility(View.VISIBLE);
            }catch (Exception e){
                Toast.makeText(product.this, "Register or login first", Toast.LENGTH_SHORT).show();
            }
            dialogButton.setText("Ok");
        }else{
            //  unsign.setVisibility(View.INVISIBLE);
            auto.setVisibility(View.VISIBLE);
            text.setVisibility(View.INVISIBLE);

            auto.setAdapter(new ArrayAdapter<String>(product.this, android.R.layout.simple_expandable_list_item_1, itemsalary));

            dialogButton.setText("Share");
            dialog.setTitle("            your Share");
            dialogButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Toast.makeText(product.this, "Shared to "+auto  .getText().toString(), Toast.LENGTH_SHORT).show();
                    dialog.dismiss();
                }
            });
            dialog.show();
        }
    }
    public void profileact(View view){
        Intent cc=new Intent(product.this, otherprofiles.class);
        cc.putExtra("Namee",owner.getText().toString());
        startActivity(cc);

    }

    public void loginact(View view){
        startActivity(new Intent(product.this,login.class));
    }
    public void unloginact(View view){
        startActivity(new Intent(product.this,SignUp.class));
    }
}
