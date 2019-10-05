package com.example.user.groceriesfinal;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class custlogin extends Activity {
    EditText etname2,etpass2;
    BaseHelper myDb;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_custlogin);
        etname2 = findViewById(R.id.txtemailc);
        etpass2 =  findViewById(R.id.txtpassc);
        myDb = new BaseHelper(this);
        setTitle("Login As Customer");


    }

    public void signupc(View view)
    {
        Intent i=new Intent(custlogin.this,custreg.class);
        startActivity(i);
    }

    public void cloginc(View view)
    {


        String username1 = etname2.getText().toString();
        String password = etpass2.getText().toString();
        Cursor res = myDb.getAllData(username1);
        if (res.getCount()==0)
        {
            showMessage("ERROR","USER DOES NOT EXIST");
            return;
        }
        else if(res.moveToNext())
        {
            if(res.getString(3).equals(etpass2.getText().toString().trim()))
            {
                Intent i1 = new Intent(custlogin.this,custshowdetails.class);
                custlogin.this.startActivity(i1);
                custlogin.this.finish();
            }
            else
                Toast.makeText(this, "Password Is Invalid", Toast.LENGTH_SHORT).show();


        }

    }
    private void showMessage(String error, String s) {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setCancelable(true);
        builder.setTitle(error);
        builder.setMessage(s);
        builder.show();

    }
}
