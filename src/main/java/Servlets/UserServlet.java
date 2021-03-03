package Servlets;

import DAO.UserDAO;
import business.User;
import org.hibernate.exception.ConstraintViolationException;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/u")
public class UserServlet extends HttpServlet{
    @Override
    public void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        resp.sendRedirect("welcome.jsp");
    }
}
