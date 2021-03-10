package Servlets.Json;

import DAO.FanficDAO;
import business.Fanfic;
import org.json.JSONArray;
import org.json.JSONObject;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

@WebServlet("/fanficsByUser/*")
public class FindFanficsByUserJSONServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String username = req.getPathInfo().substring(1);
        resp.setHeader("Access-Control-Allow-Origin", "*");
        resp.setContentType("application/json");
        resp.setCharacterEncoding("UTF-8");
        PrintWriter out = resp.getWriter();
        FanficDAO fanficDAO = new FanficDAO();
        try{
            List<Fanfic> fanficList = fanficDAO.findByUser(username);
            JSONArray jsonArray = new JSONArray(fanficList);
            out.print(jsonArray);
        }
        finally {
            out.flush();
            out.close();
        }
    }
}
