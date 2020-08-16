package com.hasan.shoppingcart.views.activity;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.NavigationUI;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import com.hasan.shoppingcart.R;

public class MainActivity extends AppCompatActivity {

    private NavController navController;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        navController = Navigation.findNavController(this,R.id.nav_host_fragment);
        NavigationUI.setupActionBarWithNavController(this,navController);

    }

    // Handle back Btn
    @Override
    public boolean onSupportNavigateUp() {
        navController.navigateUp();
        return super.onSupportNavigateUp();
    }

    // Add Item Menu
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main_menu,menu);
        return true;
    }

    // Item Menu clickable
    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        /*
        NavigationUI.onNavDestinationSelected(item,navController);
        return super.onOptionsItemSelected(item);*/

        // Or
        return NavigationUI.onNavDestinationSelected(item,navController) || super.onOptionsItemSelected(item);

    }
}