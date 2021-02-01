package org.kaelbastos.Persistance.SQLite;

import org.kaelbastos.Domain.Entities.Client.Client;
import org.kaelbastos.Domain.Entities.Product.Product;
import org.kaelbastos.Domain.Entities.Service.Service;
import org.kaelbastos.Domain.Entities.utils.Address;
import org.kaelbastos.Persistance.DAOs.ServiceDAO;
import org.kaelbastos.Persistance.PersistenceFacade;
import org.kaelbastos.Persistance.SQLite.Utils.ConnectionFactory;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class ServiceSQLiteDAO extends ServiceDAO {

    @Override
    public boolean save(Service service) {
        PreparedStatement stmt;
        try {
            Connection conn = ConnectionFactory.getConnection();

            String sql = "INSERT INTO service (id, start, workerPercetage, status, category, idClient) values (?,?,?,?,?,?)";
            if (conn == null) throw new AssertionError();
            stmt = conn.prepareStatement(sql);

            stmt.setInt(1, service.getId());
            stmt.setString(2, service.getStart().toString());
            stmt.setFloat(3, service.getWorkerPercentage());
            stmt.setString(4, service.getStatus().value);
            stmt.setString(5, service.getCategory().value);
            stmt.setString(6, service.getClient().getCpf());
            stmt.execute();
            return true;

        } catch (SQLException e) {
            return false;
        }
    }

    @Override
    public boolean update(Service service) {
        String sql = "UPDATE service SET start = ?, workerPercentage = ?, status = ?, category = ?,  WHERE id  = ?";
        try (Connection conn = ConnectionFactory.getConnection()) {
            assert conn != null;
            PersistenceFacade.getInstance().updateService(service);

            try (PreparedStatement stmt = conn.prepareStatement(sql)) {
                stmt.setInt(5, service.getId());
                stmt.setString(4, service.getCategory().value);
                stmt.setString(3, service.getStatus().value);
                stmt.setFloat(2, service.getWorkerPercentage());
                stmt.setString(1, service.getStart().toString());
                stmt.executeUpdate();
                return true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public Optional<Service> getOne(Integer idService) {
        List<Service> list = new ArrayList<>();
        PreparedStatement statement;
        try (Connection connection = ConnectionFactory.getConnection()) {
            String sql = "SELECT * FROM service WHERE id = ?";
            assert connection != null;
            statement = connection.prepareStatement(sql);
            statement.setInt(1, idService);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                String id = resultSet.getString("id");
                String start = resultSet.getString("start");
                Float servicePrice = resultSet.getFloat("servicePrice");
                Integer workerPercentage = resultSet.getInt("workerPercentage");
                String status = resultSet.getString("status");
                String category = resultSet.getString("category");
                Optional<Client> client = PersistenceFacade.getInstance().getOneClient(resultSet.getString("idClient"));
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }return Optional.empty();
    }

    @Override
    public Optional<List<Service>> getAll() {
        List<Service> list = new ArrayList<>();
        PreparedStatement statement;
        try (Connection connection = ConnectionFactory.getConnection()) {
            String sql = "SELECT * FROM service";
            assert connection != null;
            statement = connection.prepareStatement(sql);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                String id = resultSet.getString("id");
                String start = resultSet.getString("start");
                Float servicePrice = resultSet.getFloat("servicePrice");
                Integer workerPercentage = resultSet.getInt("workerPercentage");
                String status = resultSet.getString("status");
                String category = resultSet.getString("category");
                Optional<Client> client = PersistenceFacade.getInstance().getOneClient(resultSet.getString("idClient"));
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }return Optional.empty();
    }

    @Override
    public boolean delete(Integer integer) {
        String sql = "DELETE FROM service WHERE id = ?";
        PersistenceFacade.getInstance().deleteService(integer);
        try (Connection conn = ConnectionFactory.getConnection()) {
            assert conn != null;
            try (PreparedStatement stmt = conn.prepareStatement(sql)) {
                stmt.setInt(1, integer);
                stmt.execute();
                return true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public Optional<ArrayList<Product>> getProductsFromService(Integer serviceId) {
        return Optional.empty();
    }
}
