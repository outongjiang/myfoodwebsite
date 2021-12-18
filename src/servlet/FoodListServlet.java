package servlet;
import model.Food;
import model.PageBean;
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
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
@WebServlet("/FoodListServlet")
public class FoodListServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        resp.setCharacterEncoding("utf-8");
        FoodService foodService=new FoodServiceImpl();
        HttpSession foodSession = req.getSession();
        Map<String,String[]>map =req.getParameterMap();

        Object[]keys=null;
        Food food=new Food();
        try {
            myJavaBean.setFields(food, map);
        } catch (Exception e) {
            e.printStackTrace();
        }
        keys = map.keySet().toArray();
        foodSession.setAttribute("huiXian", food);
        String currPage=req.getParameter("currPage")==null?"1":req.getParameter("currPage");
        PageBean pageBean =foodService.findFood(food,keys,Integer.parseInt(currPage));
        foodSession.setAttribute("PageBean",pageBean);
//        System.out.println(pageBean.getCurrPage()+":"+pageBean.getCount());
//        System.out.println(food);
        resp.sendRedirect(req.getContextPath()+"/foodList.jsp");

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.getWriter().write("foodList");
    }

}
