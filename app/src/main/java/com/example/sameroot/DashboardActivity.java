package com.example.sameroot;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.auth.FirebaseAuth;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class DashboardActivity extends AppCompatActivity {
    Button  btnView;
    TextView TVname,TVemail,TVmob;
    DatabaseReference databaseReference;
    private FirebaseAuth firebaseAuth;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.dashboard);
        //database retrieve:-

        TVname = findViewById(R.id.tvname);
        TVemail = findViewById(R.id.tvemail);
        TVmob = findViewById(R.id.tvmob);
        btnView = findViewById(R.id.viewprofile);
        firebaseAuth = FirebaseAuth.getInstance();


//        LogOutBTN = findViewById(R.id.logout);
//        LogOutBTN.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Intent intent = new Intent(DashboardActivity.this, MainActivity.class);
//                startActivity(intent);
//                finish();
//                Toast.makeText(DashboardActivity.this,"You're Logged out",Toast.LENGTH_SHORT).show();
//
//            }
//        });

        


         btnView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                databaseReference = FirebaseDatabase.getInstance().getReference().child("UserDATA").child("MTPbIBR0taxNGlK1VLX");
                databaseReference.addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot snapshot) {
                        String name = snapshot.child("name").getValue().toString();
                        String email = snapshot.child("email").getValue().toString();
                        String mobile = snapshot.child("Mobile").getValue().toString();
                        TVname.setText(name);
                        TVemail.setText(email);
                        TVmob.setText(mobile);
                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError error) {

                    }
                });
            }
        });
    }



    public void logout(View view) {
        firebaseAuth.signOut();
    }
}
