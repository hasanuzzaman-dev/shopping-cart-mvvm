package com.hasan.shoppingcart.repositories;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.hasan.shoppingcart.models.Product;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

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

        //Here you use retrofit or room
        productList.add(new Product(
                UUID.randomUUID().toString(),
                "iMac 21",
                1229,
                true,
                "https://alohaishoppe.com.bd/image/cache/MacBook/iMac/imac-21-cto-hero-201903-800x800.jpeg")
        );

        productList.add(new Product(
                UUID.randomUUID().toString(),
                "iPad Air",
                799,
                true,
                "https://images-na.ssl-images-amazon.com/images/I/61z85f1XsgL._AC_SL1500_.jpg")
        );
        productList.add(new Product(
                UUID.randomUUID().toString(),
                "iPad Pro",
                699,
                true,
                "https://store.storeimages.cdn-apple.com/4982/as-images.apple.com/is/ipad-pro-12-select-wifi-spacegray-202003_FMT_WHH?wid=940&hei=1112&fmt=png-alpha&qlt=80&.v=1583553704156")
        );
        productList.add(new Product(
                UUID.randomUUID().toString(),
                "iPhone 11",
                250,
                true,
                "https://www.gizmochina.com/wp-content/uploads/2019/09/Apple-iPhone-11-1-500x500.jpg")
        );
        productList.add(new Product(
                UUID.randomUUID().toString(),
                "iPhone SE",
                349,
                false,
                "https://store.storeimages.cdn-apple.com/4982/as-images.apple.com/is/iphone-se-white-select-2020?wid=940&hei=1112&fmt=png-alpha&qlt=80&.v=1586574259457")
        );
        productList.add(new Product(
                UUID.randomUUID().toString(),
                "MacBook Pro 13",
                899,
                true,
                "https://diamu.com.bd/wp-content/uploads/2020/03/Apple-MacBook-Pro-13-inch.jpg")
        );
        productList.add(new Product(
                UUID.randomUUID().toString(),
                "MacBook Pro 16",
                749,
                true,
                "data:image/jpeg;base64,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")
        );

        mutableProductList.setValue(productList);
    }
}
