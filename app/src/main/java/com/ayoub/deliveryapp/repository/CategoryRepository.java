package com.ayoub.deliveryapp.repository;

import androidx.lifecycle.LiveData;
import com.ayoub.deliveryapp.model.Category;
import java.util.List;

public interface CategoryRepository {
    LiveData<List<Category>> getCategories();
}
