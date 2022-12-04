package com.example.budgetbot;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.io.FileOutputStream;
import java.util.ArrayList;

public class product_RecyclerViewAdapter extends RecyclerView.Adapter<product_RecyclerViewAdapter.MyViewHolder> {

    public void setFilteredList(ArrayList<product> filteredList){
        this.productList = filteredList;
        notifyDataSetChanged();
    }

     static Context context;
    ArrayList<product> productList;
    static Toast toast;
    public product_RecyclerViewAdapter(Context context, ArrayList<product> productList){
        this.context = context;
        this.productList = productList;
    }
    @NonNull
    @Override
    public product_RecyclerViewAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.recycler_view_row, parent, false);
        return new product_RecyclerViewAdapter.MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull product_RecyclerViewAdapter.MyViewHolder holder, int position) {
        holder.tvName.setText(productList.get(position).getProductName());
        holder.tvPrice.setText(String.valueOf(productList.get(position).getProductPrice()) + "$");
        holder.imageView.setImageResource(productList.get(position).productImage);
    }



    @Override
    public int getItemCount() {
        return productList.size();
    }
     public  static  class MyViewHolder extends RecyclerView.ViewHolder{

        ImageView imageView;
        TextView tvName, tvPrice;
         public MyViewHolder(@NonNull View itemView) {
             super(itemView);

             imageView = itemView.findViewById(R.id.imageView);
             tvName = itemView.findViewById(R.id.nameTextView);
             tvPrice = itemView.findViewById(R.id.priceTextView);

             itemView.findViewById(R.id.addToCartBtn).setOnClickListener(new View.OnClickListener() {
                 @Override
                 public void onClick(View view) {

                     String fileContents = tvName.getText()+", " + tvPrice.getText() + "\n";

                     String filename = "cart2.txt";

                     FileOutputStream outputStream;  //Allow a file to be opened for writing


                     try {
                         outputStream = context.openFileOutput(filename, Context.MODE_APPEND);
                         outputStream.write(fileContents.getBytes());    //FileOutputStream is meant for writing streams of raw bytes.
                         outputStream.close();
                         //Toast.makeText(context, "Item added successfully", Toast.LENGTH_LONG).show();

                     } catch (Exception e) {

                         e.printStackTrace();
                     }
                     Button addBtn = itemView.findViewById(R.id.addToCartBtn);

                     if(addBtn.getText().toString().toLowerCase().equals("add to cart")) {
                         if(toast!=null)
                             toast.cancel();
                         toast = Toast.makeText(context, "Item added successfully", Toast.LENGTH_SHORT);
                         toast.show();
                         addBtn.setText("Remove");
                     }

                     else{
                         if(toast!=null)
                             toast.cancel();
                         toast =  Toast.makeText(context, "Item removed successfully", Toast.LENGTH_SHORT);
                         toast.show();
                         addBtn.setText("add to cart");
                     }
                    //writeFileContent(fileContents, this);
                 }


             });


         }
     }

}
