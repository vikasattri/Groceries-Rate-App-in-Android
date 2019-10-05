package com.example.user.groceriesfinal;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class shopdetails extends Activity
{
    Button submit;
    DatabaseHelper databaseHelper;

    //EditText etname,etemail,etcompany,etnumber;
    //String name,city,company,country ;

    EditText e1,e2,e3,e4,e5,e6,e7,e8,e9,e10,e11,e12,e13;
    String shop,loc,des,veg1,pr1,veg2,pr2,veg3,pr3,veg4,pr4,veg5,pr5 ;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shopdetails);
       e1=findViewById(R.id.id1);
       e2=findViewById(R.id.id2);
        e3=findViewById(R.id.id3);
        e4=findViewById(R.id.id4);
        e5=findViewById(R.id.id5);
        e6=findViewById(R.id.id6);
        e7=findViewById(R.id.id7);
        e8=findViewById(R.id.id8);
        e9=findViewById(R.id.id9);
        e10=findViewById(R.id.id10);
        e11=findViewById(R.id.id11);
        e12=findViewById(R.id.id12);
        e13=findViewById(R.id.id13);
        //etname =  findViewById(R.id.etname);
       // etemail = findViewById(R.id.etemail);
       // etcompany = findViewById(R.id.etcompany);
        //etnumber =  findViewById(R.id.etphone);


        submit =  findViewById(R.id.submit);

        databaseHelper = new DatabaseHelper(this);

        setTitle("Shop Details");

    }

    public void submit(View view)
    {
        Toast.makeText(getApplicationContext(), "Details Entered", Toast.LENGTH_SHORT).show();
       shop=e1.getText().toString();
       loc=e2.getText().toString();
       des=e3.getText().toString();
       veg1=e4.getText().toString();
       pr1=e5.getText().toString();
       veg2=e6.getText().toString();
       pr2=e7.getText().toString();
       veg3=e8.getText().toString();
       pr3=e9.getText().toString();
       veg4=e10.getText().toString();
       pr4=e11.getText().toString();
       veg5=e12.getText().toString();
       pr5=e13.getText().toString();






        if (shop.isEmpty() && loc.isEmpty()&& des.isEmpty()&& veg1.isEmpty() && pr1.isEmpty()){

            Toast.makeText(this, "please fill details", Toast.LENGTH_SHORT).show();
        }else {

            databaseHelper.insertdata(shop,loc,des,veg1,veg2,veg3,veg4,veg5,pr1,pr2,pr3,pr4,pr5);
            e1.setText("");
            e2.setText("");
            e3.setText("");
            e4.setText("");
            e5.setText("");
            e6.setText("");
            e7.setText("");
            e8.setText("");
            e9.setText("");
            e10.setText("");
            e11.setText("");
            e12.setText("");
            e13.setText("");
            Toast.makeText(this, "Details Entered", Toast.LENGTH_SHORT).show();

            Intent intent = new Intent(shopdetails.this,custshowdetails.class);
            startActivity(intent);

        }





    }
}
