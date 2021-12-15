package dataAccessObject;

import model.Food;
import util.JDBC;
import util.myJavaBean;

import java.lang.reflect.InvocationTargetException;
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
        String sql = "select * from food";
        ResultSet rs = JDBC.select(sql, null);
        try {
            return myJavaBean.Result_List(rs, Food.class);
        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        }
        return null;
    }
}