package com.hasan.shoppingcart.views.fragments;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.hasan.shoppingcart.R;
import com.hasan.shoppingcart.databinding.FragmentProductDetailsBinding;
import com.hasan.shoppingcart.viewModels.ShopViewModel;


public class ProductDetailsFragment extends Fragment {

    private FragmentProductDetailsBinding fragmentProductDetailsBinding;
    private ShopViewModel shopViewModel;



    public ProductDetailsFragment() {
        // Required empty public constructor
    }



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
       fragmentProductDetailsBinding = FragmentProductDetailsBinding.inflate(inflater,container,false);
       return fragmentProductDetailsBinding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        shopViewModel = new ViewModelProvider(requireActivity()).get(ShopViewModel.class);
        fragmentProductDetailsBinding.setShopViewModel(shopViewModel);
    }
}