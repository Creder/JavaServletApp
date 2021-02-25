import DAO.UserDao;
import business.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/user")
public class userServlet extends HttpServlet{
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        UserDao userDao = new UserDao();
        String email = req.getParameter("email");
        String username = req.getParameter("usrn");
        String password = req.getParameter("pass");


        userDao.create(new User("email1", username, password));
        resp.sendRedirect("welcome.jsp");
    }
}
