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
                    int id = result.getInt(3);
                    String username = result.getString(1);
                    String password = result.getString(2);
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
                    if(result.getString(2).equals(password)){
                        user = new User(result.getInt(3), result.getString(1), result.getString(2));
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
                statement.executeQuery();
            }
        }
        catch (Exception throwables) {
            throwables.printStackTrace();
        }

    }

}
