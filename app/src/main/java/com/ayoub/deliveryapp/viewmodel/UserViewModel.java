package com.ayoub.deliveryapp.viewmodel;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;

import com.ayoub.deliveryapp.model.Address;
import com.ayoub.deliveryapp.model.Order;
import com.ayoub.deliveryapp.model.User;
import com.ayoub.deliveryapp.repository.UserRepository;
import com.ayoub.deliveryapp.repository.UserRepositoryImpl;

import java.util.List;

public class UserViewModel extends ViewModel {
    private UserRepository userRepository;

    public UserViewModel() {
        userRepository = new UserRepositoryImpl();
    }

    public LiveData<User> loginUser(String email, String password) {
        return userRepository.loginUser(email, password);
    }

    public LiveData<User> registerUser(User user) {
        return userRepository.registerUser(user);
    }


    public void logoutUser() {
        userRepository.logoutUser();
    }

    public void addAddress(String userId, Address address) {
        userRepository.addAddress(userId, address);
    }
    public LiveData<List<Address>> getUserAddresses(String userId) {
        return userRepository.getUserAddresses(userId);
    }

    public void addOrder(String userId, Order order) {
        userRepository.addOrder(userId, order);
    }

    public LiveData<List<Order>> getUserOrders(String userId) {
        return userRepository.getUserOrders(userId);
    }
}