package dev.rdiaz.MagicFridgeAi.controller;

import dev.rdiaz.MagicFridgeAi.dto.FoodDTO;
import dev.rdiaz.MagicFridgeAi.service.FoodItemService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/food")
public class FoodItemController {

    FoodItemService foodItemService;

    public FoodItemController(FoodItemService foodItemService) {
        this.foodItemService = foodItemService;
    }

    //POST
    @PostMapping("/criar")
    public ResponseEntity<String> criar(@RequestBody FoodDTO foodDTO) {
        foodItemService.inserir(foodDTO);

        return ResponseEntity.status(HttpStatus.CREATED)
                .body("O ingrediente " + foodDTO.getNome() + " foi inserido com sucesso");
    }

    //GET
    @GetMapping("/listar")
    public ResponseEntity<List<FoodDTO>> listarIngredientes() {
        List<FoodDTO> listaCompleta = foodItemService.listar();

        return ResponseEntity.ok(listaCompleta);
    }

    //GETbyID
    @GetMapping("/listar/{id}")
    public ResponseEntity<?> listarPorId(@PathVariable long id) {

        FoodDTO itemProcurado = foodItemService.listarPorId(id);

        if (itemProcurado != null) {
            return ResponseEntity.status(HttpStatus.FOUND)
                    .body("O item " + itemProcurado.getNome() + " está na lista");

        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND)
                .body("O item procurado não está na lista");
    }

    //UPDATE
    @PutMapping("/atualizar/{id}")
    public ResponseEntity<?> alterar(@RequestBody FoodDTO foodDTO, @PathVariable long id) {

        FoodDTO item = foodItemService.alterarPorId(foodDTO, id);

        if (item != null) {
            return ResponseEntity.ok("O item com id:" + id + " foi alterado com sucesso");
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND)
                .body("O item procurado para alterar não existe");
    }

    //DELETE
    @DeleteMapping("/deletar/{id}")
    public ResponseEntity<String> deletar(@PathVariable long id) {

        FoodDTO item = foodItemService.listarPorId(id);

        if (item != null) {
            foodItemService.deletarItem(id);
            return ResponseEntity.ok("Item removido com sucesso!");
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND)
                .body("O item buscado para remoção não se encontra nos registros");
    }

}
