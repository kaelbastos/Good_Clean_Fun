package org.kaelbastos.Persistance.SQLite;

import org.kaelbastos.Domain.Entities.Product.Kit;
import org.kaelbastos.Domain.Entities.Product.Product;
import org.kaelbastos.Domain.Entities.Product.ProductCategory;
import org.kaelbastos.Persistance.DAOs.ProductDAO;
import org.kaelbastos.Persistance.SQLite.Utils.ConnectionFactory;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

public class ProductSQLiteDAO extends ProductDAO {
    @Override
    public boolean save(Product product) {
        PreparedStatement stmt = null;
        Connection conn = null;
        try {
            conn = ConnectionFactory.getConnection();

            String sqlTable = "CREATE TABLE IF NOT EXISTS product(\n" +
                    "id integer NOT NULL,\n"+
                    "name text NOT NULL,\n" +
                    "salePrice float,\n" +
                    "purchasePrice float,\n" +
                    "productCategory text,\n" +
                    "FOREIGN KEY('cpf') REFERENCES ProductDAO('id')\n"+
                    ");";
            assert conn != null;
            stmt = conn.prepareStatement(sqlTable);
            stmt.execute();

            String sql = "INSERT INTO product (id, name, salePrice, purchasePrice, productCategory," +
                    "(?,?,?,?,?)";
            stmt = conn.prepareStatement(sql);

            stmt.setInt(1, product.getId());
            stmt.setString(2, product.getName());
            stmt.setFloat(3, product.getSalePrice());
            stmt.setFloat(4, product.getPurchasePrice());
            stmt.setString(5, product.getCategory().value);
            stmt.execute();
        } catch (SQLException e) {
            e.printStackTrace();

        } finally {
            if (conn != null) {
                try {
                    conn.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if (stmt != null) {
                try {
                    stmt.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
        return false;
    }

    @Override
    public boolean update(Product product) { String sql =
            "UPDATE product SET name = ?, saleprice = ?, purchasePrice = ?, " +
            "category = ? WHERE id = ?";
        try (Connection conn = ConnectionFactory.getConnection()) {
            assert conn != null;
            try (PreparedStatement stmt = conn.prepareStatement(sql)) {
                stmt.setInt(1, product.getId());
                stmt.setString(2, product.getName());
                stmt.setFloat(3, product.getSalePrice());
                stmt.setFloat(4, product.getPurchasePrice());
                stmt.setString(5, product.getCategory().value);
                stmt.executeUpdate();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }return false;
    }

    @Override
    public Optional<Product> getOne(Integer integer) {
        return Optional.empty();
    }

    @Override
    public Optional<List<Product>> getAll() {
        return Optional.empty();
    }

    @Override
    public boolean delete(Integer integer) {
        String sql = "DELETE FROM product WHERE id = ?";
        try (Connection conn = ConnectionFactory.getConnection()) {
            assert conn != null;
            try (PreparedStatement stmt = conn.prepareStatement(sql)) {
                stmt.setInt(1, integer);
                stmt.execute();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }return false;
    }

    @Override
    public Optional<List<Kit>> getKitsFromProducts() {
        return Optional.empty();
    }
}
