package DB;

import business.User;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UserDB {

    public static List<User> getUserList(){
        ArrayList<User> userList = new ArrayList<>();
        try {
            try (Connection con = DBConnect.getConnection()) {

                Statement statement = con.createStatement();
                ResultSet result = statement.executeQuery("Select * from users");
                while (result.next()) {
                    int id = result.getInt("userID");
                    String username = result.getString("username");
                    String password = result.getString("passw");
                    User user = new User(id, username, password);
                    userList.add(user);
                }
            }
        }
        catch (Exception e) {
            System.out.println(e);
        }
        return userList;

    }

    public static User getUser(String username, String password) {
        User user = null;

        String sqlquery = "select * from users where username=?";
        try {
            try (Connection con = DBConnect.getConnection()) {
                PreparedStatement statement = con.prepareStatement(sqlquery);
                statement.setString(1, username);
                ResultSet result = statement.executeQuery();
                if(result.next()) {
                    if(result.getString("passw").equals(password)){
                        user = new User(result.getInt("userId"), result.getString("username"), result.getString("passw"));
                    }
                }
            }
        }
        catch (Exception e){
            System.out.println(e);

        }
        return user;

    }

    public static void createUser(String username, String password){
        String sqlquery = "insert into users (username, passw) values(?, ?)";
        try {
            try (Connection con = DBConnect.getConnection()){
                PreparedStatement statement = con.prepareStatement(sqlquery);
                statement.setString(1, username);
                statement.setString(2, password);
                statement.execute();
            }
        }
        catch (Exception throwables) {
            throwables.printStackTrace();
        }

    }

}
