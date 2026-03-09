package com.swiftbites.api.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.swiftbites.api.entity.FoodEntity;
import com.swiftbites.api.service.FoodService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.io.File;
import java.nio.file.Path;

@RestController
@RequestMapping("/api/foods")
@AllArgsConstructor
@CrossOrigin("*")
public class FoodController {

    private final FoodService foodService;

    @PostMapping
    public FoodEntity addFood(
            @RequestParam("food") String foodJson,
            @RequestParam("file") MultipartFile file) throws Exception {

        ObjectMapper mapper = new ObjectMapper();
        FoodEntity food = mapper.readValue(foodJson, FoodEntity.class);

        String uploadDir = "src/main/resources/static/images/";
        File uploadFolder = new File(uploadDir);

        if (!uploadFolder.exists()) {
            uploadFolder.mkdirs();
        }

        String fileName = file.getOriginalFilename();
        Path filePath = Paths.get(uploadDir + fileName);

        Files.write(filePath, file.getBytes());

        food.setImageUrl(fileName);

        return foodService.addFood(food);
    }

    @GetMapping
    public List<FoodEntity> getFoods() {
        return foodService.getAllFoods();
    }

    @GetMapping("/{id}")
    public FoodEntity getFood(@PathVariable Long id) {
        return foodService.getFoodById(id);
    }

    @DeleteMapping("/{id}")
    public void deleteFood(@PathVariable Long id) {
        foodService.deleteFood(id);
    }
}