package com.example.user.groceriesfinal;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    Button shopkeeper,customer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        shopkeeper=findViewById(R.id.shopkeeper);
        customer=findViewById(R.id.customer);
        setTitle("Welcome to Groceries Rate");
    }

    public void shopkeeper(View view)
    {
        Intent i=new Intent(MainActivity.this,shoplogin.class);
        startActivity(i);
    }

    public void customer(View view)
    {
        Intent i=new Intent(MainActivity.this,custlogin.class);
        startActivity(i);
    }
}
