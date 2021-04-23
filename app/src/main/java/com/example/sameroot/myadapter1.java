package com.example.sameroot;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.firebase.ui.database.FirebaseRecyclerOptions;

import de.hdodenhof.circleimageview.CircleImageView;


public class myadapter1 extends FirebaseRecyclerAdapter<model1,myadapter1.myviewholder> {
    public myadapter1(@NonNull FirebaseRecyclerOptions<model1> options) {
        super(options);
    }

    @Override
    protected void onBindViewHolder(@NonNull myviewholder holder, int i, @NonNull model1 model1) {
        holder.driver_Name.setText(model1.getDriver_Name());
        holder.driver_Mobile_No.setText(model1.getDriver_Mobile_No());
        holder.driver_Adhaar_No.setText(model1.getDriver_Adhaar_No());
        holder.car_No.setText(model1.getCar_No());
        holder.car_Model.setText(model1.getCar_Model());
        holder.car_Company.setText(model1.getCar_Company());
        //Glide.with(holder.img.getContext()).load(model1.getPurl()).into(holder.img)

    }

    @NonNull
    @Override
    public myviewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
       View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.singlerow1,parent,false);
       return new myviewholder(view);
    }

    class myviewholder extends RecyclerView.ViewHolder
    {
        CircleImageView img;
        TextView driver_Name,driver_Mobile_No,driver_Adhaar_No,car_No,car_Model,car_Company;
        public myviewholder(@NonNull View itemView) {
            super(itemView);
            img =( CircleImageView) itemView.findViewById(R.id.img1);
            driver_Name =(TextView)itemView.findViewById(R.id.driver_Name);
            driver_Mobile_No =(TextView)itemView.findViewById(R.id.  driver_Mobile_No);
            driver_Adhaar_No =(TextView)itemView.findViewById(R.id.driver_Adhaar_No);
            car_No =(TextView)itemView.findViewById(R.id.car_No);
            car_Model =(TextView)itemView.findViewById(R.id.car_Model);
            car_Company =(TextView)itemView.findViewById(R.id.car_Company);
        }
    }
}
