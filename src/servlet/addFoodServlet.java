package servlet;
import model.Food;
import service.serviceImpl.FoodService;
import service.serviceImpl.FoodServiceImpl;
import util.JDBC;
import util.myJavaBean;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Collections;
import java.util.Map;
@WebServlet("/addFoodServlet")
public class addFoodServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
            req.setCharacterEncoding("utf-8");
            resp.setCharacterEncoding("utf-8");
            Map<String,String[]> map=req.getParameterMap();
        for(String k:map.keySet()){
            System.out.println(k+":"+map.get(k)[0]);
        }
            Food food=new Food();
            try {
                myJavaBean.setFields(food,map);
            } catch (Exception e) {
                e.printStackTrace();
            }
            FoodService foodService=new FoodServiceImpl();
            foodService.addFood(food);
            resp.sendRedirect(req.getContextPath()+"/addFood.jsp");
    }

}
