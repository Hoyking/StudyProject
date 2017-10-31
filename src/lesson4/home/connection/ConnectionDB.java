package lesson4.home.connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionDB {

    private final String URL = "jdbc:mysql://localhost:3306/portal?useUnicode=true&useJDBCCompliantTimezoneShift=true&" +
            "useLegacyDatetimeCode=false&serverTimezone=UTC&useSSL=false";

    private ConnectionDB() {}

    public Connection getConnection() {
        Connection connection = null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection(URL, "progressor_user", "12344321");
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return connection;
    }

    private static class Holder {
        public static ConnectionDB connectionDB = new ConnectionDB();
    }

    public static ConnectionDB getInstance() {
        return Holder.connectionDB;
    }

}
