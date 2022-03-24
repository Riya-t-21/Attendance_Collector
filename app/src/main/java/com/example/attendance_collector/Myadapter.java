package com.example.attendance_collector;


import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class Myadapter extends RecyclerView.Adapter<Myadapter.myviewholder>
{
    ArrayList<student_list> dataholder;

    public Myadapter(ArrayList<student_list> dataholder) {

        this.dataholder = dataholder;

    }

    @NonNull
    @Override
    public myviewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.items,parent,false);
        return new myviewholder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull myviewholder holder, int position)
    {
        holder.name1.setText(dataholder.get(position).getName());
        holder.lastname1.setText(dataholder.get(position).getLastname());
        holder.age1.setText(dataholder.get(position).getAge());
        holder.mobile1.setText(dataholder.get(position).getMobile());
        holder.email1.setText(dataholder.get(position).getEmail());
        holder.date1.setText(dataholder.get(position).getDate());

    }

    @Override
    public int getItemCount() {
        return dataholder.size();
    }

    class myviewholder extends RecyclerView.ViewHolder
    {
        TextView name1,lastname1,age1,mobile1,email1,date1 ;

        public myviewholder(@NonNull View itemView)
        {
            super(itemView);
            name1=itemView.findViewById(R.id.names);
            lastname1=itemView.findViewById(R.id.lastnames);
            age1=itemView.findViewById(R.id.ages);
            mobile1=itemView.findViewById(R.id.mobiles);
            email1=itemView.findViewById(R.id.emails);
            date1=itemView.findViewById(R.id.dates);


        }
    }
}
