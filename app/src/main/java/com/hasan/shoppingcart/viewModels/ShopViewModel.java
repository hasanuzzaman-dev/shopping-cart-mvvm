package com.hasan.shoppingcart.viewModels;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.hasan.shoppingcart.models.CartItem;
import com.hasan.shoppingcart.models.Product;
import com.hasan.shoppingcart.repositories.CartRepo;
import com.hasan.shoppingcart.repositories.ShopRepo;

import java.util.List;

public class ShopViewModel  extends ViewModel {

    ShopRepo shopRepo = new ShopRepo();
    CartRepo cartRepo = new CartRepo();

    MutableLiveData<Product> productMutableLiveData = new MutableLiveData<>();

    //observe live data from ShopRepo
    public LiveData<List<Product>> getProducts(){
        return shopRepo.getProducts();
    }

    public void setProduct(Product product){
        productMutableLiveData.setValue(product);
    }

    //get product for product details fragment
    public LiveData<Product> getProduct(){
        return productMutableLiveData;
    }

    //observe live data from CartRepo
    public LiveData<List<CartItem>> getCart(){
        return cartRepo.getCart();
    }

    //observe live data from CartRepo addProductToCart
    public boolean addItemToCart(Product product){
        return cartRepo.addItemToCart(product);
    }

    public void removeItemFromCart(CartItem cartItem){
        cartRepo.removeItemFromCart(cartItem);
    }


}
