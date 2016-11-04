package com.example.ema.myshop;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.widget.AdapterView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

public class Seller extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {
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



    private TextView mname;
    private TextView mephone;
    private SharedPreferences namepass;
    private LinearLayout search;
    private ListView list;
    final Context context = this;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        namepass =getSharedPreferences("Data",MODE_PRIVATE);
        int ID= namepass.getInt("ID", -1);

        super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_seller);
        if(ID==-1) {
            startActivity(new Intent(Seller.this, unlogin.class));
            finish();
        }

        list=(ListView)findViewById(R.id.products);
        search=(LinearLayout)findViewById(R.id.unsearch);
        search.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                  startActivity(new Intent(Seller.this,searching.class));
            }
        });



        CustomListAdapter adapter=new CustomListAdapter(this, itemname,itemsalary, imgid);
        list.setAdapter(adapter);

        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> parent, View view,
                                    int position, long id) {
                // TODO Auto-generated method stub
                String Slecteditem = itemname[+position];
                Toast.makeText(getApplicationContext(), Slecteditem, Toast.LENGTH_SHORT).show();
                Intent i=new Intent(Seller.this,product.class);
                i.putExtra("ID",position);
                        startActivity(i);
            }
        });




        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
//        setSupportActionBar(toolbar);

        SQLiteDatabase profiles = openOrCreateDatabase("profilesdate", MODE_PRIVATE, null);
//profiles.execSQL("drop table chat");
try {
    profiles.execSQL("insert into chat values(1,4,\'first msg from 1\');");
    profiles.execSQL("insert into chat values(2,4,\'first msg from 2\');");
    profiles.execSQL("insert into chat values(3,4,\'first msg from 3\');");
    profiles.execSQL("insert into chat values(1,4,\'second msg from 1\')");
    profiles.execSQL("insert into chat values(4,1,\'first from me msg to 1\')");
    profiles.execSQL("insert into chat values(4,2,\'second from me msg to 2\')");
}catch (Exception e){
    profiles.execSQL("create table chat (idfrom int not null,idto int not null,msg varchar(255));");
    Toast.makeText(Seller.this, "Done Created", Toast.LENGTH_SHORT).show();
}


        NavigationView avigationView = (NavigationView) findViewById(R.id.nav_view);
        View hView =  avigationView.inflateHeaderView(R.layout.nav_header_seller);

        mname=(TextView)hView.findViewById(R.id.mname);
        mephone =(TextView)hView.findViewById(R.id.mephone);

        if(ID==-1)     {
            Toast.makeText(getApplication(),"Some thing Wrong ,Sir",Toast.LENGTH_SHORT).show();
        }

//            SQLiteDatabase profiles = openOrCreateDatabase("profilesdate", MODE_PRIVATE, null);

            final Cursor c = profiles.rawQuery("select * from persons", null);

            while (c.moveToNext()) {
//                int passindex = c.getColumnIndexOrThrow("Password");
                int nameindex = c.getColumnIndexOrThrow("UserName");
                int idindex = c.getColumnIndexOrThrow("ID");
                int phoneindex = 1;
                try {
                     phoneindex = c.getColumnIndexOrThrow("Phone");
                }catch (Exception e){
                    profiles.execSQL("drop table Persons;");
                    String x="CREATE TABLE Persons(ID int AUTO_INCREMENT PRIMARY KEY,Phone varchar(30) NOT NULL,UserName varchar(20) unique,ShopName varchar(20) NOT NULL,Password varchar(20) NOT NULL,latitude  FLOAT( 10, 6 ) ,longitude FLOAT( 10, 6 ) );";
                    profiles.execSQL(x);
                    profiles.execSQL("insert into Persons values(3,\'01099982714\',\'abdalnassef\',\'Softawy\',\'111\',30.58999999,31.0001);");
                    profiles.execSQL("insert into Persons values(1,\'01234566668\',\'ahmed\',\'Hamooda Soft\',\'000\',0,0);");
                    profiles.execSQL("insert into Persons values(2,\'01123456967\',\'ali\',\'Lolo Shop\',\'111\',0,0);");

                }
                String namee = c.getString(nameindex);
                String phonee = c.getString(phoneindex);
//                String lon=c.getString(c.getColumnIndex("latitude"));
                int idd = c.getInt(idindex);
                if (ID == idd) {
//                    Toast.makeText(getApplication(),mname.getText(),Toast.LENGTH_SHORT).show();

                    mname.setText(""+namee);
                    mephone.setText("" + phonee);
//                    mephone.setText(""+lon);

                }

            }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }



    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_camera) {
            // Handle the camera action
        } else if (id == R.id.nav_gallery) {
            TextView m=(TextView)findViewById(R.id.mname);
            Intent cc=new Intent(Seller.this, otherprofiles.class);
            cc.putExtra("Namee",m.getText().toString());
            startActivity(cc);
        } else if (id == R.id.nav_manage) {

        } else if (id == R.id.nav_share) {

        }else if (id == R.id.nav_profile) {
            startActivity(new Intent(Seller.this,Profile.class));
        }else if (id == R.id.nav_logout) {
            SharedPreferences.Editor editor=namepass.edit();
            editor.clear();
            editor.commit();
            startActivity(new Intent(Seller.this,login.class));
            finish();
        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}
