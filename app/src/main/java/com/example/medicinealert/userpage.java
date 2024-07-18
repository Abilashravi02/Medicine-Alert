package com.example.a91962.medicinealert;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import java.util.Random;

public class userpage extends AppCompatActivity {

    Button b1,b2,b3,b4,b5;

    String staffid,dept;
    Random rand = new Random();

    String phone="",user;
    Cursor c;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_userpage);

        b1=(Button)findViewById(R.id.b1);

        b3=(Button)findViewById(R.id.button2);

        b4=(Button)findViewById(R.id.button8);


        b5=(Button)findViewById(R.id.button);



        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {



                //bmi calcialuation


                Intent i=new Intent(userpage.this,AlarmMe.class);

               // i.putExtra("user", user);
               startActivity(i);







            }
        });



        b4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {



                Intent i=new Intent(userpage.this,UserMainActivity1.class);


                startActivity(i);



            }
        });




        b5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {



                Intent i=new Intent(userpage.this,Delmailaddress.class);


                startActivity(i);



            }
        });


        b3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                // logout

                Intent i=new Intent(userpage.this,MainActivity.class);
                startActivity(i);
            }
        });














    }
}
