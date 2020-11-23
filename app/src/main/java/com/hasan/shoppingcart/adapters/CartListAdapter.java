package com.hasan.shoppingcart.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.ListAdapter;
import androidx.recyclerview.widget.RecyclerView;

import com.hasan.shoppingcart.databinding.CartRowBinding;
import com.hasan.shoppingcart.models.CartItem;

public class CartListAdapter extends ListAdapter<CartItem, CartListAdapter.CartViewHolder> {

    private CartInterface cartInterface;


    public CartListAdapter(CartInterface cartInterface) {
        super(CartItem.itemCallback);
        this.cartInterface = cartInterface;
    }

    @NonNull
    @Override
    public CartViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        CartRowBinding cartRowBinding = CartRowBinding.inflate(layoutInflater, parent, false);

        return new CartViewHolder(cartRowBinding);
    }

    @Override
    public void onBindViewHolder(@NonNull CartViewHolder holder, int position) {

        CartItem cartItem = getItem(position);
        holder.cartRowBinding.setCartItem(cartItem);
        holder.cartRowBinding.executePendingBindings();

    }

    public class CartViewHolder extends RecyclerView.ViewHolder {

        CartRowBinding cartRowBinding;

        public CartViewHolder(@NonNull CartRowBinding cartRowBinding) {
            super(cartRowBinding.getRoot());
            this.cartRowBinding = cartRowBinding;

            cartRowBinding.deleteProductButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    cartInterface.deleteItem(getItem(getAdapterPosition()));
                }
            });

            cartRowBinding.quantitySpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                @Override
                public void onItemSelected(AdapterView<?> adapterView, View view, int position, long id) {
                    int quantity = position + 1;
                    if (quantity == getItem(getAdapterPosition()).getQuantity()){
                        return;
                    }

                    cartInterface.changeQuantity(getItem(getAdapterPosition()), quantity);

                }

                @Override
                public void onNothingSelected(AdapterView<?> adapterView) {

                }
            });
        }
    }

    public interface CartInterface{
        void deleteItem(CartItem cartItem);
        void changeQuantity(CartItem cartItem, int quantity);
    }
}
