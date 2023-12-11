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
import com.ayoub.deliveryapp.util.SharedPrefManager;
import com.ayoub.deliveryapp.view.adapters.AddressAdapter;
import com.ayoub.deliveryapp.viewmodel.UserViewModel;

import java.util.ArrayList;
import java.util.List;

public class MyAddressActivity extends AppCompatActivity {
    ImageView back;
    Button addAddress;
    RecyclerView recyclerView;
    UserViewModel userViewModel;
    SharedPrefManager sharedPrefManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_address);
        back = findViewById(R.id.back);
        addAddress = findViewById(R.id.addAddress);
        recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(new AddressAdapter(new ArrayList<>()));

        userViewModel = new UserViewModel();
        sharedPrefManager = new SharedPrefManager(this);

        String userId = sharedPrefManager.getUser().getUserId();
        userViewModel.getUserAddresses(userId).observe(this, new Observer<List<Address>>() {
            @Override
            public void onChanged(List<Address> addresses) {
                AddressAdapter addressAdapter = new AddressAdapter(addresses);
                recyclerView.setAdapter(addressAdapter);
            }
        });

        addAddress.setOnClickListener(v -> {
            Intent intent = new Intent(MyAddressActivity.this, AddAddressActivity.class);
            startActivity(intent);
        });
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }
}