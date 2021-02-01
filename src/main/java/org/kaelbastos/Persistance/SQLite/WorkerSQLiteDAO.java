package org.kaelbastos.Persistance.SQLite;

import org.kaelbastos.Domain.Entities.Worker.DayOfWeekRestriction;
import org.kaelbastos.Domain.Entities.Worker.Worker;
import org.kaelbastos.Domain.Entities.utils.Address;
import org.kaelbastos.Domain.Entities.utils.Observation;
import org.kaelbastos.Domain.Entities.utils.Person;
import org.kaelbastos.Persistance.DAOs.WorkerDAO;
import org.kaelbastos.Persistance.PersistenceFacade;
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
        PreparedStatement stmt;
        try {
            createTableIfNotExists();
            if (!PersistenceFacade.getInstance().savePerson(worker))
                return false;
            Connection conn = ConnectionFactory.getConnection();

            String sql = "INSERT INTO worker (cpf, secundaryPhone) values (?,?)";
            if (conn == null) throw new AssertionError();
            stmt = conn.prepareStatement(sql);

            stmt.setString(1, worker.getCpf());
            stmt.setString(2, worker.getSecondaryPhone());
            stmt.execute();
            return true;

        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public boolean update(Worker worker) {
        String sql = "UPDATE worker SET secundaryPhone = ?  WHERE cpf = ?";
        try (Connection conn = ConnectionFactory.getConnection()) {
            assert conn != null;
            PersistenceFacade.getInstance().updatePerson(worker);

            try (PreparedStatement stmt = conn.prepareStatement(sql)) {
                stmt.setString(2, worker.getCpf());
                stmt.setString(1, worker.getSecondaryPhone());
                stmt.executeUpdate();
                return true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public Optional<Worker> getOne(String workerCPF) {
        Optional<Person> person = PersistenceFacade.getInstance().getOnePerson(workerCPF);
        if (person.isPresent()) {
            PreparedStatement statement;
            try (Connection connection = ConnectionFactory.getConnection()) {
                String sql = "SELECT * FROM worker WHERE cpf = ?";
                assert connection != null;
                statement = connection.prepareStatement(sql);
                statement.setString(1, workerCPF);
                ResultSet resultSet = statement.executeQuery();
                if (resultSet.next()) {
                    String cpf = resultSet.getString("cpf");
                    String name = person.get().getName();
                    String telephone = person.get().getTelephone();
                    String secundaryTelephone = resultSet.getString("secundaryTelephone");
                    String email = person.get().getEmail();
                    String street = person.get().getAddress().getStreet();
                    String neighborhood = person.get().getAddress().getNeighborhood();
                    String city = person.get().getAddress().getCity();
                    String state = person.get().getAddress().getState();
                    String number = person.get().getAddress().getNumber();
                    String postalCode = person.get().getAddress().getPostalCode();
                    String complement = person.get().getAddress().getComplement();
                    Worker worker = new Worker(cpf, name, telephone, secundaryTelephone, email,
                            new Address(street, neighborhood, city, state, number, postalCode, complement));
                    return Optional.of(worker);
                }
            } catch (SQLException e) {
                e.printStackTrace();
                return Optional.empty();
            }
        }
        return Optional.empty();
    }

    @Override
    public Optional<List<Worker>> getAll() {
        PreparedStatement statement;
        try (Connection connection = ConnectionFactory.getConnection()) {
            String sql = "SELECT * FROM worker";
            assert connection != null;
            statement = connection.prepareStatement(sql);
            ResultSet resultSet = statement.executeQuery();
            List<Worker> list = new ArrayList<>();
            while (resultSet.next()) {
                String cpf = resultSet.getString("cpf");
                String secundaryTelephone = resultSet.getString("secundaryTelephone");
                Optional<Person> person = PersistenceFacade.getInstance().getOnePerson(cpf);
                person.ifPresent(person1 -> {
                    String name = person.get().getName();
                    String telephone = person.get().getTelephone();
                    String email = person.get().getEmail();
                    String street = person.get().getAddress().getStreet();
                    String neighborhood = person.get().getAddress().getNeighborhood();
                    String city = person.get().getAddress().getCity();
                    String state = person.get().getAddress().getState();
                    String number = person.get().getAddress().getNumber();
                    String postalCode = person.get().getAddress().getPostalCode();
                    String complement = person.get().getAddress().getComplement();
                    Worker worker = new Worker(cpf, name, telephone, secundaryTelephone, email,
                            new Address(street, neighborhood, city, state, number, postalCode, complement));
                    list.add(worker);
                });
            }
            return Optional.of(list);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return Optional.empty();
    }

    @Override
    public boolean delete(String cpfWorker) {
        PersistenceFacade.getInstance().deletePerson(cpfWorker);
        String sql = "DELETE FROM worker WHERE cpf = ?";
        try (Connection conn = ConnectionFactory.getConnection()) {
            assert conn != null;
            try (PreparedStatement stmt = conn.prepareStatement(sql)) {
                stmt.setString(1, cpfWorker);
                stmt.execute();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public Optional<ArrayList<Observation>> getObservationsFromWorker(String workerId) {
        List<Observation> list = new ArrayList<>();
        getObservationsFromWorker(workerId);

        return Optional.empty();
    }

    @Override
    public Optional<ArrayList<DayOfWeekRestriction>> getDayOfWeekRestrictionFromWorker(String workerId) {
        return Optional.empty();
    }

    private void createTableIfNotExists() throws SQLException {
        PreparedStatement statement = null;
        try (Connection connection = ConnectionFactory.getConnection()) {
            String sqlTable = "CREATE TABLE IF NOT EXISTS worker(\n" +
                    "cpf text NOT NULL,\n" +
                    "secundaryPhone text,\n" +
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
