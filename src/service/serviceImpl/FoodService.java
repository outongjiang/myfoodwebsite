package service.serviceImpl;

import model.Food;
import model.PageBean;

public interface FoodService {
    void addFood(Food food);

    PageBean findFood(Food food, Object[] keys, int i);

    void updateFood(Food food);

    void deleteFood(String[] id);
}
