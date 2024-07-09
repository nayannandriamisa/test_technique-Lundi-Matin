package com.example.lmbapp;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class CustomAdapter extends RecyclerView.Adapter<CustomAdapter.MyViewHolder> {

    private Context context;
    private ArrayList id, nomClient, prenomClient;



    CustomAdapter(Context context, ArrayList id, ArrayList nomClient, ArrayList prenomClient) {
        this.context = context;
        this.nomClient = nomClient;
        this.prenomClient = prenomClient;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.client, parent, false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CustomAdapter.MyViewHolder holder, int position) {
        holder.nomClientTxt.setText(String.valueOf(nomClient.get(position)));
        holder.prenomClientTxt.setText(String.valueOf(prenomClient.get(position)));
    }

    @Override
    public int getItemCount() {
        return id.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder{

        TextView nomClientTxt, prenomClientTxt;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            nomClientTxt = itemView.findViewById(R.id.nomClient);
            prenomClientTxt = itemView.findViewById(R.id.prenomClient);
        }
    }
}
