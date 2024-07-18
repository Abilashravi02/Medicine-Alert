package com.example.a91962.medicinealert;

import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

public class UserMainActivity1 extends AppCompatActivity {

    EditText e1;
    String addr;
    String empty="";
    Cursor c;
    Button b,b1,b2;
    int count=0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maincontact);

        e1=(EditText)findViewById(R.id.e1);
        b=(Button)findViewById(R.id.b);
        b1=(Button)findViewById(R.id.b1);



        final SQLiteDatabase Db=openOrCreateDatabase("Phone", Context.MODE_PRIVATE,null);
        String q1="CREATE TABLE email(address TEXT PRIMARY KEY);";
        try{
            Db.execSQL(q1);
        }
        catch (Exception e)
        {
            Toast.makeText(getApplicationContext(),"Exception"+e,Toast.LENGTH_SHORT).show();
        }
        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                addr=e1.getText().toString();



                SQLiteDatabase db = openOrCreateDatabase("Phone", Context.MODE_PRIVATE, null);
                try {
                    if (db != null) {
                        c = db.rawQuery("SELECT * from email", null);
                        if (c.moveToFirst()) {
                            do {
                                count = count + 1;

                            } while (c.moveToNext());
                        }
                    }
                } catch (Exception e) {
                    Toast.makeText(getApplicationContext(), "Exception" + e, Toast.LENGTH_SHORT).show();
                }
                db.close();

                if (count >= 5) {
                    Toast.makeText(getApplicationContext(),"Sorry already  5 Number Exit  exist.",Toast.LENGTH_SHORT).show();

                } else {

                    String insert = "INSERT INTO email(address) VALUES('" + addr + "')";
                    try {
                        Db.execSQL(insert);
                        Toast.makeText(getApplicationContext(), "Contact  Insert Success", Toast.LENGTH_SHORT).show();



                    } catch (Exception e) {
                        Toast.makeText(getApplicationContext(), "Exception in Inserting" + e, Toast.LENGTH_SHORT).show();
                    }
                }

            }
        });
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(UserMainActivity1.this,Delmailaddress.class);
                startActivity(i);
            }
        });
    }


}
