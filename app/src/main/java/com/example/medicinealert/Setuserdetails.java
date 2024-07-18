package com.example.a91962.medicinealert;

import android.content.Context;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Setuserdetails extends AppCompatActivity {

    EditText e1,e2,e3,e4,e5;
    String user;
    String empty="";
    String name,mail,phone,address;
    int age,fg=0;
    Button b1,b2;
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_usersignin);
        e1=(EditText)findViewById(R.id.editText);
        e2=(EditText)findViewById(R.id.editText3);
        e3=(EditText)findViewById(R.id.editText7);
        e4=(EditText)findViewById(R.id.editText6);

        b1=(Button)findViewById(R.id.sin);

        final SQLiteDatabase db=openOrCreateDatabase("elder", Context.MODE_PRIVATE,null);
        String q1="CREATE TABLE userdetails(name TEXT,pass TEXT,adrees TEXT,phone TEXT);";
        try{

            db.execSQL(q1);
        }
        catch (Exception e){
            Toast.makeText(this,"Exception "+e,Toast.LENGTH_SHORT).show();
        }





        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                 boolean isAllFieldsChecked = false;
                name=e1.getText().toString();

                mail=e2.getText().toString();
                phone=e3.getText().toString();
                address=e4.getText().toString();


                isAllFieldsChecked  = CheckAllFields();

                if(isAllFieldsChecked) {

                    String insert = "INSERT INTO userdetails(name,pass,adrees,phone) VALUES('" + e1.getText().toString() + "','" + e2.getText().toString() + "','" + e3.getText().toString() + "','" + e4.getText().toString() + "')";
                    try {
                        db.execSQL(insert);
                        Toast.makeText(getApplicationContext(), "User Details Register Success", Toast.LENGTH_SHORT).show();
                        Intent i = new Intent(Setuserdetails.this, UserMainActivity.class);
                        startActivity(i);

                    } catch (Exception e) {
                        Toast.makeText(getApplicationContext(), "Exception in inserting " + e, Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });
    }


    private boolean CheckAllFields() {
        if (e1.length() == 0) {
            e1.setError("Name field is required");
            return false;
        }

        if (e2.length() == 0) {
            e2.setError("Password field is required");
            return false;
        }else if (e2.length() < 8) {
            e2.setError("Password must be minimum 8 characters");
            return false;
        }

        if (e3.length() == 0) {
            e3.setError("Address field is required");
            return false;
        }

        if (e4.length() == 0) {
            e4.setError("Phone is required");
            return false;
        }

        // after all validation return true.
        return true;
    }












}
