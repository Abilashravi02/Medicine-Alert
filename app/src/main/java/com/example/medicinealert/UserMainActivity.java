package com.example.a91962.medicinealert;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;

public class UserMainActivity extends AppCompatActivity {
    ImageView i1,i2,i3;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_usermain);

        i1=(ImageView)findViewById(R.id.i2);


        i3=(ImageView)findViewById(R.id.i3);


        i1.setOnClickListener(new View.OnClickListener()
        {

            @Override
            public void onClick(View v) {


                Intent i=new Intent(UserMainActivity .this,Setuserdetails.class);
                startActivity(i);
            }

        });



        i3.setOnClickListener(new View.OnClickListener()
        {

            @Override
            public void onClick(View v) {


                // mechanic

                Intent i=new Intent(UserMainActivity .this,Userpagelogin.class);
                startActivity(i);
            }

        });



    }
}
