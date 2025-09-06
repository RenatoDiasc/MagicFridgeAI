package dev.rdiaz.MagicFridgeAi.controller;

import dev.rdiaz.MagicFridgeAi.service.FoodItemService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/food")
public class FoodItemController {

    FoodItemService foodItemService;

    public FoodItemController(FoodItemService foodItemService) {
        this.foodItemService = foodItemService;
    }

    //POST

    //GET

    //UPDATE

    //DELETE

}
