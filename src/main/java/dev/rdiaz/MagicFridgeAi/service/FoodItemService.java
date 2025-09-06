package dev.rdiaz.MagicFridgeAi.service;

import dev.rdiaz.MagicFridgeAi.repository.FoodItemRepository;

public class FoodItemService {

    FoodItemRepository foodItemRepository;

    public FoodItemService(FoodItemRepository foodItemRepository) {
        this.foodItemRepository = foodItemRepository;
    }


}
