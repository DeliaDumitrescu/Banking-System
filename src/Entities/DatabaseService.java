package  Entities;

import java.sql.*;

public class DatabaseService {
    private static DatabaseService instance = null;
    Connection connection;
    private String url = "jdbc:mysql://localhost:3306/BankingSystem";
    private String user = "root";
    private String password = "";

    private DatabaseService() throws SQLException {
        connection = DriverManager.getConnection(url, user, password);
        Statement statement = connection.createStatement();
//        statement.executeUpdate("truncate Card");
//        statement = connection.createStatement();
//        statement.executeUpdate("truncate Client");
//        statement = connection.createStatement();
//        statement.executeUpdate("truncate Account");
//        statement = connection.createStatement();
//        statement.executeUpdate("truncate Transaction");
    }

    public static DatabaseService getInstance() throws SQLException {
        if (instance == null) {
            instance = new DatabaseService();
        }
        return instance;
    }

    public ResultSet executeQuery(String query) throws SQLException {
        Statement statement = connection.createStatement();
        return statement.executeQuery(query);
    }

    public void executeUpdate(String query) throws SQLException {
        Statement statement = connection.createStatement();
        statement.executeUpdate(query);
    }
}