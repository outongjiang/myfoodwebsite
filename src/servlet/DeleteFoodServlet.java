package servlet;

import service.serviceImpl.FoodService;
import service.serviceImpl.FoodServiceImpl;
import util.JDBC;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/DeleteFoodServlet")
public class DeleteFoodServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String id=req.getParameter("id");
        FoodService foodService=new FoodServiceImpl();
        foodService.deleteFood(id);
        resp.sendRedirect(req.getContextPath()+"/FoodListServlet");
    }

    @Override
    public void destroy() {
        JDBC.Close();
    }
}
