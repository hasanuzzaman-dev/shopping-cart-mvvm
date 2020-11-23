package com.hasan.shoppingcart.repositories;

import android.util.Log;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.hasan.shoppingcart.models.CartItem;
import com.hasan.shoppingcart.models.Product;

import java.util.ArrayList;
import java.util.List;

public class CartRepo {

    private static final String TAG = "CartRepo";
    private MutableLiveData<List<CartItem>> mutableCart = new MutableLiveData<>();

    public LiveData<List<CartItem>> getCart() {
        if (mutableCart.getValue() == null) {
            initCart();
        }
        return mutableCart;
    }

    private void initCart() {
        mutableCart.setValue(new ArrayList<CartItem>());
    }

    public boolean addItemToCart(Product product) {
        if (mutableCart.getValue() == null) {
            initCart();
        }

        //Log.d(TAG, "addItemToCart: "+mutableCart.getValue());

        List<CartItem> cartItemList = new ArrayList<>(mutableCart.getValue());

        // if quantity is greater then 1
        for (CartItem cartItem : cartItemList) {
            if (cartItem.getProduct().getId().equals(product.getId())) {
                if (cartItem.getQuantity() == 5) {
                    return false;
                }

                int index = cartItemList.indexOf(cartItem);
                cartItem.setQuantity(cartItem.getQuantity() + 1);
                cartItemList.set(index,cartItem);

                mutableCart.setValue(cartItemList);

                return true;
            }
        }
        CartItem cartItem = new CartItem(product, 1);
        cartItemList.add(cartItem);
        mutableCart.setValue(cartItemList);

        return true;
    }

    public void removeItemFromCart(CartItem cartItem){
        if (mutableCart.getValue() == null){
            return;
        }

        List<CartItem> cartItemList = new ArrayList<>(mutableCart.getValue());
        cartItemList.remove(cartItem);
        mutableCart.setValue(cartItemList);
    }

    public void changeQuantity(CartItem cartItem, int quantity){

        if (mutableCart == null){
            return;
        }

        List<CartItem> cartItemList = new ArrayList<>(mutableCart.getValue());
        CartItem updatedCartItem = new CartItem(cartItem.getProduct(),quantity);
        cartItemList.set(cartItemList.indexOf(cartItem),updatedCartItem);

        mutableCart.setValue(cartItemList);

    }
}
