import business.UserDB;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/login")
public class loginServlet extends HttpServlet {
    UserDB userDB = new UserDB();
    @Override
    public void service(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException{
        String username = req.getParameter("username");
        String password = req.getParameter("password");

        if(userDB.getUser(username, password) != null){
            req.getSession().setAttribute("username", username);
            res.sendRedirect("welcome.jsp");
        }
        else{
            res.sendRedirect("index.jsp");
        }

    }
}
