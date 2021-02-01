package org.kaelbastos.Persistance.SQLite;

import org.kaelbastos.Domain.Entities.Product.Product;
import org.kaelbastos.Domain.Entities.Product.ProductCategory;
import org.kaelbastos.Domain.Entities.Service.Service;
import org.kaelbastos.Persistance.PersistenceFacade;
import org.kaelbastos.Persistance.SQLite.Utils.ConnectionFactory;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class ProductsFromServiceSQLiteDAO {
    public boolean save(Service service) {
        PreparedStatement stmt;
        try {
            createTableIfNotExists();
            Connection conn = ConnectionFactory.getConnection();

            String sql = "INSERT INTO productsFromService (idService, idProduct)" +
                    "(?,?)";
            stmt = conn.prepareStatement(sql);

            stmt.setInt(1, service.getId());
            for (Product p :  service.getProducts())
                stmt.setInt(2, p.getId());
            stmt.execute();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public Optional<List<Product>> getAll(int idService) {
        List<Product> list = new ArrayList<>();
        PreparedStatement statement;
        try(Connection connection = ConnectionFactory.getConnection()){
            String sql = "SELECT * FROM product WHERE idService = ?";
            assert connection != null;
            statement = connection.prepareStatement(sql);
            statement.setInt(1, idService);
            ResultSet resultSet = statement.executeQuery();
            while(resultSet.next()) {
                int productId = resultSet.getInt("idProduct");
                Optional<Product> product = PersistenceFacade.getInstance().getOneProduct(productId);
                product.ifPresent(list::add);
            }
            Optional.of(list);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return Optional.empty();
    }

    public boolean delete(int idService, int idProduct) {
        String sql = "DELETE FROM productsFromService WHERE idProduct = ?, idService = ?";
        try (Connection conn = ConnectionFactory.getConnection()) {
            assert conn != null;
            try (PreparedStatement stmt = conn.prepareStatement(sql)) {
                stmt.setInt(1, idProduct);
                stmt.setInt(2, idService);
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
                    "idService integer NOT NULL\n" +
                    ");";
            statement = connection.prepareStatement(sqlTable);
            statement.execute();
        } finally {
            if (statement != null) {
                statement.close();
            }
        }
    }
}
