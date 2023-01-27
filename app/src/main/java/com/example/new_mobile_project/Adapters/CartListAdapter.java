package com.example.new_mobile_project.Adapters;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.new_mobile_project.Models.ProductModel;
import com.example.new_mobile_project.R;

import java.util.ArrayList;

public class CartListAdapter extends RecyclerView.Adapter<CartListAdapter.CartViewHolder> {

    Integer total;
    ArrayList<ProductModel> cart;
    Context context;

    public CartListAdapter(ArrayList<ProductModel> cart, Context context) {
        this.cart = cart;
        this.context = context;
    }

    @NonNull
    @Override
    public CartViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.cartproducts_cardview,parent,false);
        return new CartViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CartViewHolder holder, int position) {

        holder.onBind(cart,position,context);
    }

    @Override
    public int getItemCount() {
        if(cart == null) return 0;
        return cart.size();
    }

    public class CartViewHolder extends RecyclerView.ViewHolder {
        TextView proname, prodesc, proprice, proquantity,totalcost;
        Button productplus, productminus;
        public CartViewHolder(@NonNull View itemView) {
            super(itemView);

            proname = itemView.findViewById(R.id.productname);
            prodesc = itemView.findViewById(R.id.productdescreption);
            proprice = itemView.findViewById(R.id.productprice);
            proquantity = itemView.findViewById(R.id.productquantity);
            totalcost = itemView.findViewById(R.id.costtxt);

            productplus= itemView.findViewById(R.id.productplus);
            productminus = itemView.findViewById(R.id.productminuse);
        }

        @SuppressLint("SetTextI18n")
        public void onBind(final ArrayList<ProductModel> cartList, final int position, final Context context){
            proname.setText(cartList.get(position).getName());
            prodesc.setText(cartList.get(position).getDescription());
            proprice.setText(cartList.get(position).getPrice() + " L.E.");
            proquantity.setText(""+cartList.get(position).getQuantity()+"");
            final int count=cartList.get(position).getQuantity();
            productplus.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Integer quantityplus = cartList.get(position).getQuantity();
                    if(quantityplus < count) {
                        quantityplus++;
                        cartList.get(position).setQuantity(quantityplus);
                        proquantity.setText(quantityplus + "");
                    }
                    else {
                        Toast.makeText(context,"The Maximum quantity of product is "+count,Toast.LENGTH_SHORT).show();
                    }

                }
            });

            productminus.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Integer quantityminus = cartList.get(position).getQuantity();
                    if(quantityminus > 1){
                        quantityminus--;
                        cartList.get(position).setQuantity(quantityminus);
                        proquantity.setText(quantityminus + "");
                    }
                    else
                        Toast.makeText(context,"The minimum quantity of product is 1",Toast.LENGTH_SHORT).show();

                }
            });
        }

    }
}
