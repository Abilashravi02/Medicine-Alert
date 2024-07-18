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
import android.widget.Toast;

public class Userpagelogin extends AppCompatActivity {
    Button b1,b2;
    EditText e1,e2;
    String user,pass,dbpass,dbuser,dbpass1,dbuser1;
    int fg=0;
    int flg=0;
    String empty="";
    Cursor c,c1;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signin);
        e1=(EditText)findViewById(R.id.usrusr);
        e2=(EditText)findViewById(R.id.pswrd);

        b1=(Button)findViewById(R.id.sin);

        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                boolean isAllFieldsChecked = false;
                flg=0;
                fg=0;
                int status=0;
                user=e1.getText().toString();
                pass=e2.getText().toString();

                isAllFieldsChecked  = CheckAllFields();

              if(isAllFieldsChecked)
                {
                    SQLiteDatabase db = openOrCreateDatabase("elder", Context.MODE_PRIVATE, null);

                    try {

                        if (db != null) {


                            c = db.rawQuery("SELECT * from userdetails", null);
                            if (c.moveToFirst()) {
                                do {


                                    dbuser = c.getString(c.getColumnIndexOrThrow("name"));
                                    dbpass = c.getString(c.getColumnIndexOrThrow("pass"));
                                    if (dbuser.equals(user)) {
                                        if (dbpass.equals(pass)) {

                                            //status

                                            status = 1;
                                            Toast.makeText(getApplicationContext(), "User  Login success  " + user, Toast.LENGTH_SHORT).show();
                                            flg = 1;
                                            //Intent i = new Intent(Userpagelogin.this, AlarmMe.class);

                                            Intent i = new Intent(Userpagelogin.this, userpage.class);

                                           // i.putExtra("user",user);
                                            startActivity(i);
                                        }

                                    } else {
                                        // Toast.makeText(getApplicationContext(),"Invalid Password"+user,Toast.LENGTH_SHORT).show();

                                    }

                                } while (c.moveToNext());

                            }
                        }
                    } catch (Exception e) {
                        Toast.makeText(getApplicationContext(), "Exception in extracting " + e, Toast.LENGTH_SHORT).show();
                    }


                    //check second db






                }


                }


        });


    }

    private boolean CheckAllFields() {

        if (e1.length() == 0) {
            e1.setError("UserName field is required");
            return false;
        }

        if (e2.length() == 0) {
            e2.setError("Password field is required");
            return false;
        }
        // after all validation return true.
        return true;
    }













}
