package Servlets;

import DAO.UserDAO;
import business.User;
import org.hibernate.exception.ConstraintViolationException;
import org.postgresql.util.PSQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/register")
public class RegisterServlet extends HttpServlet {

    public void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {

        UserDAO userDao = new UserDAO();
        String email = req.getParameter("email");
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        User newUser = new User();
        newUser.setUsername(username);
        newUser.setPassword(password);
        newUser.setEmail(email);
        try {

            userDao.create(newUser);
            resp.sendRedirect("index.jsp");
        } catch (PSQLException e) {
            req.getSession().setAttribute("Error", e.getMessage());
            resp.sendRedirect("register.jsp");
        }

    }
}
