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
     String Name;
     Integer Age;

    @Override
    public String toString() {
        return "student{" +
                "name='" + Name + '\'' +
                ", age=" + Age +
                ", phone='" + Phone + '\'' +
                '}';
    }

    public void setName(String name) {
        this.Name = name;
    }

    public void setAge(Integer age) {
        this.Age = age;
    }

    public void setPhone(String phone) {
        this.Phone = phone;
    }

    String Phone;

}
public class test1 {
    public static void invoke(String methodName) throws Exception {
        Class c=student.class;

        Method m =c.getDeclaredMethod("get"+methodName,null);
        Object stu=c.newInstance();
        m.invoke(stu,null);
    }
    public static void setFields(student stu, Map<String,String[]>params) throws Exception {
        Class c=stu.getClass();
        Method m=null;
        for(String key:params.keySet()){
            int flag=1;
            if(c.getDeclaredField(key).getType().toString().contains("Integer")) {
                System.out.println(c.getDeclaredField(key).getType().toString());
                m = c.getMethod("set" + key, Integer.class);
            }else {
                m = c.getMethod("set" + key, String.class);
                flag=2;
            }
            for(String value:params.get(key)) {
                if(flag==2) {
                    m.invoke(stu, value);
                }else{
                    m.invoke(stu, Integer.valueOf(value));
                }
            }

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
        Class c=student.class;
//        int s=22;
//        Object i=s;
//        Field age=c.getField("age");
//        System.out.println(age.getType().toString().equals("int"));
        System.out.println(c.getDeclaredField("Age").getType().toString().contains("Integer"));



    }
}
