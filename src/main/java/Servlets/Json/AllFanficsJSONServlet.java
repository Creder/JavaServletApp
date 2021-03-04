package Servlets.Json;

import DAO.FanficDAO;
import business.Fanfic;
import org.json.JSONArray;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

@WebServlet("/allfanfics")
public class AllFanficsJSONServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("application/json");
        PrintWriter out = resp.getWriter();
        FanficDAO fanficDAO = new FanficDAO();
        try{
            List<Fanfic> fanficList = fanficDAO.readEntityList();
            JSONArray jsonArray = new JSONArray(fanficList);
            out.print(jsonArray);
        }
        finally {
            out.flush();
            out.close();
        }

    }
}
