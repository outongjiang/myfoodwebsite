package util;
import java.lang.reflect.Method;
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
                    m.invoke(object, Integer.valueOf(value));
                }
            }

        }
    }
}
