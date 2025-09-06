package dev.rdiaz.MagicFridgeAi.service;

import dev.rdiaz.MagicFridgeAi.dto.FoodDTO;
import dev.rdiaz.MagicFridgeAi.mapper.FoodMapper;
import dev.rdiaz.MagicFridgeAi.model.FoodItem;
import dev.rdiaz.MagicFridgeAi.repository.FoodItemRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class FoodItemService {

    FoodItemRepository foodItemRepository;
    FoodMapper foodMapper;


    public FoodItemService(FoodItemRepository foodItemRepository, FoodMapper foodMapper) {
        this.foodItemRepository = foodItemRepository;
        this.foodMapper = foodMapper;
    }

    //Post inserir item
    public FoodDTO inserir(FoodDTO foodDTO) {
        FoodItem ingrediente = foodMapper.map(foodDTO);
        foodItemRepository.save(ingrediente);
        return foodMapper.map(ingrediente);
    }

    //Get listar todos itens
    public List<FoodDTO> listar() {
        List<FoodItem> listaDeComida = foodItemRepository.findAll();

        return listaDeComida.stream()
                .map(foodMapper::map)
                .collect(Collectors.toList());
    }

    //GetID listar por ID
    public FoodDTO listarPorId(long id) {

        Optional<FoodItem> ingredienteID = foodItemRepository.findById(id);
        return ingredienteID.map(foodMapper::map).orElse(null);
    }

    //Put alterar item
    public FoodDTO alterarPorId(FoodDTO foodDTO, long id) {

        Optional<FoodItem> itemExistente = Optional.of(foodItemRepository.getReferenceById(id));

        if (itemExistente.isPresent()) {
            FoodItem itemAtualizado = new FoodItem();
            itemAtualizado.setId(id);
            FoodItem itemSalvo = foodItemRepository.save(itemAtualizado);

            return foodMapper.map(itemSalvo);
        }
        return null;
    }


    //Delete deletar item
    public void deletarItem(long id) {
        Optional<FoodItem> ingredienteID = foodItemRepository.findById(id);

        if (ingredienteID.isPresent()) {
            foodItemRepository.deleteById(id);
        }
    }
}