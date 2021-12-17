package Test;

import javax.servlet.Servlet;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class test6 {

    public static void main(String[] args) {
        Map<String,String>map=new HashMap<>();
        map.put("a","98");
        map.put("b","99");
        System.out.println(map.keySet().toArray()[0]+"aaa");
    }

    private static void f(Object[] toArray) {
    }
}
