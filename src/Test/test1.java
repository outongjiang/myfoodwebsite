package Test;
import com.sun.corba.se.spi.ior.ObjectKey;
import util.JDBC;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

class student{
    String name;
    int age;

    @Override
    public String toString() {
        return "student{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", phone='" + phone + '\'' +
                '}';
    }

    String phone;
    public void getAge(){
        System.out.println(30);
    }
    public void getName(){
        System.out.println("张三");
    }
}
public class test1 {
    public static void invoke(String methodName) throws Exception {
        Class c=student.class;

        Method m =c.getMethod("get"+methodName,null);
        Object stu=c.newInstance();
        m.invoke(stu,null);
    }
    public static void setFields(student stu, Map<String,String[]>params) throws IllegalAccessException, NoSuchMethodException, InvocationTargetException {
        Class c=stu.getClass();
        for(String key:params.keySet()){
            Method m=c.getMethod(key);
            for(String value:params.get(key))
            m.invoke(stu,value);
        }
    }
    public static void main(String[] args) throws SQLException, Exception {
//        invoke("Name");
//        student stu=new student();
//        List<Object>params=new ArrayList<>();
//        params.add("张三");
//        params.add(30);
//        params.add("18023040732");
//        setFields(stu,params);
//        System.out.println(stu);

    }
}
