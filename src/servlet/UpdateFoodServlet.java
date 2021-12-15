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

@WebServlet("/UpdateFoodServlet")
public class UpdateFoodServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Map<String,String[]>map=request.getParameterMap();
        System.out.println(map);
        Food food=new Food();
        try {
            myJavaBean.setFields(food,map);
        } catch (Exception e) {
            e.printStackTrace();
        }
        FoodService foodService=new FoodServiceImpl();
        foodService.updateFood(food);
        response.sendRedirect(request.getContextPath()+"/FoodListServlet");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}
