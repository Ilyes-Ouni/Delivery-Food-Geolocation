package com.ayoub.deliveryapp.viewmodel;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;

import com.ayoub.deliveryapp.model.Category;
import com.ayoub.deliveryapp.model.Restaurant;
import com.ayoub.deliveryapp.repository.CategoryRepository;
import com.ayoub.deliveryapp.repository.CategoryRepositoryImpl;
import com.ayoub.deliveryapp.repository.RestaurantRepository;
import com.ayoub.deliveryapp.repository.RestaurantRepositoryImpl;

import java.util.List;

public class RestaurantViewModel extends ViewModel {

    private final RestaurantRepository restaurantRepository;
    private LiveData<List<Restaurant>> restaurants;
    private LiveData<Restaurant> restaurant;

    public RestaurantViewModel() {
        restaurantRepository = new RestaurantRepositoryImpl();
        refreshRestaurants();
    }

    public LiveData<List<Restaurant>> getRestaurants() {
        if (restaurants == null) {
            refreshRestaurants();
        }
        return restaurants;
    }

    public LiveData<List<Restaurant>> getRestaurantsLiveData() {
        if (restaurants == null) {
            refreshRestaurants(); // Ensure LiveData is initialized
        }
        return restaurants;
    }

    public LiveData<Restaurant> getRestaurant(String id) {
        if (restaurant == null) {
            restaurant = restaurantRepository.getRestaurantById(id);
        }
        return restaurant;
    }

    private void refreshRestaurants() {
        restaurants = restaurantRepository.getRestaurants();
    }
}
