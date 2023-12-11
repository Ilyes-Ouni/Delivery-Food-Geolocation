package com.ayoub.deliveryapp.view.activities;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.ayoub.deliveryapp.R;
import com.ayoub.deliveryapp.model.Address;
import com.ayoub.deliveryapp.model.Order;
import com.ayoub.deliveryapp.util.SharedPrefManager;
import com.ayoub.deliveryapp.view.adapters.AddressAdapter;
import com.ayoub.deliveryapp.view.adapters.OrderAdapter;
import com.ayoub.deliveryapp.viewmodel.UserViewModel;

import java.util.ArrayList;
import java.util.List;

public class MyOrdersActivity extends AppCompatActivity {
    ImageView back;
    Button addAddress;
    RecyclerView recyclerView;
    UserViewModel userViewModel;
    SharedPrefManager sharedPrefManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_orders);
        back = findViewById(R.id.back);

        recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(new AddressAdapter(new ArrayList<>()));

        userViewModel = new UserViewModel();
        sharedPrefManager = new SharedPrefManager(this);

        String userId = sharedPrefManager.getUser().getUserId();
        userViewModel.getUserOrders(userId).observe(this, new Observer<List<Order>>() {
            @Override
            public void onChanged(List<Order> orders) {
                OrderAdapter ordersAdapter = new OrderAdapter(orders);
                recyclerView.setAdapter(ordersAdapter);
            }
        });

        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }
}