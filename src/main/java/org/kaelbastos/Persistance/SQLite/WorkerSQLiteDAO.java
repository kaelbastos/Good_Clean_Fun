package org.kaelbastos.Persistance.SQLite;

import org.kaelbastos.Domain.Entities.Worker.DayOfWeekRestriction;
import org.kaelbastos.Domain.Entities.Worker.Worker;
import org.kaelbastos.Domain.Entities.utils.Address;
import org.kaelbastos.Domain.Entities.utils.Observation;
import org.kaelbastos.Persistance.DAOs.WorkerDAO;
import org.kaelbastos.Persistance.SQLite.Utils.ConnectionFactory;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class WorkerSQLiteDAO extends WorkerDAO {
    @Override
    public boolean save(Worker worker) {
        PreparedStatement stmt = null;
        Connection conn = null;
        try {
            conn = ConnectionFactory.getConnection();

            String sqlTable = "CREATE TABLE IF NOT EXISTS worker(\n" +
                    "cpf text NOT NULL,\n"+
                    "name text NOT NULL,\n" +
                    "telephone text,\n" +
                    "secundaryPhone text,\n" +
                    "email text,\n" +
                    "telephone text,\n" +
                    "secundaryPhone text,\n" +
                    "email text,\n" +
                    "street text,\n" +
                    "neighborhood text,\n" +
                    "city text,\n" +
                    "state text,\n" +
                    "number text,\n" +
                    "postalCode text,\n" +
                    "complement text,\n" +
                    "FOREIGN KEY('cpf') REFERENCES WorkerDAO('cpf')\n"+
                    ");";
            assert conn != null;
            stmt = conn.prepareStatement(sqlTable);
            stmt.execute();

            String sql = "INSERT INTO worker (cpf, name, telephone, secundaryPhone, email, street," +
                    "neighborhood, city, state, number, postalCode, complement)" +
                    " values (?,?,?,?,?,?,?,?,?,?,?,?)";
            stmt = conn.prepareStatement(sql);

            stmt.setString(1, worker.getCpf());
            stmt.setString(2, worker.getName());
            stmt.setString(3, worker.getTelephone());
            stmt.setString(4, worker.getSecondaryPhone());
            stmt.setString(4, worker.getEmail());
            stmt.setString(5, worker.getAddress().getStreet());
            stmt.setString(6, worker.getAddress().getNeighborhood());
            stmt.setString(7, worker.getAddress().getCity());
            stmt.setString(8, worker.getAddress().getState());
            stmt.setString(9, worker.getAddress().getNumber());
            stmt.setString(10, worker.getAddress().getPostalCode());
            stmt.setString(11, worker.getAddress().getComplement());
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
    public boolean update(Worker worker) {
        String sql = "UPDATE worker SET name = ?, telephone = ?, secundaryPhone = ?, email = ?, street = ?, " +
                "neighborhood = ?, city = ?, " + "state = ?, number = ?, postalCode = ?, complement = ?," +
                " residenceType = ? WHERE cpf = ?";
        try (Connection conn = ConnectionFactory.getConnection()) {
            assert conn != null;
            try (PreparedStatement stmt = conn.prepareStatement(sql)) {
                stmt.setString(1, worker.getCpf());
                stmt.setString(2, worker.getName());
                stmt.setString(3, worker.getTelephone());
                stmt.setString(4, worker.getSecondaryPhone());
                stmt.setString(4, worker.getEmail());
                stmt.setString(5, worker.getAddress().getStreet());
                stmt.setString(6, worker.getAddress().getNeighborhood());
                stmt.setString(7, worker.getAddress().getCity());
                stmt.setString(8, worker.getAddress().getState());
                stmt.setString(9, worker.getAddress().getNumber());
                stmt.setString(10, worker.getAddress().getPostalCode());
                stmt.setString(11, worker.getAddress().getComplement());
                stmt.executeUpdate();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }return false;
    }

    @Override
    public Optional<Worker> getOne(String s) {
        PreparedStatement statement;
        try(Connection connection = ConnectionFactory.getConnection()){
            String sql = "SELECT * FROM worker WHERE cpf = ?";
            assert connection != null;
            statement = connection.prepareStatement(sql);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                String cpf = resultSet.getString("cpf");
                String name = resultSet.getString("name");
                String telephone = resultSet.getString("telephone");
                String secundaryTelephone = resultSet.getString("secundaryTelephone");
                String email = resultSet.getString("email");
                String street = resultSet.getString("street");
                String neighborhood = resultSet.getString("neighborhood");
                String city = resultSet.getString("city");
                String state = resultSet.getString("state");
                String number = resultSet.getString("number");
                String postalCode = resultSet.getString("postalCode");
                String complement = resultSet.getString("complement");
                Worker worker = new Worker(cpf, name, telephone, secundaryTelephone, email,
                        new Address(street, neighborhood, city, state,number, postalCode, complement));
                return Optional.of(worker);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return Optional.empty();
    }

    @Override
    public Optional<List<Worker>> getAll() {
        List<Worker> list = new ArrayList<>();
        PreparedStatement statement;
        try(Connection connection = ConnectionFactory.getConnection()){
            String sql = "SELECT * FROM worker";
            assert connection != null;
            statement = connection.prepareStatement(sql);
            ResultSet resultSet = statement.executeQuery();
            while(resultSet.next()) {
                String cpf = resultSet.getString("cpf");
                String name = resultSet.getString("name");
                String telephone = resultSet.getString("telephone");
                String secundaryTelephone = resultSet.getString("secundaryTelephone");
                String email = resultSet.getString("email");
                String street = resultSet.getString("street");
                String neighborhood = resultSet.getString("neighborhood");
                String city = resultSet.getString("city");
                String state = resultSet.getString("state");
                String number = resultSet.getString("number");
                String postalCode = resultSet.getString("postalCode");
                String complement = resultSet.getString("complement");
                Worker worker = new Worker(cpf, name, telephone, secundaryTelephone, email,
                        new Address(street, neighborhood, city, state,number, postalCode, complement));
                list.add(worker);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return Optional.of(list);
    }

    @Override
    public boolean delete(String s) {
        String sql = "DELETE FROM worker WHERE cpf = ?";
        try (Connection conn = ConnectionFactory.getConnection()) {
            assert conn != null;
            try (PreparedStatement stmt = conn.prepareStatement(sql)) {
                stmt.setString(1, s);
                stmt.execute();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }return false;
    }

    @Override
    public Optional<ArrayList<Observation>> getObservationsFromWorker(String workerId) {
        return Optional.empty();
    }

    @Override
    public Optional<ArrayList<DayOfWeekRestriction>> getDayOfWeekRestrictionFromWorker(String workerId) {
        return Optional.empty();
    }
}
