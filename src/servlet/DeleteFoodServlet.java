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
import java.util.Arrays;
@WebServlet("/DeleteFoodServlet")
public class DeleteFoodServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String []id=req.getParameterValues("id");
        System.out.println("DeleteFoodServlet 测试变量id是否为空");
        System.out.println(Arrays.toString(id));
        System.out.println("虚拟目录为:"+req.getContextPath());
        //没有要删除的选项
        if(id!=null){
            FoodService foodService=new FoodServiceImpl();
            foodService.deleteFood(id);
            resp.sendRedirect(req.getContextPath()+"/FoodListServlet");
        }
        resp.sendRedirect("/vd/FoodListServlet");

    }
}