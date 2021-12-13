package Test;

import java.util.List;
class teacher{
    public  String name;
}
public class test3 {
    public static <T> List<T>  f(T t){
        System.out.println(t);
        return null;
    }

    public static void main(String[] args) {
        f(new teacher());
    }

}
