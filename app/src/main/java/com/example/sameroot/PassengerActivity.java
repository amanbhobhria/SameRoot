package com.example.sameroot;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class PassengerActivity extends AppCompatActivity {

    EditText c_name, c_mobile, c_adhar, c_city;
    Button SubmitPassengerButton;
    DatabaseReference PassengersDbRef;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_passenger);
        c_name = findViewById(R.id.D_name);
        c_adhar = findViewById(R.id.C_adhaar);
        c_city = findViewById(R.id.p_City);
        c_mobile = findViewById(R.id.Driver_mobile);
        SubmitPassengerButton = findViewById(R.id.SubmitPassengerButton);
        PassengersDbRef = FirebaseDatabase.getInstance().getReference().child("RideDetails");
        SubmitPassengerButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //  insertPassengerData();
            }
        });

    }
        private void insertPassengerData(){
            String ddname = c_name.getText().toString();
            String c_adadhar = c_adhar.getText().toString();
            String ddcity = c_city.getText().toString();
            String ddmobile = c_mobile.getText().toString();
           // Passenger ppassenger = new Passenger(ppname, ddadhar, ddcity, ddmobile, ddmobile);
          //  DriverDbRef.push().setValue(ddriver);
          //  Toast.makeText(DriverActiviry.this, "Data submitted!", Toast.LENGTH_SHORT).show();

            Intent intent = new Intent();
            intent.putExtra("isDataUpdate",true);
            setResult(2,intent);
            finish();//finishing activity

       /* Intent intent=new Intent(DriverActiviry.this, MainActivity.class);
        startActivity(intent);*/
        }

}