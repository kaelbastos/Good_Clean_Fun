package org.kaelbastos.Persistance.SQLite;

import org.kaelbastos.Domain.Entities.Product.Kit;
import org.kaelbastos.Domain.Entities.Product.Product;
import org.kaelbastos.Persistance.SQLite.Utils.ConnectionFactory;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

public class KitsFromProductsSQLiteDAO {
    public boolean save(Product kit) {
        PreparedStatement stmt;
        try {
            createTableIfNotExists();
            Connection conn = ConnectionFactory.getConnection();

            String sql = "INSERT INTO kitFromProducts (idKit, idProduct" +
                    "(?,?)";
            stmt = conn.prepareStatement(sql);

            stmt.setInt(1, kit.getId());
            for(Product p : ((Kit) kit).getProducts())
                stmt.setString(2, kit.getId().toString());
                stmt.execute();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public Optional<List<Product>> getAll(String idKit) {
        return Optional.empty();
    }

    public boolean delete(String idKit) {
            String sql = "DELETE FROM kitFromProducts WHERE idKit = ?";
            try (Connection conn = ConnectionFactory.getConnection()) {
                assert conn != null;
                try (PreparedStatement stmt = conn.prepareStatement(sql)) {
                    stmt.setString(1, idKit);
                    stmt.execute();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
            return false;
        }

    private void createTableIfNotExists() throws SQLException {
        PreparedStatement statement = null;
        try (Connection connection = ConnectionFactory.getConnection()) {
            String sqlTable = "CREATE TABLE IF NOT EXISTS kitFromProducts(\n" +
                    "idKit integer NOT NULL,\n"+
                    "idProducts integer NOT NULL,\n"+
                    "FOREIGN KEY('idKit') REFERENCES kit('id')\n);";
            statement = connection.prepareStatement(sqlTable);
            statement.execute();
        } finally {
            if (statement != null) {
                statement.close();
            }
        }
    }
}
