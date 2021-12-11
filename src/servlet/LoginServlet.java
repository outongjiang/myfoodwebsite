package servlet;

import model.User;
import service.serviceImpl.UserServiceImpl;

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

        String code=req.getParameter("checkCode");
        String username=req.getParameter("username");
        String password=req.getParameter("password");

         User user=new User();
         user.setUsername(username);
         user.setPassword(password);
        if(req.getSession().getAttribute("checkCode")==req.getSession().getAttribute("checkCode")){
            if(userService.login(user)==1){
                req.getSession().setAttribute("username",username);
            }}
        resp.sendRedirect("/vd/Test/Welcome.jsp");
    }
}
