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
//把前端页面获取到数据集映射到对象里面
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
    //把查询到结果集映射到对象集合里面
    public static <T>List<T> Result_List(ResultSet rs, Class c) throws SQLException, NoSuchFieldException, InvocationTargetException, IllegalAccessException, InstantiationException, NoSuchMethodException {
        List<T> params=new ArrayList<>();
        Object object=c.newInstance();
        Method m=null;
        int i=-1;
        while (rs.next()){
            object=new Food();
            i=1;
            for(Field field:c.getDeclaredFields()){
                if(field.getType().toString().contains("Integer")){
                    m=c.getDeclaredMethod("set"+field.getName().replace(field.getName().split("")[0],field.getName().split("")[0].toUpperCase()),Integer.class);
                    m.invoke(object,rs.getInt(i));
                }else{
                    m=c.getDeclaredMethod("set"+field.getName().replace(field.getName().split("")[0],field.getName().split("")[0].toUpperCase()),String.class);
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
