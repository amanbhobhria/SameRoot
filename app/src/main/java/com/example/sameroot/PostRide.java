package com.example.sameroot;

import android.app.Activity;
import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Build;
import android.os.Bundle;
import android.text.format.DateFormat;
import android.view.Menu;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.TimePicker;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;

import com.google.android.libraries.places.api.Places;
import com.google.android.libraries.places.api.model.Place;
import com.google.android.libraries.places.widget.Autocomplete;
import com.google.android.libraries.places.widget.model.AutocompleteActivityMode;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.List;

public class PostRide extends Activity {
    EditText startLocationEdit;
    EditText sLocation, endLocationEdt, seats;
    TextView textView1, textView2, textView3, textView4, dateTE, TimeTE;
    Button Passengerbutton;
    Button Driverbutton;


    TextView updateProfileTxt;

    private Spinner spDriver, spPassenger;
    private Spinner n1, n2, n3, n4;
    String Seat_No = "";
    String Rider_type = "";
    int hour, minute;
    DatePickerDialog.OnDateSetListener setListener;

    DatabaseReference PassengerDbRef;
    DatabaseReference DriverDbRef;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.postride);
        //Assign variable
        startLocationEdit = findViewById(R.id.StartLocation);
        textView1 = findViewById(R.id.text_view1);
        textView2 = findViewById(R.id.text_view2);

        endLocationEdt = findViewById(R.id.EndLocation);
        textView3 = findViewById(R.id.text_view3);
        textView4 = findViewById(R.id.text_view4);
        updateProfileTxt = findViewById(R.id.updateProfileTxt);

        //Initiate places
        Places.initialize(getApplicationContext(), "AIzaSyD8Q0NsAedZvLJ2Li1gouQ82i22t-0mod4");
        //Set Edit Tect non focusable
        startLocationEdit.setFocusable(false);
        startLocationEdit.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                //Initialize place field list
                List<Place.Field> fieldList = Arrays.asList(Place.Field.ADDRESS
                        , Place.Field.LAT_LNG, Place.Field.NAME);
                //Create intent
                Intent intent = new Autocomplete.IntentBuilder(AutocompleteActivityMode.OVERLAY,
                        fieldList).build(PostRide.this);
                //Start activity result
                startActivityForResult(intent, 100);


            }
        });


        endLocationEdt.setFocusable(false);
        endLocationEdt.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                //Initialize place field list
                List<Place.Field> fieldList = Arrays.asList(Place.Field.ADDRESS
                        , Place.Field.LAT_LNG, Place.Field.NAME);
                //Create intent
                Intent intent = new Autocomplete.IntentBuilder(AutocompleteActivityMode.OVERLAY,
                        fieldList).build(PostRide.this);
                //Start activity result
                startActivityForResult(intent, 101);


            }
        });



        dateTE = findViewById(R.id.date);
        TimeTE = findViewById(R.id.time);
        Passengerbutton = findViewById(R.id.SubmitPassengerButton);

        Calendar calendar = Calendar.getInstance();
        final int year = calendar.get(Calendar.YEAR);
        final int month = calendar.get(Calendar.MONTH);
        final int day = calendar.get(Calendar.DAY_OF_MONTH);
        //}

        Spinner spinner1 = findViewById(R.id.spinner_seat_no);
        ArrayList<String> arrayList1 = new ArrayList<>();
        arrayList1.add("Seat");
        arrayList1.add("1");
        arrayList1.add("2");
        arrayList1.add("3");
        arrayList1.add("4");
        ArrayAdapter<String> arrayAdapter1 = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, arrayList1);
        arrayAdapter1.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner1.setAdapter(arrayAdapter1);
        spinner1.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                String seatno = parent.getItemAtPosition(position).toString();
                Toast.makeText(parent.getContext(), "Selected: " + seatno, Toast.LENGTH_LONG).show();
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });


        final Spinner spinner = findViewById(R.id.spinner_rider_type);
        ArrayList<String> arrayList = new ArrayList<>();
        arrayList.add("Rider Type");
        arrayList.add("Driver");
        arrayList.add("Passenger");
        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, arrayList);
        arrayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(arrayAdapter);
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

                if (position == 0) {
                    return;
                }

                String gender = parent.getItemAtPosition(position).toString();

                if (gender.equalsIgnoreCase("Driver")) {
                    updateProfileTxt.setVisibility(View.VISIBLE);
                    updateProfileTxt.setText(R.string.update_profile);
                    //  Intent intent = new Intent(PostRide.this, DriverActiviry.class);
                    //startActivityForResult(intent, 2);//All activity is started with requestcode2
                    // got to driver
                } else if (gender.equalsIgnoreCase("Passenger")) {
                    updateProfileTxt.setVisibility(View.VISIBLE);
                    updateProfileTxt.setText(R.string.update_profile);
                    //  Intent intent = new Intent(PostRide.this,PassengerActivity.class);
                    //startActivityForResult(intent, 2);//All activity is started with requestcode2
                    //go to passenger
                } else {
                    updateProfileTxt.setVisibility(View.GONE);
                }
                // Toast.makeText(parent.getContext(), "Selected: " + gender, Toast.LENGTH_LONG).show();
            }


            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }


        });

        updateProfileTxt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                if (spinner.getSelectedItemPosition() == 1) {
                    Intent intent = new Intent(PostRide.this, DriverActiviry.class);
                    startActivityForResult(intent, 2);//All activity is started with requestcode 2
                    // got to driver
                }
                if (spinner.getSelectedItemPosition() == 2) {
                    Intent intent = new Intent(PostRide.this, PassengerActivity.class);
                    startActivityForResult(intent, 2);//All activity is started with requestcode2
                    // go to passenger
                }

            }
        });

        dateTE.setOnClickListener(new View.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.N)
            @Override
            public void onClick(View view) {
                DatePickerDialog datePickerDialog = new DatePickerDialog(PostRide.this, android.R.style.Theme_Holo_Light_Dialog_MinWidth, setListener, year, month, day);
                datePickerDialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.GRAY));
                datePickerDialog.show();


            }
        });
        TimeTE.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                TimePickerDialog timePickerDialog = new TimePickerDialog(PostRide.this, new TimePickerDialog.OnTimeSetListener() {
                    @Override
                    public void onTimeSet(TimePicker timePicker, int hourOfDay, int minuteOfDay) {
                        hour = hourOfDay;
                        minute = minuteOfDay;
                        Calendar calendar1 = Calendar.getInstance();
                        calendar1.set(0, 0, 0, hour, month);
                        TimeTE.setText(DateFormat.format("hh:mm aa", calendar1));
                    }
                }, 12, 0, false);
                timePickerDialog.updateTime(hour, minute);
                timePickerDialog.show();
            }
        });


        setListener = new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker datePicker, int year, int month, int dayOfMonth) {
                month = month + 1;
                String date = day + "/" + month + "/" + year;
                dateTE.setText(date);


            }
        };

        DriverDbRef = FirebaseDatabase.getInstance().getReference().child("RIDE_DETAILS");


        Passengerbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                insertPassengerData();
            }
        });


        PassengerDbRef = FirebaseDatabase.getInstance().getReference().child("RIDE_DETAILS");


        Passengerbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                insertPassengerData();

            }
        });

    }


    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 100 && resultCode == RESULT_OK) {
            //When Success
            //initialize place
            Place place = Autocomplete.getPlaceFromIntent(data);
            //Set address on EditText
            startLocationEdit.setText(place.getAddress());
            //Set locality name
            textView1.setText(String.format("Locality Name : %s", place.getName()));
            //Set latitude & longitude
            textView2.setText(String.valueOf(place.getLatLng()));
        } else if (requestCode == 101 && resultCode == RESULT_OK) {
            //When Success
            //initialize place
            Place place = Autocomplete.getPlaceFromIntent(data);
            //Set address on EditText
            endLocationEdt.setText(place.getAddress());
            //Set locality name
            textView1.setText(String.format("Locality Name : %s", place.getName()));
            //Set latitude & longitude
            textView2.setText(String.valueOf(place.getLatLng()));
        }
        if (requestCode == 2) {

            if (resultCode == RESULT_OK) {

                if (data.getStringExtra("isDataUpdate").equalsIgnoreCase("1")) {
                    updateProfileTxt.setText(R.string.updated);
                    updateProfileTxt.setVisibility(View.VISIBLE);
                }
            } else if (resultCode == RESULT_CANCELED) {
                Toast.makeText(this, "Canceled", Toast.LENGTH_SHORT).show();
            }

        }
    }

    private void insertPassengerData() {
        final String Slocation = sLocation.getText().toString();
        final String Elocation = endLocationEdt.getText().toString();
        final String Date = dateTE.getText().toString();
        final String Time = TimeTE.getText().toString();
        //String nSeats = seats.getText().toString();

        if (spDriver.isSelected()) {
            Rider_type = "Driver";
        }
        if (spPassenger.isSelected()) {
            Rider_type = "Passenger";
        }

        if (n1.isSelected()) {
            Seat_No = "1";
        }
        if (n2.isSelected()) {
            Seat_No = "2";
        }

        if (n3.isSelected()) {
            Seat_No = "3";
        }
        if (n4.isSelected()) {
            Seat_No = "4";
        }
        RideDetails rideDetails = new RideDetails(Slocation, Elocation, Date, Time, Seat_No, Rider_type);
        PassengerDbRef.push().setValue(rideDetails);
        Toast.makeText(PostRide.this, "Data submitted!", Toast.LENGTH_SHORT).show();
        Intent intent = new Intent(PostRide.this, DashboardActivity.class);
        startActivity(intent);
        finish();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu, menu);
        return true;
    }




}
