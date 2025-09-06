package dev.rdiaz.MagicFridgeAi.repository;

import dev.rdiaz.MagicFridgeAi.model.FoodItem;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FoodItemRepository extends JpaRepository<FoodItem,Long> {
}
