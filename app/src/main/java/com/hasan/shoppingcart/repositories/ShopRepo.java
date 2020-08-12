package com.hasan.shoppingcart.repositories;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.hasan.shoppingcart.models.Product;

import java.util.ArrayList;
import java.util.List;

public class ShopRepo {

    private MutableLiveData<List<Product>> mutableProductList;

    public LiveData<List<Product>> getProducts(){
        if (mutableProductList == null){
            mutableProductList = new MutableLiveData<>();
            loadProducts();
        }

        return mutableProductList;
    }

    private void loadProducts() {
        List<Product> productList = new ArrayList<>();

        //Here you use retrofit or room DB

        mutableProductList.setValue(productList);
    }
}
