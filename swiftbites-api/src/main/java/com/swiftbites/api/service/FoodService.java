package com.swiftbites.api.service;

import com.swiftbites.api.entity.FoodEntity;
import java.util.List;

public interface FoodService {

    FoodEntity addFood(FoodEntity food);

    List<FoodEntity> getAllFoods();

    FoodEntity getFoodById(Long id);

    void deleteFood(Long id);
}