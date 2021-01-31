package org.kaelbastos.Persistance.SQLite.Utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionFactory {
    public static java.sql.Connection getConnection() {
        Connection connection;
        try {
            connection = DriverManager.getConnection("jdbc:sqlite:Good-Clean-Fun.db");

            return connection;

        } catch (SQLException e) {
            System.out.println("Nao foi possivel conectar ao banco de dados.");
            return null;
        }
    }

    public static void main(String[] args) throws SQLException {
        getConnection();
    }
}
