package servlet;

import service.serviceImpl.FoodService;
import service.serviceImpl.FoodServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/UpdateFoodServlet")
public class UpdateFoodServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
       String foodid=request.getParameter("foodid");
        FoodService foodService=new FoodServiceImpl();
        foodService.updateFood(foodid);
        response.sendRedirect(request.getContextPath()+"/foodList.jsp");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}
