package org.kaelbastos.Persistance.SQLite;

import org.kaelbastos.Domain.Entities.Product.Kit;
import org.kaelbastos.Domain.Entities.Product.Product;
import org.kaelbastos.Domain.Entities.Product.ProductCategory;
import org.kaelbastos.Persistance.DAOs.ProductDAO;
import org.kaelbastos.Persistance.SQLite.Utils.ConnectionFactory;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class ProductSQLiteDAO extends ProductDAO {
    @Override
    public boolean save(Product product) {
        PreparedStatement stmt;
        try {
            createTableIfNotExists();
            Connection conn = ConnectionFactory.getConnection();
            String sql = "INSERT INTO product (id, name, salePrice, purchasePrice, productCategory," +
                    "(?,?,?,?,?)";
            assert conn != null;
            stmt = conn.prepareStatement(sql);

            stmt.setInt(1, product.getId());
            stmt.setString(2, product.getName());
            stmt.setFloat(3, product.getSalePrice());
            stmt.setFloat(4, product.getPurchasePrice());
            stmt.setString(5, product.getCategory().value);
            stmt.execute();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
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
                return true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public Optional<Product> getOne(Integer integer) {
        PreparedStatement statement;
        try(Connection connection = ConnectionFactory.getConnection()){
            String sql = "SELECT * FROM product WHERE id = ?";
            assert connection != null;
            statement = connection.prepareStatement(sql);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                int id = resultSet.getInt("id");
                String name = resultSet.getString("name");
                float salePrice = resultSet.getFloat("salePrice");
                float purchasePrice = resultSet.getFloat("purchasePrice");
                Product product = new Product(id, name, salePrice, purchasePrice,
                        ProductCategory.valueOf(resultSet.getString("productCategory")));
                return Optional.of(product);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return Optional.empty();
    }

    @Override
    public Optional<List<Product>> getAll() {
        List<Product> list = new ArrayList<>();
        PreparedStatement statement;
        try(Connection connection = ConnectionFactory.getConnection()){
            String sql = "SELECT * FROM product";
            assert connection != null;
            statement = connection.prepareStatement(sql);
            ResultSet resultSet = statement.executeQuery();
            while(resultSet.next()) {
                int id = resultSet.getInt("id");
                String name = resultSet.getString("name");
                float salePrice = resultSet.getFloat("salePrice");
                float purchasePrice = resultSet.getFloat("purchasePrice");
                Product product = new Product(id, name, salePrice, purchasePrice,
                        ProductCategory.valueOf(resultSet.getString("productCategory")));
                list.add(product);
            }
            return Optional.of(list);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return Optional.empty();
    }

    @Override
    public boolean delete(Integer productId) {
        String sql = "DELETE FROM product WHERE id = ?";
        try (Connection conn = ConnectionFactory.getConnection()) {
            assert conn != null;
            try (PreparedStatement stmt = conn.prepareStatement(sql)) {
                stmt.setInt(1, productId);
                stmt.execute();
                return true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public Optional<List<Kit>> getKitsFromProducts() {
        return Optional.empty();
    }

    private void createTableIfNotExists() throws SQLException {
        PreparedStatement statement = null;
        try (Connection connection = ConnectionFactory.getConnection()) {
            String sqlTable = "CREATE TABLE IF NOT EXISTS product(\n" +
                    "id integer NOT NULL,\n"+
                    "name text NOT NULL,\n" +
                    "salePrice float,\n" +
                    "purchasePrice float,\n" +
                    "productCategory text,\n" +
                    ");";
            assert connection != null;
            statement = connection.prepareStatement(sqlTable);
            statement.execute();
        } finally {
            if (statement != null) {
                statement.close();
            }
        }
    }
}
