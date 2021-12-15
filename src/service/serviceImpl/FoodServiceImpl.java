package service.serviceImpl;

import dataAccessObject.FoodDao;
import model.Food;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class FoodServiceImpl implements FoodService{
    FoodDao foodDao=new FoodDao();
    @Override
    public void addFood(Food food) {
        List<Object>params=new ArrayList<>();
        params.add(food.getName());
        params.add(food.getPrice());
        params.add(food.getNum());
        foodDao.addFood(food,params);
    }

    @Override
    public List<Food> findFood() {
        try {
            return foodDao.findFood();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return null;
    }

    @Override
    public void updateFood(Food food) {
        List<Object>list=new ArrayList<>();
        list.add(food.getName());
        list.add(food.getPrice());
        list.add(food.getNum());
        list.add(food.getId());
        foodDao.updateFood(list);
    }
}
