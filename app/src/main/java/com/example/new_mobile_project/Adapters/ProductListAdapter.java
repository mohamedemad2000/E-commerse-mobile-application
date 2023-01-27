package com.example.new_mobile_project.Adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.new_mobile_project.Database.EcommerceDatabase;
import com.example.new_mobile_project.Models.ProductModel;
import com.example.new_mobile_project.R;

import java.util.ArrayList;

public class ProductListAdapter extends RecyclerView.Adapter<ProductListAdapter.ProductViewHolder> {

    EcommerceDatabase database;
    ArrayList<ProductModel> products;
    Context context;
    public ProductListAdapter(ArrayList<ProductModel> list1,Context context){
        this.products = list1;
        this.context = context;
    }
    @NonNull
    @Override
    public ProductViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.product_cardview,parent,false);
        return new ProductViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ProductViewHolder holder, int position) {
        holder.onBind(products,position,context);

    }

    @Override
    public int getItemCount() {
        if(products == null) return 0;
        return products.size();
    }

    public class ProductViewHolder extends RecyclerView.ViewHolder {
        TextView proname,proprice,prodescription;
        Button addtocart;
        public ProductViewHolder(@NonNull View itemView) {
            super(itemView);
            proname = itemView.findViewById(R.id.productname);
            proprice = itemView.findViewById(R.id.productprice);
            prodescription = itemView.findViewById(R.id.productdescreption);
            addtocart = itemView.findViewById(R.id.cartbtn);
        }

        public void onBind(final ArrayList<ProductModel> prodName, final int position, final Context context){
            proname.setText(prodName.get(position).getName());
            proprice.setText(prodName.get(position).getPrice()+" L.E.");
            prodescription.setText(prodName.get(position).getDescription());

            database = new EcommerceDatabase(context);
            addtocart.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                        ProductModel cartproducts = new ProductModel(prodName.get(position).getId(),prodName.get(position).getName(),
                                prodName.get(position).getPrice(),prodName.get(position).getDescription(),prodName.get(position).getQuantity());
                        database.cartProducts(cartproducts);
                        database.chartProducts(cartproducts);
                        prodName.get(position).setAddedtocart(true);
                        Toast.makeText(context,prodName.get(position).getName()+" Added to cart",Toast.LENGTH_SHORT).show();

                }
            });
        }
    }
}
