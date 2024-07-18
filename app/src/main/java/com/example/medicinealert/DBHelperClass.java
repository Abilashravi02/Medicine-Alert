package com.example.a91962.medicinealert;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteDatabase.CursorFactory;
import android.database.sqlite.SQLiteOpenHelper;

public  class DBHelperClass extends SQLiteOpenHelper{
	
	static final String dName = "Data";
	  static final String table = "contect";
	    static final String id = "id";
	    static final String user_number = "number";
	
	 public DBHelperClass(Context context) {
	        super(context, dName, null, 1);
	        // TODO Auto-generated constructor stub
	    }

	@Override
	public void onCreate(SQLiteDatabase db) {
		
		String CREATE_CONTACTS_TABLE="CREATE TABLE " + table +"(" + id + " INTEGER PRIMARY KEY AUTOINCREMENT," + user_number +" STRING)"; 
	        db.execSQL(CREATE_CONTACTS_TABLE);
		
	}
	 public void add(String n)
	    {
	        SQLiteDatabase sq=this.getWritableDatabase();
	        ContentValues cv=new ContentValues();
	        cv.put(user_number, n);
	        sq.insert(table,null,cv);
	    }
	    public Cursor getAll() {

	        SQLiteDatabase sq = this.getReadableDatabase();
	        String sql = "SELECT * FROM "+table+"";
	        Cursor c = sq.rawQuery(sql, null);
	        return c;

	    }

	@Override
	public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
		// TODO Auto-generated method stub
		
	}
	

}