package com.hasan.shoppingcart.views.fragments;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.hasan.shoppingcart.R;
import com.hasan.shoppingcart.databinding.FragmentOrderBinding;
import com.hasan.shoppingcart.viewModels.ShopViewModel;


public class OrderFragment extends Fragment {

    NavController navController;
    private FragmentOrderBinding fragmentOrderBinding;
    private ShopViewModel shopViewModel;



    public OrderFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        //return inflater.inflate(R.layout.fragment_order, container, false);
        fragmentOrderBinding = FragmentOrderBinding.inflate(inflater,container,false);
        return fragmentOrderBinding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        navController = Navigation.findNavController(view);
        shopViewModel = new ViewModelProvider(requireActivity()).get(ShopViewModel.class);

        fragmentOrderBinding.continueShoppingBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                shopViewModel.resetCart();
                navController.navigate(R.id.action_orderFragment_to_shopFragment);
            }
        });

    }
}