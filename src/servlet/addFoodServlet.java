package servlet;

import model.Food;
import service.serviceImpl.FoodService;
import service.serviceImpl.FoodServiceImpl;
import util.myJavaBean;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Map;

@WebServlet("/addFoodServlet")
public class addFoodServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
            Map<String,String[]> map=req.getParameterMap();
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
