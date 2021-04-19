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
//import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class MainActivity extends AppCompatActivity {
//    private EditText emailEt, passwordEt;
//    private Button SignInButton;
    Button login_btn;
//    private TextView SignUpTv;
//    private TextView ForgetTv;
//    private ProgressDialog progressDialog;
//   private FirebaseAuth firebaseAuth;

//    @Override
//    protected void onResume() {
//        super.onResume();

//    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
//      firebaseAuth = FirebaseAuth.getInstance();

        login_btn = findViewById(R.id.login_btn);
    }
    public void CallLoginScreen(View view) {


        Intent intent = new Intent(getApplicationContext(), LogIn.class);


        Pair[] pairs = new Pair[1];
        pairs[0] = new Pair(findViewById(R.id.login_btn), "transition_login");


        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.LOLLIPOP) {
            ActivityOptions options = ActivityOptions.makeSceneTransitionAnimation(MainActivity.this, pairs);
            startActivity(intent, options.toBundle());
        } else {
            startActivity(intent);
        }
    }


//        if(firebaseAuth.getCurrentUser() !=null){
//            Intent intent2 = new Intent(MainActivity.this, UserTypeActivity.class);
//            startActivity(intent2);
//            finish();
//        }
        public void callSignUpWelcome(View view){


            Intent intent = new Intent(getApplicationContext(), SignUp.class);


            Pair[] pairs = new Pair[1];
            pairs[0] = new Pair(findViewById(R.id.signUp_btn1st), "transition_signUp_welcome");


            if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.LOLLIPOP) {
                ActivityOptions options = ActivityOptions.makeSceneTransitionAnimation(MainActivity.this, pairs);
                startActivity(intent, options.toBundle());
            } else {
                startActivity(intent);
            }
        }

//    private void Login(){
//        String email = emailEt.getText().toString();
//        String password = passwordEt.getText().toString();
//        if (TextUtils.isEmpty(email)) {
//            emailEt.setError("Enter your email.");
//            return;
//        } else if (TextUtils.isEmpty(password)) {
//            passwordEt.setError("Enter your password.");
//            return;
//        }
//
//        progressDialog.setMessage("Please wait...");
//        progressDialog.show();
//        progressDialog.setCanceledOnTouchOutside(false);
//        firebaseAuth.signInWithEmailAndPassword(email,password).addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
//            @Override
//            public void onComplete(@NonNull Task<AuthResult> task) {
//                if(task.isSuccessful()) {
//
//                    if (firebaseAuth.getCurrentUser().isEmailVerified()) {
//
//                        Toast.makeText(MainActivity.this, "Succussfully Logged In !!", Toast.LENGTH_LONG).show();
//                        Intent intent = new Intent(MainActivity.this, UserTypeActivity.class);
//                        startActivity(intent);
//                        finish();
//                    }
//                    else {
//                        Toast.makeText(MainActivity.this, "Link has been to your email, Please verify your EMAIL ID..!!", Toast.LENGTH_LONG).show();
//                    }
//                }
//                else{
//                    Toast.makeText(MainActivity.this, "Sign in failed..!!", Toast.LENGTH_LONG).show();
//                }
//                progressDialog.dismiss();
//            }
//        });

   }


