package dataAccessObject;

import jdk.nashorn.internal.scripts.JD;
import model.Food;
import model.PageBean;
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
    public int findAllFood() throws SQLException {
        ResultSet rs=JDBC.select("select*from food",null);
        int sumPage=0;
        while (rs.next()){
            sumPage++;
        }
        return sumPage;
    }

    public PageBean findChooseFood(Map<String,Object>data, Integer currPage,int sumPage) throws SQLException {
        String baseSql= "select * from food where 1=1 ";
        int flag=0;
        int rows=-1;
        StringBuffer sql=new StringBuffer();
        sql.append(baseSql);
        List<Object>params=new ArrayList<>();
        PageBean pageBean=new PageBean();
        pageBean.setCount(5);
        System.out.println(Arrays.toString(data.keySet().toArray()));
        for(String k:data.keySet()){
            flag=1;
            if("price".equals(k)||"num".equals(k)){
                sql.append(" and "+k+" <= "+"?");
                params.add(data.get(k));
            }else{
                sql.append(" and "+k+" like "+"?");
                params.add("%"+data.get(k)+"%");
            }
        }
        if(flag==1){
            currPage=1;
            sumPage=0;
            ResultSet rs=JDBC.select(sql.toString(),params);
            while (rs.next())
                sumPage++;
        }
        sql.append(" limit ?,?");
        System.out.println(sql.toString());
        params.add((currPage-1)*pageBean.getCount());
        params.add(pageBean.getCount());
        ResultSet rs = JDBC.select(sql.toString(), params);
        try {
            List<Food>foods=myJavaBean.Result_List(rs, Food.class);
            pageBean.setFoods(foods);
            pageBean.setCurrPage(currPage);
            rows= sumPage/(pageBean.getCount()*1.0)==sumPage/pageBean.getCount()?sumPage/pageBean.getCount():sumPage/pageBean.getCount()+1;
            pageBean.setRows(rows);
            JDBC.Close();

            return pageBean;
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
