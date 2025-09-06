package dev.rdiaz.MagicFridgeAi.mapper;

import dev.rdiaz.MagicFridgeAi.dto.FoodDTO;
import dev.rdiaz.MagicFridgeAi.model.FoodItem;
import org.springframework.stereotype.Component;

@Component
public class FoodMapper {

    public FoodItem map(FoodDTO foodDTO){

        FoodItem foodItem = new FoodItem();

        foodItem.setId(foodDTO.getId());
        foodItem.setNome(foodDTO.getNome());
        foodItem.setCategoria(foodDTO.getCategoria());
        foodItem.setQuantidade(foodDTO.getQuantidade());
        foodItem.setValidade(foodDTO.getValidade());

        return foodItem;
    }

    public FoodDTO map(FoodItem foodItem){

        FoodDTO foodDTO = new FoodDTO();

        foodDTO.setId(foodItem.getId());
        foodDTO.setNome(foodItem.getNome());
        foodDTO.setCategoria(foodItem.getCategoria());
        foodDTO.setQuantidade(foodItem.getQuantidade());
        foodDTO.setValidade(foodItem.getValidade());

        return foodDTO;
    }

}
