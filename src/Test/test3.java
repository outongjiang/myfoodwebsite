package Test;

import org.w3c.dom.ls.LSInput;

import java.util.ArrayList;
import java.util.List;
class teacher{
    public  String name;
}
public class test3 {
    public static <T> List<T>  f(){
        List<T>list=new ArrayList<T>();
        teacher t1=new teacher();
        t1.name="张三";
        T t2= (T) t1;
        list.add(t2);
        return list;
    }

    public static void main(String[] args) {
        List<teacher>teachers=f();
        System.out.println(teachers.get(0).name);
    }

}
