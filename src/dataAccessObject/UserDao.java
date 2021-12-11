package dataAccessObject;

import util.JDBC;

import java.sql.ResultSet;
import java.util.List;

public class UserDao {
    //查询数据
    public  ResultSet select(String sql, List<Object> params){
        return JDBC.select(sql,params);
    }
    //插入数据
    public  int insert(String sql, List<Object> params){
        return JDBC.update(sql,params);
    }
    //更新数据
    public  int update(String sql, List<Object> params){
        return JDBC.update(sql,params);
    }
    //删除数据
    public   int delete(String sql, List<Object> params){
        return JDBC.update(sql,params);
    }
}
