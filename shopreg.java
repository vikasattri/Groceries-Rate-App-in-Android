package com.example.user.groceriesfinal;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class shopreg extends Activity {

    Button sub;
    BaseHelper myDb;
    EditText etname,etpass;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shopreg);
        sub=findViewById(R.id.sub);
        etname=findViewById(R.id.names);
        etpass=findViewById(R.id.passs);
        myDb=new BaseHelper(this);
        setTitle("Register As Shopkeeper");
    }

    public void sub(View view)
    {
        boolean isInserted = myDb.insert(etname.getText().toString(),etpass.getText().toString());
        if (isInserted==true)
            Toast.makeText(this, "REGISTRATION SUCCESSFUL!!!", Toast.LENGTH_SHORT).show();
        else
            Toast.makeText(this, "FAILED TO REGISTER???", Toast.LENGTH_SHORT).show();


    }

    public void backtologin(View view)
    {
        Intent i=new Intent(shopreg.this,shoplogin.class);
        startActivity(i);
    }

}
