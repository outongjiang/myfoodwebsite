package util;
import model.Food;

import java.lang.reflect.Method;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class myJavaBean {
    public static void setFields(Object object, Map<String,String[]> params) throws Exception {
        Class c=object.getClass();
        Method m=null;
        for(String key:params.keySet()){
            int flag=1;
            if(c.getDeclaredField(key).getType().toString().contains("Integer")) {
                System.out.println(c.getDeclaredField(key).getType().toString());
                m = c.getMethod("set" + key.replace(key.split("")[0],key.split("")[0].toUpperCase()), Integer.class);
            }else {
                m = c.getMethod("set" + key.replace(key.split("")[0],key.split("")[0].toUpperCase()), String.class);
                flag=2;
            }
            for(String value:params.get(key)) {
                if(flag==2) {
                    m.invoke(object, value);
                }else{
                    if("".equals(value))
                        continue;
                    m.invoke(object, Integer.valueOf(value));
                }
            }

        }
    }
    public static <T>List<T> Result_List(ResultSet rs, Class c,T t){
        List<Food> params=new ArrayList<>();
        Food food=null;
//        while (rs.next()){
//            food=new Food();
//            food.setId(rs.);
//        }
        return null;
//        JDBC.Close();
//        return params;
    }
}
