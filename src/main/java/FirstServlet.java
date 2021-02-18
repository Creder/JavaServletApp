import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet(urlPatterns="/hello")
public class FirstServlet extends HttpServlet {
    @Override
    public void service(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        res.getWriter().append("Hi! " + req.getMethod());
        HttpSession session = req.getSession();

        if(session.getAttribute("Name") == null)
        {
            session.setAttribute("Name", "Oi!");
            res.getWriter().append("No session");
        }
        else{
            res.getWriter().append((String) session.getAttribute("Name"));
        }
    }
}
