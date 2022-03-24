package com.example.attendance_collector;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Viewlist extends AppCompatActivity {
    private FirebaseDatabase database;
    private DatabaseReference myRef = null;

    RecyclerView recyclerView;
    Myadapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_viewlist);

        recyclerView=findViewById(R.id.userlist);

        recyclerView.setLayoutManager(new LinearLayoutManager(getApplicationContext()));


        processsearch();


    }

    private void processsearch()
    {
        database=FirebaseDatabase.getInstance();
        myRef=database.getReference("NAme");

        myRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {



                List <student_list> listres = new ArrayList<>();


                for (DataSnapshot dataValues : snapshot.getChildren())
                {

                    student_list t=dataValues.getValue(student_list.class);


                    listres.add(t);
                   // student_list s1 = dataValues.getValue(student_list.class);


                }

                ArrayList<student_list> arrayList=new ArrayList<student_list>();

                for (int i=0;i<listres.size();i++)
                {
                        arrayList.add(listres.get(i));


                }




                adapter = new Myadapter(arrayList);
                recyclerView.setAdapter(adapter);


            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });

    }

}