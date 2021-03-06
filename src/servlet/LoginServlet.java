package servlet;
import model.User;
import service.serviceImpl.UserServiceImpl;
import util.JDBC;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
    private UserServiceImpl userService=new UserServiceImpl();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        resp.setCharacterEncoding("utf-8");
        String inputCode=req.getParameter("checkCode");
        String username=req.getParameter("username");
        String password=req.getParameter("password");
        String realCode=String.valueOf( req.getSession().getAttribute("checkCode"));
        req.getSession().removeAttribute("checkCode");
         User user=new User();
         user.setUsername(username);
         user.setPassword(password);
        if(inputCode.equalsIgnoreCase(realCode)){
            if(userService.login(user)==1){
                //loginStatus
                req.getSession().setAttribute("loginStatus",username);//通过登录成功
            }else{
                req.getSession().setAttribute("loginStatus","-2");
            }
        }else{
            req.getSession().setAttribute("loginStatus","-1");
            //验证码错误
        }
        resp.sendRedirect(req.getContextPath()+"/home.jsp");
    }

}
