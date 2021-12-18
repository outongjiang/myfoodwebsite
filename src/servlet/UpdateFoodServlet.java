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
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Map;
@WebServlet("/UpdateFoodServlet")
public class UpdateFoodServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Map<String,String[]>map=request.getParameterMap();
        HttpSession session=request.getSession();
        session.setAttribute("update","y");
        Food food=new Food();
        try {
            myJavaBean.setFields(food,map);
        } catch (Exception e) {
            e.printStackTrace();
        }
        //更新食物
        FoodService foodService=new FoodServiceImpl();
        foodService.updateFood(food);

        //回到显示食物单页面
        response.sendRedirect(request.getContextPath()+"/FoodListServlet");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }

}
