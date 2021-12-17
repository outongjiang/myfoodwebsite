package service.serviceImpl;

import model.Food;

import java.util.List;

public interface FoodService {
    void addFood(Food food);

    List<Food> findFood(Food food,Object keys[]);

    void updateFood(Food food);

    void deleteFood(String[] id);
}
