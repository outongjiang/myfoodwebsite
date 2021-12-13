package dataAccessObject;

import model.Food;
import util.JDBC;

import java.util.List;

public class FoodDao {
    public void addFood(Food food, List<Object> params) {
        String sql="insert into food values(null,?,?,?)";
        JDBC.update(sql,params);
        JDBC.Close();
    }
}
