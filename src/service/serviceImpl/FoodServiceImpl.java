package service.serviceImpl;

import dataAccessObject.FoodDao;
import model.Food;

import java.util.ArrayList;
import java.util.List;

public class FoodServiceImpl implements FoodService{

    @Override
    public void addFood(Food food) {
        FoodDao foodDao=new FoodDao();
        List<Object>params=new ArrayList<>();
        params.add(food.getName());
        params.add(food.getPrice());
        params.add(food.getNum());
        foodDao.addFood(food,params);
    }
}
