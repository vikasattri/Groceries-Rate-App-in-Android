package com.example.user.groceriesfinal;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import java.util.ArrayList;
import java.util.List;

public class DatabaseHelper extends SQLiteOpenHelper {


    public static String DATABASE = "database.db";
    public static String TABLE ="mytable";
    public static String SHOP ="shop";
    public static String LOC ="loc";
    public static String DES ="des";
    public static String VEG1 ="veg1";
    public static String VEG2 ="veg2";
    public static String VEG3 ="veg3";
    public static String VEG4 ="veg4";
    public static String VEG5 ="veg5";
    public static String PR1 ="pr1";
    public static String PR2 ="pr2";
    public static String PR3 ="pr3";
    public static String PR4 ="pr4";
    public static String PR5 ="pr5";


    String br;

    public DatabaseHelper(Context context) {
        super(context, DATABASE, null, 1);

    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        //  br= "CREATE TABLE mytable(name TEXT,company TEXT,city TEXT,country TEXT);";
        br = "CREATE TABLE "+TABLE+"("+SHOP+ " Text, "+LOC+ " Text, "+DES+ " Text, "+VEG1+ " Text,"+VEG2+ " Text,"+VEG3+ " Text,"+VEG4+ " Text ,"+VEG5+ " Text,"+PR1+ " Text,"+PR2+ " Text,"+PR3+ " Text,"+PR4+ " Text,"+PR5+ " Text);";
        db.execSQL(br);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS "+TABLE+" ;");
    }


    public void insertdata(String shop,String loc ,String des,String veg1,String veg2,String veg3,String veg4,String veg5,String pr1,String pr2,String pr3,String pr4,String pr5)
    {
        System.out.print("Hello "+br);
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues= new ContentValues();


        contentValues.put(SHOP, shop);
        contentValues.put(LOC, loc);
        contentValues.put(DES, des);
        contentValues.put(VEG1,veg1);
        contentValues.put(VEG2,veg2);
        contentValues.put(VEG3,veg3);
        contentValues.put(VEG4,veg4);
        contentValues.put(VEG5,veg5);
        contentValues.put(PR1,pr1);
        contentValues.put(PR2,pr2);
        contentValues.put(PR3,pr3);
        contentValues.put(PR4,pr4);
        contentValues.put(PR5,pr5);

        db.insert(TABLE,null,contentValues);


    }

    public List<DataModel> getdata(){
        // DataModel dataModel = new DataModel();
        List<DataModel> data=new ArrayList<>();
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery("select * from "+TABLE+" ;",null);
        StringBuffer stringBuffer = new StringBuffer();
        DataModel dataModel = null;
        while (cursor.moveToNext()) {
            dataModel= new DataModel();
            String shop = cursor.getString(cursor.getColumnIndexOrThrow("shop"));
            String loc= cursor.getString(cursor.getColumnIndexOrThrow("loc"));
            String des = cursor.getString(cursor.getColumnIndexOrThrow("des"));
            String veg1 = cursor.getString(cursor.getColumnIndexOrThrow("veg1"));
            String veg2 = cursor.getString(cursor.getColumnIndexOrThrow("veg2"));
            String veg3 = cursor.getString(cursor.getColumnIndexOrThrow("veg3"));
            String veg4 = cursor.getString(cursor.getColumnIndexOrThrow("veg4"));
            String veg5= cursor.getString(cursor.getColumnIndexOrThrow("veg5"));
            String pr1 = cursor.getString(cursor.getColumnIndexOrThrow("pr1"));
            String pr2 = cursor.getString(cursor.getColumnIndexOrThrow("pr2"));
            String pr3 = cursor.getString(cursor.getColumnIndexOrThrow("pr3"));
            String pr4 = cursor.getString(cursor.getColumnIndexOrThrow("pr4"));
            String pr5 = cursor.getString(cursor.getColumnIndexOrThrow("pr5"));

            dataModel.setShop(shop);
            dataModel.setLoc(loc);
            dataModel.setDes(des);
            dataModel.setVeg1(veg1);
            dataModel.setVeg2(veg2);
            dataModel.setVeg3(veg3);
            dataModel.setVeg4(veg4);
            dataModel.setVeg5(veg5);
            dataModel.setPr1(pr1);
            dataModel.setPr2(pr2);
            dataModel.setPr3(pr3);
            dataModel.setPr4(pr4);
            dataModel.setPr5(pr5);



            stringBuffer.append(dataModel);
            data.add(dataModel);
        }

        for (DataModel mo:data ) {

            Log.i("Hellomo",""+mo.getShop());
        }

        return data;
    }



}

