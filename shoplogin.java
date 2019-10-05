package com.example.user.groceriesfinal;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class shoplogin extends Activity
{
    EditText etname,etpass;
    BaseHelper myDb;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shoplogin);
        etname = (EditText) findViewById(R.id.txtemail);
        etpass = (EditText) findViewById(R.id.txtpass);
        myDb = new BaseHelper(this);
        setTitle("Login As Shopkeeper");
    }

    public void ssignup(View view)
    {
        Intent i=new Intent(shoplogin.this,shopreg.class);
        startActivity(i);
    }

    public void slogin(View view)
    {
        String username = etname.getText().toString();
        String password = etpass.getText().toString();
        Cursor res = myDb.getAllData(username);
        if (res.getCount()==0)
        {
            showMessage("ERROR","USER DOES NOT EXIST");
            return;
        }
        else if(res.moveToNext())
        {
            if(res.getString(3).equals(etpass.getText().toString().trim()))
            {
                Intent i1 = new Intent(shoplogin.this,shopdetails.class);
               shoplogin.this.startActivity(i1);
               shoplogin.this.finish();
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

