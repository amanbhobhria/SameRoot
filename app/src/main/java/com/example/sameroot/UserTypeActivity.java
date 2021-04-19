package com.example.sameroot;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;

import androidx.annotation.Nullable;

public class UserTypeActivity extends Activity {
    private Button PostButton, BackButton, gotoDashboard;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.usertype);
        PostButton=findViewById(R.id.postBTN);
        BackButton = findViewById(R.id.backButton);
        gotoDashboard = findViewById(R.id.GoToDashboard);
        PostButton.setOnClickListener(new View.OnClickListener() {
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
