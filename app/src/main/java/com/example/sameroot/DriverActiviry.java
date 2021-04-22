package com.example.sameroot;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

import androidx.annotation.Nullable;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class DriverActiviry extends Activity {
    EditText d_name, d_mobile, d_carno, d_carModel, d_adhar, d_city;
    Button DriverButton;
    DatabaseReference DriverDbRef;
    ProgressBar progress_circular;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.driver);
        d_name = findViewById(R.id.D_name);
        d_carno = findViewById(R.id.C_no);
        d_carModel = findViewById(R.id.C_model);
        d_adhar = findViewById(R.id.C_adhaar);
        d_city = findViewById(R.id.p_City);
        d_mobile = findViewById(R.id.Driver_mobile);
        DriverButton = findViewById(R.id.SubmitDriverButton);
        progress_circular = findViewById(R.id.progress_circular);
        DriverDbRef = FirebaseDatabase.getInstance().getReference().child("Drivers");
        DriverButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                insertDriverData();
        }

        });

    }

    private void insertDriverData(){
        String ddname = d_name.getText().toString();
        String ddcarno = d_carno.getText().toString();
        String ddcarmodel = d_carModel.getText().toString();
        String ddadhar = d_adhar.getText().toString();
        String ddcity = d_city.getText().toString();
        String ddmobile = d_mobile.getText().toString();
        Driver ddriver = new Driver(ddname, ddcarno, ddcarmodel, ddadhar, ddcity, ddmobile, ddmobile);
        DriverDbRef.push().setValue(ddriver);
        Toast.makeText(DriverActiviry.this, "Data submitted!", Toast.LENGTH_SHORT).show();

        Intent intent = new Intent();
        intent.putExtra("isDataUpdate","1");
        setResult(2,intent);
        finish();//finishing activity

       /* Intent intent=new Intent(DriverActiviry.this, MainActivity.class);
        startActivity(intent);*/
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu){
    //Inflate the menu this adds item to the action bar if it present
        getMenuInflater().inflate(R.menu.menu,menu);
        return true;
        }
        }
