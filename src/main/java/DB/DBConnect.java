package DB;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnect
{   static final String DB_Driver = "org.postgresql.Driver";
    static final String DB_URL = "jdbc:postgresql://127.0.0.1:5432/dbforjavaee";
    static final String USER = "postgres";
    static final String PASS = "12345";

    public static Connection getConnection() throws SQLException, ClassNotFoundException {
        Class.forName(DB_Driver);
        return DriverManager.getConnection(DB_URL, USER, PASS);
    }
}
