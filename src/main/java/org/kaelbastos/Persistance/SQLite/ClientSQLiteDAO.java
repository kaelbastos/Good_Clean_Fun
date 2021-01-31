package org.kaelbastos.Persistance.SQLite;

import org.kaelbastos.Domain.Entities.Client.Client;
import org.kaelbastos.Domain.Entities.Client.ResidenceType;
import org.kaelbastos.Domain.Entities.utils.Address;
import org.kaelbastos.Domain.Entities.utils.Observation;
import org.kaelbastos.Domain.Entities.utils.Person;
import org.kaelbastos.Persistance.DAOs.CLientDAO;
import org.kaelbastos.Persistance.PersistenceFacade;
import org.kaelbastos.Persistance.SQLite.Utils.ConnectionFactory;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class ClientSQLiteDAO extends CLientDAO {
    @Override
    public Optional<ArrayList<Observation>> getObservationsFromClient(String clienteCPF) {
        List<Observation> list = new ArrayList<>();
        getObservationsFromClient(clienteCPF);

        return Optional.empty();
    }

    @Override
    public boolean save(Client client) {
        PreparedStatement stmt;
        try {
            createTableIfNotExists();
            if(!PersistenceFacade.getInstance().savePerson(client))
                return false;
            Connection conn = ConnectionFactory.getConnection();

            String sql = "INSERT INTO client (cpf, residenceType) values (?,?)";
            if (conn == null) throw new AssertionError();
            stmt = conn.prepareStatement(sql);

            stmt.setString(1, client.getCpf());
            stmt.setString(2, client.getResidenceType().value);
            stmt.execute();
            return true;

        } catch (SQLException e) {
            return false;
        }
    }

    @Override
    public boolean update(Client client) {
        String sql = "UPDATE client SET residenceType = ? WHERE cpf = ?";
        try (Connection conn = ConnectionFactory.getConnection()) {
            assert conn != null;
            PersistenceFacade.getInstance().updatePerson(client);

            try (PreparedStatement stmt = conn.prepareStatement(sql)) {
                stmt.setString(2, client.getCpf());
                stmt.setString(1, client.getResidenceType().value);
                stmt.executeUpdate();
                return true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public Optional<Client> getOne(String clienteCPF) {
        Optional<Person> person = PersistenceFacade.getInstance().getOnePerson(clienteCPF);
        if (person.isPresent()) {
            PreparedStatement statement;
            try (Connection connection = ConnectionFactory.getConnection()) {
                String sql = "SELECT * FROM client WHERE cpf = ?";
                assert connection != null;
                statement = connection.prepareStatement(sql);
                statement.setString(1, clienteCPF);
                ResultSet resultSet = statement.executeQuery();
                if (resultSet.next()) {
                    String cpf = resultSet.getString("cpf");
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
                    Client client = new Client(cpf, name, telephone, email,
                            new Address(street, neighborhood, city, state, number, postalCode, complement),
                            ResidenceType.valueOf(resultSet.getString("residenceType")));
                    return Optional.of(client);
                }
            } catch (SQLException e) {
                e.printStackTrace();
                return Optional.empty();
            }
        }return Optional.empty();
    }

    @Override
    public Optional<List<Client>> getAll() {
        PreparedStatement statement;
        try (Connection connection = ConnectionFactory.getConnection()) {
            String sql = "SELECT * FROM client";
            assert connection != null;
            statement = connection.prepareStatement(sql);
            ResultSet resultSet = statement.executeQuery();
            List<Client> list = new ArrayList<>();
            while (resultSet.next()) {
                String cpf = resultSet.getString("cpf");
                String residenceType = resultSet.getString("residenceType");
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
                    Client client = new Client(cpf, name, telephone, email,
                            new Address(street, neighborhood, city, state, number, postalCode, complement),
                            ResidenceType.valueOf(residenceType));
                    list.add(client);
                });
            }
            return Optional.of(list);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return Optional.empty();
    }


    @Override
    public boolean delete(String cpf) {
        String sql = "DELETE FROM client WHERE cpf = ?";
        PersistenceFacade.getInstance().deletePerson(cpf);
        try (Connection conn = ConnectionFactory.getConnection()) {
            assert conn != null;
            try (PreparedStatement stmt = conn.prepareStatement(sql)) {
                stmt.setString(1, cpf);
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
            String sqlTable = "CREATE TABLE IF NOT EXISTS client(\n" +
                    "cpf text NOT NULL,\n" +
                    "residenceType text\n" +
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