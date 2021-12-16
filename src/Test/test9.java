package Test;

import java.util.ArrayList;
import java.util.List;

public class test9 {
    public static void main(String[] args) {
        List<Object> list=new ArrayList<Object>();
        list.add(120);
//        list.add(144);
//        list.add(75);
//        list.add(60);
        StringBuffer sql=new StringBuffer("delete from food where id=?");
        if(list.size()!=1) {
            for (int i = 1; i < list.size(); i++) {
                sql.append(" or id=? ");
            }
        }
        System.out.println(sql.toString());
    }
}
