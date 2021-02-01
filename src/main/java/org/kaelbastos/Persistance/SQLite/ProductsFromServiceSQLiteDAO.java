package org.kaelbastos.Persistance.SQLite;

import org.kaelbastos.Domain.Entities.Product.Kit;
import org.kaelbastos.Domain.Entities.Product.Product;
import org.kaelbastos.Domain.Entities.Service.Service;
import org.kaelbastos.Persistance.SQLite.Utils.ConnectionFactory;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

public class ProductsFromServiceSQLiteDAO {
    public boolean save(Product product) {
        PreparedStatement stmt;
        try {
            createTableIfNotExists();
            Connection conn = ConnectionFactory.getConnection();

            String sql = "INSERT INTO productsFromService (idProduct, idService" +
                    "(?,?)";
            stmt = conn.prepareStatement(sql);

            stmt.setInt(1, product.getId());
            for (Product p : Service service;)
                stmt.setString(2, product.getId().toString());
            stmt.execute();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
        return false;
    }

    public Optional<List<Product>> getAll(String idProduct) {
        return Optional.empty();
    }

    public boolean delete(String idProduct) {
        String sql = "DELETE FROM productsFromService WHERE idProduct = ?";
        try (Connection conn = ConnectionFactory.getConnection()) {
            assert conn != null;
            try (PreparedStatement stmt = conn.prepareStatement(sql)) {
                stmt.setString(1, idProduct);
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
            String sqlTable = "CREATE TABLE IF NOT EXISTS produtsFromService(\n" +
                    "idProduct integer NOT NULL,\n" +
                    "idService text NOT NULL,\n" +
                    "FOREIGN KEY('idProduct') REFERENCES product('id')\n);";
            statement = connection.prepareStatement(sqlTable);
            statement.execute();
        } finally {
            if (statement != null) {
                statement.close();
            }
        }
    }
}
