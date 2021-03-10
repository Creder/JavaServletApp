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

@WebServlet("/oneFanfic/*")
public class OneFanficJSONServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Long fanficId = Long.valueOf(req.getPathInfo().substring(1));
        resp.setHeader("Access-Control-Allow-Origin", "*");
        resp.setContentType("application/json");
        resp.setCharacterEncoding("UTF-8");
        PrintWriter out = resp.getWriter();
        FanficDAO fanficDAO = new FanficDAO();
        try{
            Fanfic fanfic = fanficDAO.findById(fanficId);
            JSONObject jsonObject = new JSONObject(fanfic);
            out.print(jsonObject);
        }
        finally {
            out.flush();
            out.close();
        }
    }
}
