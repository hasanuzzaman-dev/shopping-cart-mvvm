package com.hasan.shoppingcart.views.fragments;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.DividerItemDecoration;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.hasan.shoppingcart.R;
import com.hasan.shoppingcart.adapters.CartListAdapter;
import com.hasan.shoppingcart.databinding.FragmentCartBinding;
import com.hasan.shoppingcart.models.CartItem;
import com.hasan.shoppingcart.viewModels.ShopViewModel;

import java.util.List;


public class CartFragment extends Fragment implements CartListAdapter.CartInterface {

    private static final String TAG = "CartFragment";
    private ShopViewModel shopViewModel;
    private FragmentCartBinding fragmentCartBinding;
    private NavController navController;



    public CartFragment() {
        // Required empty public constructor
    }



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        fragmentCartBinding =  FragmentCartBinding.inflate(inflater, container, false);
        return fragmentCartBinding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        navController = Navigation.findNavController(view);

        final CartListAdapter cartListAdapter = new CartListAdapter(this);

        fragmentCartBinding.cartRecyclerView.setAdapter(cartListAdapter);

        fragmentCartBinding.cartRecyclerView.addItemDecoration(new DividerItemDecoration(requireContext(),DividerItemDecoration.VERTICAL));

        shopViewModel = new ViewModelProvider(requireActivity()).get(ShopViewModel.class);
        shopViewModel.getCart().observe(getViewLifecycleOwner(), new Observer<List<CartItem>>() {
            @Override
            public void onChanged(List<CartItem> cartItems) {

                cartListAdapter.submitList(cartItems);

                // enable or disable button
                fragmentCartBinding.placeOrderButton.setEnabled(cartItems.size() > 0);
            }
        });

        shopViewModel.getTotalPrice().observe(getViewLifecycleOwner(), new Observer<Double>() {
            @Override
            public void onChanged(Double totalPrice) {
                fragmentCartBinding.orderTotalTextView.setText("Total: $"+totalPrice.toString());

            }
        });

        fragmentCartBinding.placeOrderButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                navController.navigate(R.id.action_cartFragment_to_orderFragment2);
            }
        });
    }

    @Override
    public void deleteItem(CartItem cartItem) {
        Log.d(TAG, "deleteItem: "+ cartItem.getProduct().getName());
        shopViewModel.removeItemFromCart(cartItem);
    }

    @Override
    public void changeQuantity(CartItem cartItem, int quantity) {

        shopViewModel.changeQuantity(cartItem,quantity);
    }
}