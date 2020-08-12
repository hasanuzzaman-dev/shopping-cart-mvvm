package com.hasan.shoppingcart.viewModels;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;

import com.hasan.shoppingcart.models.Product;
import com.hasan.shoppingcart.repositories.ShopRepo;

import java.util.List;

public class ShopViewModel  extends ViewModel {

    ShopRepo shopRepo = new ShopRepo();

    public LiveData<List<Product>> getProducts(){
        return shopRepo.getProducts();
    }
}
