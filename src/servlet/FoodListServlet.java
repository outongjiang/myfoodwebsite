package servlet;
import model.Food;
import service.serviceImpl.FoodService;
import service.serviceImpl.FoodServiceImpl;
import util.JDBC;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;
@WebServlet("/FoodListServlet")
public class FoodListServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        FoodService foodService=new FoodServiceImpl();
        List<Food> foods =foodService.findFood();
        HttpSession foodSession = req.getSession();
        foodSession.setAttribute("foods",foods);
        resp.sendRedirect(req.getContextPath()+"/foodList.jsp");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.getWriter().write("foodList");
    }
    @Override
    public void destroy() {
        JDBC.Close();
    }
}
