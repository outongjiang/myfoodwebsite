package Test;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.Map;

@WebServlet("/ServletTest1")
public class ServletTest1 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Map<String,String[]>map=req.getParameterMap();
        student student=new student();

        try {
            test1.setFields(student,map);
        } catch (Exception e) {
            e.printStackTrace();
        }

        System.out.println(student);
    }
}
