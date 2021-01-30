package org.kaelbastos.Persistance.SQLite.Utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionFactory {
    public static java.sql.Connection getConnection() {
        Connection connection;

        try {
            Class.forName("jdbc:sqlite:Good-Clean-Fun.db");

            String url = "jdbc:sqlite:Good-Clean-Fun.db";
            //String username = batata;
            //String password = 12345;

            connection = DriverManager.getConnection(url/*, username, password*/);

            return connection;

        } catch (ClassNotFoundException e) {
            System.out.println("O driver expecificado nao foi encontrado.");
            return null;

        } catch (SQLException e) {
            System.out.println("Nao foi possivel conectar ao banco de dados.");
            return null;
        }
    }
}
