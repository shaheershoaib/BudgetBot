package com.example.budgetbot;

import android.annotation.SuppressLint;
import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class Item_RV_Adapter extends RecyclerView.Adapter<Item_RV_Adapter.MyViewHolder> {
    Context context;
    ArrayList<Item_model> item_models;
    LayoutInflater inflater;

    private AdapterCallback mAdapterCallback;

    public Item_RV_Adapter(Context context, ArrayList<Item_model> item_models){
        this.context = context;
        this.item_models = item_models;

        inflater = LayoutInflater.from(context);

        try {
            this.mAdapterCallback = ((AdapterCallback) context);
        } catch (ClassCastException e) {
            throw new ClassCastException("Activity must implement AdapterCallback.");
        }
    }

    @NonNull
    @Override
    public Item_RV_Adapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = inflater.inflate(R.layout.rview_row,parent,false);
        return new Item_RV_Adapter.MyViewHolder(view);
    }

    int[] count;
    int[] temp1;
    int[] temp3;
    int[] sum;
    boolean slice;
// TextView b;

    @Override
    public void onBindViewHolder(@NonNull Item_RV_Adapter.MyViewHolder holder, @SuppressLint("RecyclerView") int position) {

        holder.itemName.setText(item_models.get(position).getItemName());
        holder.itemPrice.setText(String.valueOf(item_models.get(position).getItemPrice()));
        holder.itemAmount.setText(String.valueOf(item_models.get(position).getItemAmount()));


        count = new int[5];
        for(int i =0; i<count.length;i++)
            count[i] = 1;
        temp1 = new int[5];
        temp3 = new int[5];
        sum = new int[5];
        slice = true;

        holder.plus_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(count[position]<=0)
                    count[position]=0;

                count[position]++;
                Log.d("341",""+position);
                holder.itemAmount.setText(Integer.toString(count[position]));

                temp1[position] = item_models.get(position).getItemPrice();
                Log.d("341",""+temp1[position]);

                temp3[position] = temp1[position] * count[position];
                Log.d("341",""+temp3[position]);

                holder.itemPrice.setText(String.valueOf(temp3[position]));

//                mAdapterCallback.onMethodCallback("Budget Remaining: $"+String.valueOf(temp3[position]));
                mAdapterCallback.onMethodCallback(String.valueOf(temp1[position]));
            }
        });

        //TO DO: send in negative value which will be added to budget remaining
        holder.minus_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                count[position]--;
                if(count[position]<=0){
                    holder.itemAmount.setText(Integer.toString(0));
                    holder.itemPrice.setText(Integer.toString(0));

                    Toast.makeText(context.getApplicationContext(),"Item will be deleted",Toast.LENGTH_SHORT).show();

                    if(slice) {
                        slice = false;
                        mAdapterCallback.onMethodCallback(String.valueOf(-item_models.get(position).getItemPrice()));
                    }

                }else {
                    Log.d("341", "" + position);
                    holder.itemAmount.setText(Integer.toString(count[position]));

                    temp1[position] = item_models.get(position).getItemPrice();
                    Log.d("341", "" + temp1[position]);

                    temp3[position] = temp1[position] * count[position];
                    Log.d("341", "" + temp3[position]);

                    holder.itemPrice.setText(String.valueOf(temp3[position]));

                    slice = true;
                    mAdapterCallback.onMethodCallback(String.valueOf(-temp1[position]));
//                  there is a problem with this: if go from 1 to 0 then budget is lost forever

//                    mAdapterCallback.onMethodCallback("Budget Remaining: $"+ String.valueOf(temp3[position]));
                }
            }
        });

    }

    public static interface AdapterCallback {
        void onMethodCallback(String yourValue);
    }

    @Override
    public int getItemCount() {
        return item_models.size();
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder{

        TextView itemName,itemPrice,itemAmount,budget_rem;
        Button plus_button;
        Button minus_button;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

            itemName = itemView.findViewById(R.id.itemName);
            itemPrice = itemView.findViewById(R.id.itemPrice);
            itemAmount = itemView.findViewById(R.id.itemCount);
            plus_button = itemView.findViewById(R.id.plus_button);
            minus_button = itemView.findViewById(R.id.minus_button);
        }
    }
}