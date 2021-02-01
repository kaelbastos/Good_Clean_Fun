package org.kaelbastos.Persistance.SQLite;

import org.kaelbastos.Domain.Entities.utils.Address;
import org.kaelbastos.Domain.Entities.utils.Person;
import org.kaelbastos.Persistance.DAOs.PersonDAO;
import org.kaelbastos.Persistance.SQLite.Utils.ConnectionFactory;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class PersonSQLiteDAO extends PersonDAO {

    @Override
    public boolean save(Person person) {
        PreparedStatement stmt;
        try {
            createTableIfNotExists();
            Connection conn = ConnectionFactory.getConnection();

            String sql = "INSERT INTO person (cpf, name, telephone, email, street, neighborhood, city, state," +
                    "number, postalCode, complement) values (?,?,?,?,?,?,?,?,?,?,?)";
            stmt = conn.prepareStatement(sql);

            stmt.setString(1, person.getCpf());
            stmt.setString(2, person.getName());
            stmt.setString(3, person.getTelephone());
            stmt.setString(4, person.getEmail());
            stmt.setString(5, person.getAddress().getStreet());
            stmt.setString(6, person.getAddress().getNeighborhood());
            stmt.setString(7, person.getAddress().getCity());
            stmt.setString(8, person.getAddress().getState());
            stmt.setString(9, person.getAddress().getNumber());
            stmt.setString(10, person.getAddress().getPostalCode());
            stmt.setString(11, person.getAddress().getComplement());
            stmt.execute();
            return true;
        } catch (SQLException e) {
            return false;
        }
    }

    @Override
    public boolean update(Person person) {
        String sql = "UPDATE person SET name = ?, telephone = ?, email = ?, street = ?, neighborhood = ?, city = ?, " +
                "state = ?, number = ?, postalCode = ?, complement = ? WHERE cpf = ?";
        try (Connection conn = ConnectionFactory.getConnection()) {
            try (PreparedStatement stmt = conn.prepareStatement(sql)) {
                stmt.setString(1, person.getCpf());
                stmt.setString(2, person.getName());
                stmt.setString(3, person.getTelephone());
                stmt.setString(4, person.getEmail());
                stmt.setString(5, person.getAddress().getStreet());
                stmt.setString(6, person.getAddress().getNeighborhood());
                stmt.setString(7, person.getAddress().getCity());
                stmt.setString(8, person.getAddress().getState());
                stmt.setString(9, person.getAddress().getNumber());
                stmt.setString(10, person.getAddress().getPostalCode());
                stmt.setString(11, person.getAddress().getComplement());
                stmt.execute();
                return true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public Optional<Person> getOne(String cpfPerson) {
            PreparedStatement statement;
            try (Connection connection = ConnectionFactory.getConnection()) {
                String sql = "SELECT * FROM person WHERE cpf = ?";
                assert connection != null;
                statement = connection.prepareStatement(sql);
                ResultSet resultSet = statement.executeQuery();
                if (resultSet.next()) {
                    String cpf = resultSet.getString("cpf");
                    String name = resultSet.getString("name");
                    String telephone = resultSet.getString("telephone");
                    String email = resultSet.getString("email");
                    String street = resultSet.getString("street");
                    String neighborhood = resultSet.getString("cpf");
                    String city = resultSet.getString("city");
                    String state = resultSet.getString("state");
                    String number = resultSet.getString("number");
                    String postalCode = resultSet.getString("postalCode");
                    String complement = resultSet.getString("complement");
                    Person person = new Person(cpf, name, telephone, email,
                            new Address(street, neighborhood, city, state, number, postalCode, complement));
                    return Optional.of(person);
                }
            } catch (SQLException e) {
                e.printStackTrace();
                return Optional.empty();
            }
            return Optional.empty();
        }

    @Override
    public Optional<List<Person>> getAll() {
        PreparedStatement statement;
        try (Connection connection = ConnectionFactory.getConnection()) {
            String sql = "SELECT * FROM person";
            assert connection != null;
            statement = connection.prepareStatement(sql);
            ResultSet resultSet = statement.executeQuery();
            List<Person> list = new ArrayList<>();
            while (resultSet.next()) {
                String cpf = resultSet.getString("cpf");
                String name = resultSet.getString("name");
                String telephone = resultSet.getString("telephone");
                String email = resultSet.getString("email");
                String street = resultSet.getString("street");
                String neighborhood = resultSet.getString("cpf");
                String city = resultSet.getString("city");
                String state = resultSet.getString("state");
                String number = resultSet.getString("number");
                String postalCode = resultSet.getString("postalCode");
                String complement = resultSet.getString("complement");
                Person person = new Person(cpf, name, telephone, email,
                        new Address(street, neighborhood, city, state, number, postalCode, complement));
                list.add(person);
            }
            return Optional.of(list);

        }catch (SQLException e) {
            e.printStackTrace();
            return Optional.empty();
        }
    }

    @Override
    public boolean delete(String cpf) {
        String sql = "DELETE FROM person WHERE cpf = ?";
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
            String sqlTable = "CREATE TABLE IF NOT EXISTS person(\n" +
                    "cpf text NOT NULL,\n" +
                    "name text NOT NULL,\n" +
                    "telephone text,\n" +
                    "email text,\n" +
                    "street text,\n" +
                    "neighborhood text,\n" +
                    "city text,\n" +
                    "state text,\n" +
                    "number text,\n" +
                    "postalCode text,\n" +
                    "complement text\n" +
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
