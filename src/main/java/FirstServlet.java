import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

@WebServlet(urlPatterns="/connectToDB")
public class FirstServlet extends HttpServlet {
    static final String DB_URL = "jdbc:postgresql://127.0.0.1:5432/dbforjavaee";
    static final String USER = "postgres";
    static final String PASS = "12345";
    @Override
    public void service(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
       try {
           Class.forName("org.postgresql.Driver");
       }
       catch (ClassNotFoundException e){
           System.out.println("Postgresql not found!");
           e.printStackTrace();
           return;
       }
        Connection connection;
       try {
           connection = DriverManager.getConnection(DB_URL, USER, PASS);
       }
       catch (SQLException e){
           System.out.println("Cannot connect to db");
           e.printStackTrace();
           return;
       }

       if(connection !=null){
           System.out.println("Connection success!");
       }
       else System.out.println("Connection failed!");

    }

}
