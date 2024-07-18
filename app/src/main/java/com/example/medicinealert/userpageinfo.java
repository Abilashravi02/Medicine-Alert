package com.example.a91962.medicinealert;

import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.telephony.SmsManager;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;

public class userpageinfo extends AppCompatActivity {

    Button b1,b2,b3,b4,b5;

    String staffid,dept;
    Random rand = new Random();
    SmsManager sms;
    String phone="",user;
    String phoneuser;
    Cursor c;
    String currentTime, currentTime1;
    String date,date1;
    String contact_emg;
    int count=1;
    List<String> phone_info = new ArrayList<String>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);



        setContentView(R.layout.activity_elderpage);

        b1=(Button)findViewById(R.id.b1);

        b3=(Button)findViewById(R.id.button2);

        b4=(Button)findViewById(R.id.button8);


        b5=(Button)findViewById(R.id.button);

        currentTime = new SimpleDateFormat("HH:mm:ss", Locale.getDefault()).format(new Date());

        date = new SimpleDateFormat("yyyy-MM-dd", Locale.getDefault()).format(new Date());
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {



                //intake alert


                SQLiteDatabase db = openOrCreateDatabase("Phone", Context.MODE_PRIVATE, null);
                try {
                    if (db != null) {
                        c = db.rawQuery("SELECT * from email", null);
                        if (c.moveToFirst()) {
                            do {

                                phoneuser=c.getString(c.getColumnIndexOrThrow("address"));

                                sms= SmsManager.getDefault();

                                try{
                                    //Toast.makeText(getApplicationContext(),"check phone "+phone,Toast.LENGTH_SHORT).show();


                                    sms.sendTextMessage(phoneuser, null,"Hi Family Member This is Medicine Intake alert Time Details:"+currentTime+" Date Info :"+date, null, null);
                                    Toast.makeText(getApplicationContext()," Message Sent Successfully.",Toast.LENGTH_SHORT).show();


                                }
                                catch (Exception e)
                                {
                                    Toast.makeText(getApplicationContext(),"Excepion in sending sms"+e,Toast.LENGTH_SHORT).show();
                                }







                            } while (c.moveToNext());
                        }
                    }
                } catch (Exception e) {
                    Toast.makeText(getApplicationContext(), "Exception" + e, Toast.LENGTH_SHORT).show();
                }
                db.close();







            }
        });



        b4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {



                //emergency alert

                SQLiteDatabase db = openOrCreateDatabase("Phone", Context.MODE_PRIVATE, null);
                try {
                    if (db != null) {
                        c = db.rawQuery("SELECT * from email", null);
                        if (c.moveToFirst()) {
                            do {

                                phoneuser=c.getString(c.getColumnIndexOrThrow("address"));

                                sms= SmsManager.getDefault();

                                try{
                                    //Toast.makeText(getApplicationContext(),"check phone "+phone,Toast.LENGTH_SHORT).show();


                                    sms.sendTextMessage(phoneuser, null,"Hi Family Member This is Emergency Alert Message From  ELDER PEOPLE Time of alert:"+currentTime+" Alert Date Info :"+date, null, null);
                                    Toast.makeText(getApplicationContext()," Message Sent Successfully.",Toast.LENGTH_SHORT).show();


                                }
                                catch (Exception e)
                                {
                                    Toast.makeText(getApplicationContext(),"Excepion in sending sms"+e,Toast.LENGTH_SHORT).show();
                                }







                            } while (c.moveToNext());
                        }
                    }
                } catch (Exception e) {
                    Toast.makeText(getApplicationContext(), "Exception" + e, Toast.LENGTH_SHORT).show();
                }
                db.close();




            }
        });




        b5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                //home remadies
                Intent i=new Intent(userpageinfo.this,homeremadies.class);


                startActivity(i);



            }
        });


        b3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                // logout

                Intent i=new Intent(userpageinfo.this,MainActivity.class);
                startActivity(i);
            }
        });














    }
}
