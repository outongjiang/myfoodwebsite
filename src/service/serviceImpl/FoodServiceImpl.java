package service.serviceImpl;

import dataAccessObject.FoodDao;
import model.Food;
import util.JDBC;
import util.myJavaBean;

import java.sql.SQLException;
import java.util.*;

public class FoodServiceImpl implements FoodService{
    FoodDao foodDao=new FoodDao();
    @Override
    public void addFood(Food food) {
        List<Object>params=new ArrayList<>();
        params.add(food.getName());
        params.add(food.getPrice());
        params.add(food.getNum());
        foodDao.addFood(food,params);
        JDBC.Close();
    }

    @Override
    public List<Food> findFood(Food food,Object[] keys) {
        System.out.println(Arrays.toString(keys));
        Map<String,Object>data= new HashMap<>();
        if(!"".equals(food.getName())&&food.getName()!=null)
        data.put(String.valueOf(keys[0]),food.getName());
        if(food.getPrice()!=null)
            data.put(String.valueOf(keys[1]),food.getPrice());
        if(food.getNum()!=null)
            data.put(String.valueOf(keys[2]),food.getNum());
        try {
            return foodDao.findFood(data);
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
        JDBC.Close();
    }

    @Override
    public void deleteFood(String []ids) {
        List<Object>params=new ArrayList<Object>();
        for(String id:ids){
            params.add(Integer.valueOf(id));
        };
        foodDao.deleteFood(params);
        JDBC.Close();
    }
}
