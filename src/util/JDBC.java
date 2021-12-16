package util;
import com.alibaba.druid.pool.DruidDataSourceFactory;
import javax.sql.DataSource;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Properties;
public abstract class JDBC {
    private static DataSource ds=null;
    private static Connection conn=null;
    private static PreparedStatement prestate=null;
    static {
        Properties properties=new Properties();
        try {
            properties.load(JDBC.class.getClassLoader().getResourceAsStream("./druid.properties"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            ds=DruidDataSourceFactory.createDataSource(properties);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public static Connection getConnection(){
        try {
            return ds.getConnection();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return null;
    }
    public static ResultSet select(String sql, List<Object> params){
        conn=getConnection();
        ResultSet rs=null;
        try {
            prestate=conn.prepareStatement(sql);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        if(params!=null){
            for(int i=0;i<params.size();i++){
                try {
                    prestate.setObject(i+1,params.get(i));
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }
            }
        }
        try {
            rs= prestate.executeQuery();
            return rs;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        try {
            throw new Exception("JDBC查询出现错误！！！");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
    public static int update(String sql, List<Object> params){
        conn=getConnection();
        int j=-1;
        try {
            prestate=conn.prepareStatement(sql);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        if(params!=null){
            for(int i=0;i<params.size();i++){
                try {
                    prestate.setObject(i+1,params.get(i));
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }
            }
        }
        try {
            j= prestate.executeUpdate();
            return j;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        try {
            throw new Exception("JDBC更新出现错误！！！");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return -1;
    }

    public static void Close(){
        if(prestate!=null){
            try {
                prestate.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
        if(conn!=null){
            try {
                conn.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
    }
}
