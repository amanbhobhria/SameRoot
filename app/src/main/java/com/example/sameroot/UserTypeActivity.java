package com.example.sameroot;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.annotation.Nullable;

public class UserTypeActivity extends Activity {
    private Button PassengerButton, BackButton, gotoDashboard;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.usertype);
        PassengerButton=findViewById(R.id.passengerBTN);
        BackButton = findViewById(R.id.backButton);
        gotoDashboard = findViewById(R.id.GoToDashboard);
        PassengerButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent=new Intent(UserTypeActivity.this, PostRide.class);
                startActivity(intent);

            }
        });
        BackButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(UserTypeActivity.this, MainActivity.class);
                startActivity(intent);
            }
    });
        gotoDashboard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(UserTypeActivity.this, DashboardActivity.class);
                startActivity(intent);
            }
        });
}
}
