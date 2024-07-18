package com.example.a91962.medicinealert;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

public class MainActivityalarm extends AppCompatActivity {
    Button b1,b2,b3,b4;

    String user,result;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_alarm);
        b1=(Button)findViewById(R.id.b1);
        b2=(Button)findViewById(R.id.b3);

        b3=(Button)findViewById(R.id.button7);


        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                // water alarm

             //   Intent i=new Intent(MainActivityalarm.this,AlarmMe.class);
                //i.putExtra("user",user);
                //startActivity(i);

            }
        });

        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


               //sleep alarm

                //Intent i=new Intent(MainActivityalarm.this,AlarmMe.class);
                //i.putExtra("user",user);
                //startActivity(i);


            }
        });

        b3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                //sleep alarm

                Intent i=new Intent(MainActivityalarm.this,MainActivity.class);

                startActivity(i);


            }
        });









    }
}
