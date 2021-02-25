import DAO.UserDao;
import business.User;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/login")
public class loginServlet extends HttpServlet {

    @Override
    public void doPost(HttpServletRequest req, HttpServletResponse res) throws IOException {
        UserDao userDao = new UserDao();
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        User user = userDao.read(new User(username,password));
        if( user != null){
            req.getSession().setAttribute("username", user.getUsername());
            res.sendRedirect("welcome.jsp");
        }
        else{
            res.sendRedirect("index.jsp");
        }
    }
}
