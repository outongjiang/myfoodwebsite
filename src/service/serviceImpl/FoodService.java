package service.serviceImpl;

import model.Food;

import java.util.List;

public interface FoodService {
    void addFood(Food food);

    List<Food> findFood();

    void updateFood(Food food);

    void deleteFood(String id);
}
