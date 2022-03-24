package com.example.attendance_collector;

//import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import com.google.firebase.database.FirebaseDatabase;

import java.text.SimpleDateFormat;
import java.util.Date;

public class MainActivity extends AppCompatActivity {
    EditText e_name,last_name,age,mobile,email;
    Button button,but_next;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        e_name = findViewById(R.id.e_name);
        last_name = findViewById(R.id.lastname);
        age = findViewById(R.id.Age);
        mobile = findViewById(R.id.phone);
        email = findViewById(R.id.email);

        button = findViewById(R.id.button);
        button = findViewById(R.id.button);
        but_next = findViewById(R.id.button2);

        button.setOnClickListener(view -> {

            String r=e_name.getText().toString().trim();
            String l = last_name.getText().toString().trim();   // getting text from edit text last name
            String a = age.getText().toString().trim();
            String m = mobile.getText().toString().trim();
            String em = email.getText().toString().trim();

            // for showing date and time in firebase ----------
            SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
            Date date = new Date();

            String dtfl=formatter.format(date);
            //-----------
            User us=new User(r,l,a,m,em,dtfl);

            // for random id generation
            int b = (int)(Math.random()*343465);
            String w=Integer.toString(b);

//                FirebaseDatabase database = FirebaseDatabase.getInstance();
//                DatabaseReference myRef = database.getReference("message");
//
//                myRef.setValue("Hello, World!");

            FirebaseDatabase.getInstance().getReference("NAme").child(w).setValue(us).addOnCompleteListener(task -> {
                if(task.isSuccessful())
                {
                    Toast.makeText(MainActivity.this, "data store", Toast.LENGTH_SHORT).show();
                }
                else
                {
                    Toast.makeText(MainActivity.this, "error", Toast.LENGTH_SHORT).show();

                }

            });

        });


        but_next.setOnClickListener(view -> {
                    Intent i = new Intent(MainActivity.this,Viewlist.class);
                    startActivity(i);
                    finish();
                }
                );

    }
}