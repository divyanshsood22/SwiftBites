package com.swiftbites.api.service;

import com.swiftbites.api.entity.FoodEntity;
import com.swiftbites.api.repository.FoodRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class FoodServiceImpl implements FoodService {

    private final FoodRepository foodRepository;

    @Override
    public FoodEntity addFood(FoodEntity food) {
        return foodRepository.save(food);
    }

    @Override
    public List<FoodEntity> getAllFoods() {
        return foodRepository.findAll();
    }

    @Override
    public FoodEntity getFoodById(Long id) {
        return foodRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Food not found"));
    }

    @Override
    public void deleteFood(Long id) {
        foodRepository.deleteById(id);
    }
}