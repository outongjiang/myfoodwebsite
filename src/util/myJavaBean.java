package util;
import model.Food;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.sql.ResultSet;
import java.sql.SQLException;
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
    public static <T>List<T> Result_List(ResultSet rs, Class c) throws SQLException, NoSuchFieldException, InvocationTargetException, IllegalAccessException, InstantiationException {
        List<T> params=new ArrayList<>();
        Object object=c.newInstance();
        int i=-1;
        while (rs.next()){
            object=new Food();
            i=1;
            for(Method m:c.getDeclaredMethods()){
                if(!m.getName().contains("set"))
                    continue;
                Field field=c.getField(m.getName().split("set")[1].toLowerCase());
                if(field.getType().toString().contains("Integer")){
                    m.invoke(object,rs.getInt(i));
                }else{
                    m.invoke(object,rs.getString(i));
                }
                i++;
            }
            params.add((T)object);
        }
            JDBC.Close();
            return params;
    }
}
