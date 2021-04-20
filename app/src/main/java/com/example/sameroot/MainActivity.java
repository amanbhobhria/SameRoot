package com.example.sameroot;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.ActivityOptions;
import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Pair;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class MainActivity extends AppCompatActivity {
    private EditText emailEt, passwordEt;
    private Button SignInButton;
    Button login_btn;
    private TextView SignUpTv;
    private TextView ForgetTv;
    private ProgressDialog progressDialog;
    private FirebaseAuth firebaseAuth;

    @Override
    protected void onResume() {
        super.onResume();

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        firebaseAuth = FirebaseAuth.getInstance();
        emailEt = findViewById(R.id.email);
        passwordEt = findViewById(R.id.password);

        SignInButton = findViewById(R.id.signin);
        progressDialog = new ProgressDialog(this);
        SignUpTv = findViewById(R.id.signupTv);
        ForgetTv = findViewById(R.id.ResetTv);
        SignInButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Login();

            }
        });
        SignUpTv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, SignUpActivity.class);
                startActivity(intent);

            }
        });
        ForgetTv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, ForgetActivity.class);
                startActivity(intent);

            }
        });


        if(firebaseAuth.getCurrentUser()!=null)  {
            Intent intent = new Intent(MainActivity.this, UserTypeActivity.class);
            startActivity(intent);
            finish();
        }
    }


    private void Login() {
        String email = emailEt.getText().toString();
        String password = passwordEt.getText().toString();
        if (TextUtils.isEmpty(email)) {
            emailEt.setError("Enter your email.");
            return;
        } else if (TextUtils.isEmpty(password)) {
            passwordEt.setError("Enter your password.");
            return;
        }

        progressDialog.setMessage("Please wait...");
        progressDialog.show();
        progressDialog.setCanceledOnTouchOutside(false);
        firebaseAuth.signInWithEmailAndPassword(email, password).addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if (task.isSuccessful()) {

                    if (firebaseAuth.getCurrentUser().isEmailVerified()) {

                        Toast.makeText(MainActivity.this, "Succussfully Logged In !!", Toast.LENGTH_LONG).show();
                        Intent intent = new Intent(MainActivity.this, UserTypeActivity.class);
                        startActivity(intent);
                        finish();
                    } else {
                        Toast.makeText(MainActivity.this, "Link has been to your email, Please verify your EMAIL ID..!!", Toast.LENGTH_LONG).show();
                    }
                } else {
                    Toast.makeText(MainActivity.this, "Sign in failed..!!", Toast.LENGTH_LONG).show();
                }
                progressDialog.dismiss();
            }
        });

    }
}


