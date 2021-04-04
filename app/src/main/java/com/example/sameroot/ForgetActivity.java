package com.example.sameroot;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;

public class ForgetActivity extends Activity {
    private EditText PasswordEmail;
    private Button ResetButton, BackButton;
    private FirebaseAuth firebaseAuth;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.forget);
        PasswordEmail = findViewById(R.id.forgetTv);
        ResetButton = findViewById(R.id.forgetemailButton);
        BackButton = findViewById(R.id.backButton);
        firebaseAuth =FirebaseAuth.getInstance();
        ResetButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String email = PasswordEmail.getText().toString().trim();
                if(email.equals("")){
                    Toast.makeText(ForgetActivity.this,"Please enter your regitered email !", Toast.LENGTH_SHORT).show();
                }
                else {
                    firebaseAuth.sendPasswordResetEmail(email).addOnCompleteListener(new OnCompleteListener<Void>() {
                        @Override
                        public void onComplete(@NonNull Task<Void> task) {
                            if(task.isSuccessful()){
                                Toast.makeText(ForgetActivity.this, "Password reset link sent to your email id !", Toast.LENGTH_LONG).show();
                                Intent intent=new Intent(ForgetActivity.this, MainActivity.class);
                                startActivity(intent);
                            }
                            else {
                                Toast.makeText(ForgetActivity.this, "Error in sending email.. Or the email is not registered!", Toast.LENGTH_LONG).show();
                            }
                        }
                    });
                }
            }
        });

        BackButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(ForgetActivity.this, MainActivity.class);
                startActivity(intent);
            }
        });
    }

}
