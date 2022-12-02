package com.example.budgetbot;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class productPref_RecyclerViewAdapter extends RecyclerView.Adapter<productPref_RecyclerViewAdapter.MyViewHolder>{

    Context context;
    ArrayList<String> productTypes;

    public void setFilteredList(ArrayList<String> filteredList){
        this.productTypes = filteredList;
        notifyDataSetChanged();
    }
    public productPref_RecyclerViewAdapter(Context context, ArrayList<String> productTypes){
        this.productTypes = productTypes;
        this.context = context;
    }

    @NonNull
    @Override
    public productPref_RecyclerViewAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.recycler_view_row_pref, parent, false);



        return new productPref_RecyclerViewAdapter.MyViewHolder(view);

    }

    @Override
    public void onBindViewHolder(@NonNull productPref_RecyclerViewAdapter.MyViewHolder holder, int position) {

        holder.productView.setText(productTypes.get(position).toString());
        ArrayAdapter<CharSequence> productAdapter;
        if(productTypes.get(position).toLowerCase().toString().equals("chair")){
            productAdapter = ArrayAdapter.createFromResource(context, R.array.chair_type, android.R.layout.simple_spinner_item);
        }
        else if(productTypes.get(position).toLowerCase().toString().equals("sofa")){
            productAdapter = ArrayAdapter.createFromResource(context, R.array.sofa_type, android.R.layout.simple_spinner_item);
        }
        else if(productTypes.get(position).toLowerCase().toString().equals("fridge")){
            productAdapter = ArrayAdapter.createFromResource(context, R.array.fridge_type, android.R.layout.simple_spinner_item);
        }
        else productAdapter = ArrayAdapter.createFromResource(context, R.array.table_type, android.R.layout.simple_spinner_item);

        productAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        holder.typeSpinner.setAdapter(productAdapter);
        //ArrayAdapter<CharSequence> quantityAdapter = ArrayAdapter.createFromResource(context, R.array.quantity_array, android.R.layout.simple_spinner_item);
        //quantityAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
       // holder.quantitySpinner.setAdapter(quantityAdapter);
    }

    @Override
    public int getItemCount() {
        return productTypes.size();
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder{
        TextView productView;
        Spinner typeSpinner;
        TextView quantityTextView;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

            productView = itemView.findViewById(R.id.textView2);
            //quantitySpinner = itemView.findViewById(R.id.spinner2);
            typeSpinner = itemView.findViewById(R.id.spinner3);
            quantityTextView = itemView.findViewById(R.id.quantityTxt);

            itemView.findViewById(R.id.deductBtn).setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if(!quantityTextView.getText().toString().equals("0")){
                        int newQuantity = Integer.parseInt(quantityTextView.getText().toString()) - 1;
                        quantityTextView.setText(String.valueOf(newQuantity));
                    }

                }
            });




        }
    }
}
