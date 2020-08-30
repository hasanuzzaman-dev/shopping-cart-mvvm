package com.hasan.shoppingcart.viewModels;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.hasan.shoppingcart.models.Product;
import com.hasan.shoppingcart.repositories.ShopRepo;

import java.util.List;

public class ShopViewModel  extends ViewModel {

    ShopRepo shopRepo = new ShopRepo();

    MutableLiveData<Product> productMutableLiveData = new MutableLiveData<>();

    public LiveData<List<Product>> getProducts(){
        return shopRepo.getProducts();
    }

    public void setProduct(Product product){
        productMutableLiveData.setValue(product);
    }

    //get product to product details fragment
    public LiveData<Product> getProduct(){
        return productMutableLiveData;
    }
}
