package dev.rdiaz.MagicFridgeAi.controller;

import dev.rdiaz.MagicFridgeAi.dto.FoodDTO;
import dev.rdiaz.MagicFridgeAi.model.FoodItem;
import dev.rdiaz.MagicFridgeAi.service.ChatGptService;
import dev.rdiaz.MagicFridgeAi.service.FoodItemService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

import java.util.List;

@RestController
public class RecipeController {

    private FoodItemService foodItemService;
    ChatGptService chatGptService;

    public RecipeController(FoodItemService foodItemService, ChatGptService chatGptService) {
        this.foodItemService = foodItemService;
        this.chatGptService = chatGptService;
    }

    @GetMapping("/generate")
    public Mono<ResponseEntity<String>> generateRecipe(){
    List<FoodDTO> foodItems = foodItemService.listar();
        return chatGptService.generateRecipe(foodItems)
                .map(recipe -> ResponseEntity.ok(recipe))
                .defaultIfEmpty(ResponseEntity.noContent().build());
    }

}
