package Servlets;

import DAO.UserDAO;
import business.User;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {
    private UserDAO userDao;
    @Override
    public void init() throws ServletException {
        userDao = new UserDAO();
    }

    @Override
    public void doPost(HttpServletRequest req, HttpServletResponse res) throws IOException {

        String username = req.getParameter("username");
        String password = req.getParameter("password");

        User user = new User();
        user.setUsername(username);
        user.setPassword(password);

        User userFromDb = userDao.findByUsername(user);
        if( userFromDb != null) {
            req.getSession().setAttribute("user", userFromDb);
        }
        res.sendRedirect("index.jsp");
    }
}
