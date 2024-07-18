package com.example.a91962.medicinealert;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;

public class MainActivity1 extends AppCompatActivity {
    ImageView i1,i2,i3,i4;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_firstmain);




        i1=(ImageView)findViewById(R.id.imageView2);

        i2=(ImageView)findViewById(R.id.imageView);



        try{
            Thread.sleep(5000);
            //^freezes whole program for amount of time
           // System.out.println("Hola");//Appears after 5 seconds
        }
        catch(InterruptedException e){
            System.err.println(e.getMessage());
        }








        i1.setOnClickListener(new View.OnClickListener()
        {

            @Override
            public void onClick(View v) {


                // mechanic

                Intent i=new Intent(MainActivity1.this,UserMainActivity.class);
                startActivity(i);

            }

        });


        i2.setOnClickListener(new View.OnClickListener()
        {

            @Override
            public void onClick(View v) {


                // mechanic

                Intent i=new Intent(MainActivity1.this,userpageinfo.class);
                startActivity(i);

            }

        });



    }




}
