package service.serviceImpl;
import dataAccessObject.UserDao;
import model.User;
import service.UserService;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
public class UserServiceImpl implements UserService {
    private UserDao ud=new UserDao();
    //检验登录
    @Override
    public int login(User user) {
        String sql="select * from myfood username=? and password=? ";
        List<Object> params=new ArrayList<Object>();
        params.add(user.getUsername());
        params.add(user.getPassword());
        ResultSet rs=ud.select(sql,params);
        try {
            if(rs.next())
                return 1;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return -1;
    }
}
