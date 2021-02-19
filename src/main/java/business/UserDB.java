package business;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UserDB {
    static final String DB_URL = "jdbc:postgresql://127.0.0.1:5432/dbforjavaee";
    static final String USER = "postgres";
    static final String PASS = "12345";

    public List<User> getUserList(){
        ArrayList<User> userList = new ArrayList<>();

        try(Connection conn = DriverManager.getConnection(DB_URL, USER, PASS)) {
            Class.forName("org.postgresql.Driver").getDeclaredConstructor().newInstance();
            Statement statement = conn.createStatement();
            ResultSet result = statement.executeQuery("Select * from users");
            while(result.next()){
                int id = result.getInt(1);
                String username = result.getString(2);
                String password = result.getString(3);
                User user = new User(id, username, password);
                userList.add(user);
            }
        }
        catch (Exception e) {
            System.out.println(e);
        }
        return userList;

    }

    public User getUser(String username, String password){
        User user = new User();
        String sqlquery = ("Select  from users where username=? and passw =?");
        try(Connection conn = DriverManager.getConnection(DB_URL, USER, PASS)) {
            Class.forName("org.postgresql.Driver").getDeclaredConstructor().newInstance();
            PreparedStatement statement = conn.prepareStatement(sqlquery);
            statement.setString(1, username);
            statement.setString(2, password);
            ResultSet result = statement.executeQuery();
            if(result.next()){
                int id = result.getInt(1);
                String usern = result.getString(2);
                String pass = result.getString(3);
                user = new User(id, usern, pass);
            }
        }
        catch (Exception e){
            System.out.println(e);

        }
        return user;

    }

}
