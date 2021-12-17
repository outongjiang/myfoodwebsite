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
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;
import java.util.Map;

@WebServlet("/FoodListServlet")
public class FoodListServlet extends HttpServlet {
    int count=0;
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        count++;
        System.out.println("第"+count+"次"+"FoodListServlet");
        Map<String,String[]>map =req.getParameterMap();
        Object[]keys=null;
        if(map!=null){
            keys=map.keySet().toArray();
        }
        Food food=new Food();
        try {
            myJavaBean.setFields(food,map);
        } catch (Exception e) {
            e.printStackTrace();
        }
        FoodService foodService=new FoodServiceImpl();
        System.out.println(food);
        List<Food> foods =foodService.findFood(food,keys);
        HttpSession foodSession = req.getSession();
        foodSession.setAttribute("foods",foods);
        resp.sendRedirect(req.getContextPath()+"/foodList.jsp");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.getWriter().write("foodList");
    }

}
