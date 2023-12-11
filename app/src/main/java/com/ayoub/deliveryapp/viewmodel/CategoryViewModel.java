package com.ayoub.deliveryapp.viewmodel;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;

import com.ayoub.deliveryapp.model.Category;
import com.ayoub.deliveryapp.repository.CategoryRepository;
import com.ayoub.deliveryapp.repository.CategoryRepositoryImpl;

import java.util.List;

public class CategoryViewModel extends ViewModel {
    private CategoryRepository categoryRepository;
    private LiveData<List<Category>> categories;

    public CategoryViewModel() {
        categoryRepository = new CategoryRepositoryImpl();
        categories = categoryRepository.getCategories();
    }

    public LiveData<List<Category>> getCategories() {
        return categories;
    }
}
