package com.example.a91962.medicinealert;

import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class homeremadies extends AppCompatActivity {
    Cursor c;
    Spinner s1;
    Button b,b2;
    ArrayAdapter ml;
    String t1;
    String mail;
    Spinner spin,  spin3;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_disease);
        s1=(Spinner)findViewById(R.id.s1);
        b=(Button)findViewById(R.id.b);
        b2=(Button)findViewById(R.id.button3);

        List<String> categories = new ArrayList<String>();
        categories.add("Cold");
        categories.add("Headache");
        categories.add("Stomachpain");
        categories.add("Backpain");
        categories.add("kneepain");
        categories.add("Anxiety");




        ArrayAdapter<String> dataAdapter1 = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, categories);

        // Drop down layout style - list view with radio button
        dataAdapter1.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        // attaching data adapter to spinner
        s1.setAdapter(dataAdapter1);
        try {


            s1.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                @Override
                public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                    t1 = (String) s1.getSelectedItem();
                    Toast.makeText(getApplicationContext(), "Itemselected is" + t1, Toast.LENGTH_SHORT).show();
                    //showslots();


                }

                @Override
                public void onNothingSelected(AdapterView<?> parent) {

                }
            });
        } catch (Exception e) {
            Toast.makeText(getApplicationContext(), "Exception" + e, Toast.LENGTH_SHORT).show();
        }


        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {



                      if(t1.equalsIgnoreCase("Cold"))
                      {
                          Intent i=new Intent(homeremadies.this,remmodies.class);
                          startActivity(i);

                      }


                     if(t1.equalsIgnoreCase("Headache"))
                    {
                        Intent i=new Intent(homeremadies.this,remmodies2.class);
                        startActivity(i);

                    }


                if(t1.equalsIgnoreCase("Stomachpain"))
                {
                    Intent i=new Intent(homeremadies.this,remmodies3.class);
                    startActivity(i);

                }
                if(t1.equalsIgnoreCase("Backpain"))
                {
                    Intent i=new Intent(homeremadies.this,remmodies4.class);
                    startActivity(i);

                }
                if(t1.equalsIgnoreCase("kneepain"))
                {

                    Intent i=new Intent(homeremadies.this,remmodies5.class);
                    startActivity(i);
                }
                if(t1.equalsIgnoreCase("diabeties"))
                {
                    Intent i=new Intent(homeremadies.this,remmodies6.class);
                    startActivity(i);

                }


            }
        });



        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {




                Intent i=new Intent(homeremadies.this,MainActivity.class);
                startActivity(i);



            }
        });


















    }

}
