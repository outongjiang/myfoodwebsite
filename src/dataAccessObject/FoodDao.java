package dataAccessObject;

import model.Food;
import util.JDBC;
import util.myJavaBean;

import java.lang.reflect.InvocationTargetException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

public class FoodDao {
    public void addFood(Food food, List<Object> params) {
        String sql="insert into food values(null,?,?,?,'1')";
        JDBC.update(sql,params);

    }

    public List<Food> findFood(Map<String,Object>data) throws SQLException {
        String baseSql= "select * from food where 1=1 ";
        StringBuffer sql=new StringBuffer();
        sql.append(baseSql);
        List<Object>params=new ArrayList<>();
        System.out.println(Arrays.toString(data.keySet().toArray()));
        for(String k:data.keySet()){
            sql.append(" and "+k+" like "+"?");
            params.add("%"+data.get(k)+"%");
        }

        ResultSet rs = JDBC.select(sql.toString(), params);
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

    public void updateFood(List<Object>list) {
        String sql="update food set name=?,price=?,num=? where id=?";
        if(list.size()==2)
            sql="update food set status=? where id=?";
        JDBC.update(sql,list);

    }

    public void deleteFood(List<Object> params) {
        StringBuffer sql=new StringBuffer("delete from food where id=?");
        if(params.size()!=1) {
            for (int i = 1; i < params.size(); i++) {
                sql.append(" or id=? ");
            }
        }
        JDBC.update(sql.toString(),params);
    }
}
