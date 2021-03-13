package Servlets;

import DAO.FanficDAO;
import business.Fanfic;
import business.User;
import org.postgresql.util.PSQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/addfanfic")
public class FanficServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        FanficDAO fanficDAO = new FanficDAO();
        User user = (User)req.getSession().getAttribute("user");

        String title = req.getParameter("title");
        String content = req.getParameter("content");
        Fanfic fanfic = new Fanfic();

        if((title != null || !title.equals("")) && (content !=null || !content.equals(""))){
            fanfic.setTitle(title);
            fanfic.setContent(content);
            fanfic.setAuthor(user);
            try {
                fanficDAO.create(fanfic);
            } catch (PSQLException throwables) {
                throwables.printStackTrace();
            }
        }

        resp.sendRedirect("user.jsp");



    }
}
