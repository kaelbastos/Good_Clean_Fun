package org.kaelbastos.Persistance.SQLite;

import org.kaelbastos.Domain.Entities.Product.Product;
import org.kaelbastos.Persistance.PersistenceFacade;
import org.kaelbastos.Persistance.SQLite.Utils.ConnectionFactory;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

public class ProductsFromServiceSQLiteDAO {

    public class KitsFromProductsSQLiteDAO {
        public boolean save(Product service) {
            PreparedStatement stmt;
            try {
                createTableIfNotExists();
                if(!PersistenceFacade.getInstance().saveProduct(service))
                    return false;
                Connection conn = ConnectionFactory.getConnection();

                String sql = "INSERT INTO productsFromService (id, name, salePrice, productCategory," +
                        "(?,?,?,?)";
                stmt = conn.prepareStatement(sql);

                stmt.setInt(1, service.getId());
                stmt.setString(2, service.getName());
                stmt.setFloat(3, service.getSalePrice());
                stmt.setString(4, service.getCategory().value);
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

        public boolean delete(String idProduct) {
            String sql = "DELETE FROM productsFromService WHERE id = ?";
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
                        "id integer NOT NULL,\n"+
                        "name text NOT NULL,\n" +
                        "salePrice float,\n" +
                        "productCategory text,\n" +
                        "FOREIGN KEY('id') REFERENCES service('id')\n);";
                statement = connection.prepareStatement(sqlTable);
                statement.execute();
            } finally {
                if (statement != null) {
                    statement.close();
                }
            }
        }
    }

}
