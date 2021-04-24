

package com.example.sameroot;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.firebase.ui.database.FirebaseRecyclerOptions;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class PassengerFetchActivity extends AppCompatActivity {
    RecyclerView recview;
    myadapter1 adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_passenger_fetch);

        recview=(RecyclerView)findViewById(R.id.recview);
        recview.setLayoutManager(new LinearLayoutManager(this));

        FirebaseRecyclerOptions<model1> options =
                new FirebaseRecyclerOptions.Builder<model1>()
                        .setQuery(FirebaseDatabase.getInstance().getReference().child("Drivers"), model1.class)
                        .build();
        adapter =new myadapter1(options);


        recview.setAdapter(adapter);
    }
    @Override
    protected  void onStart() {
        super.onStart();
        adapter.startListening();
    }
    @Override
    protected void onStop() {
        super.onStop();
        adapter.stopListening();
    }
}