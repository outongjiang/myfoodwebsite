package Test;

import util.JDBC;

import java.sql.ResultSet;
import java.sql.SQLException;

public class test1 {
    public static void main(String[] args) throws SQLException {
        ResultSet rs=JDBC.select("select*from user ",null);
        int i=1;
        while (rs.next()){
            System.out.println(rs.getString(2));
        }
        JDBC.Close();

    }
}
