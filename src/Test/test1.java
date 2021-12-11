package Test;

import util.JDBC;

import java.sql.ResultSet;
import java.sql.SQLException;

public class test1 {
    public static void main(String[] args) {
        ResultSet rs=JDBC.select("select*from myfood",null);
        int i=1;
        while(true){
            try {
                if (!rs.next()) break;
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
            try {
                System.out.println(rs.getArray(i));
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
            i++;
        }


    }
}
