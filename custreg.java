package com.example.user.groceriesfinal;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class custreg extends Activity {


    Button subc;
    BaseHelper myDb;
    EditText etname1, etpass1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_custreg);
        subc = findViewById(R.id.subc);
        etname1 = findViewById(R.id.namec);
        etpass1 = findViewById(R.id.passc);
        myDb = new BaseHelper(this);
        setTitle("Register As Customer");
    }

    public void subc(View view) {
        boolean isInserteda = myDb.insert(etname1.getText().toString(), etpass1.getText().toString());
        if (isInserteda == true)
            Toast.makeText(this, "REGISTRATION SUCCESSFUL!!!", Toast.LENGTH_SHORT).show();
        else
            Toast.makeText(this, "FAILED TO REGISTER???", Toast.LENGTH_SHORT).show();


    }

    public void backtologin(View view) {
        Intent i = new Intent(custreg.this, custlogin.class);
        startActivity(i);
    }


}
