package dataAccessObject;

import model.Food;
import util.JDBC;
import util.myJavaBean;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class FoodDao {
    public void addFood(Food food, List<Object> params) {
        String sql="insert into food values(null,?,?,?)";
        JDBC.update(sql,params);
        JDBC.Close();
    }

    public List<Food> findFood() throws SQLException {
        String sql="select * from food";
        ResultSet rs=JDBC.select(sql,null);
//        return myJavaBean.Result_List(rs,Food.class,new Food());
        return null;
    }
}
