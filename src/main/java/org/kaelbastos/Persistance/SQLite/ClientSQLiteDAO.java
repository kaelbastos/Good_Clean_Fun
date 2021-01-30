package org.kaelbastos.Persistance.SQLite;

import org.kaelbastos.Domain.Entities.Client.Client;
import org.kaelbastos.Domain.Entities.Client.ResidenceType;
import org.kaelbastos.Domain.Entities.utils.Address;
import org.kaelbastos.Domain.Entities.utils.Observation;
import org.kaelbastos.Persistance.DAOs.CLientDAO;
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
    public Optional<ArrayList<Observation>> getObservationsFromClient(String clientId) {
        return Optional.empty();
    }

    @Override
    public boolean save(Client client) {
        PreparedStatement stmt = null;
        Connection conn = null;
        try {
            conn = ConnectionFactory.getConnection();

            String sqlTable = "CREATE TABLE IF NOT EXISTS client(\n" +
                    "cpf text NOT NULL,\n"+
                    "name text NOT NULL,\n" +
                    "telephone text,\n" +
                    "email text,\n" +
                    "street text,\n" +
                    "neighborhood text,\n" +
                    "city text,\n" +
                    "state text,\n" +
                    "number text,\n" +
                    "postalCode text,\n" +
                    "complement text,\n" +
                    "residenceType text,\n" +
                    "FOREIGN KEY('cpf') REFERENCES ClientDAO('cpf')\n"+
                    ");";
            assert conn != null;
            stmt = conn.prepareStatement(sqlTable);
            stmt.execute();

            String sql = "INSERT INTO client (cpf, name, telephone, email, street, neighborhood, city, state," +
                    "number, postalCode, complement, residenceType) values (?,?,?,?,?,?,?,?,?,?,?,?)";
            stmt = conn.prepareStatement(sql);

            stmt.setString(1, client.getCpf());
            stmt.setString(2, client.getName());
            stmt.setString(3, client.getTelephone());
            stmt.setString(4, client.getEmail());
            stmt.setString(5, client.getAddress().getStreet());
            stmt.setString(6, client.getAddress().getNeighborhood());
            stmt.setString(7, client.getAddress().getCity());
            stmt.setString(8, client.getAddress().getState());
            stmt.setString(9, client.getAddress().getNumber());
            stmt.setString(10, client.getAddress().getPostalCode());
            stmt.setString(11, client.getAddress().getComplement());
            stmt.setString(12, client.getResidenceType().value);
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
    public boolean update(Client client) {
        String sql = "UPDATE client SET name = ?, telephone = ?, email = ?, street = ?, neighborhood = ?, city = ?, " +
                "state = ?, number = ?, postalCode = ?, complement = ?, residenceType = ? WHERE cpf = ?";
        try (Connection conn = ConnectionFactory.getConnection()) {
            assert conn != null;
            try (PreparedStatement stmt = conn.prepareStatement(sql)) {
                stmt.setString(1, client.getCpf());
                stmt.setString(2, client.getName());
                stmt.setString(3, client.getTelephone());
                stmt.setString(4, client.getEmail());
                stmt.setString(5, client.getAddress().getStreet());
                stmt.setString(6, client.getAddress().getNeighborhood());
                stmt.setString(7, client.getAddress().getCity());
                stmt.setString(8, client.getAddress().getState());
                stmt.setString(9, client.getAddress().getNumber());
                stmt.setString(10, client.getAddress().getPostalCode());
                stmt.setString(11, client.getAddress().getComplement());
                stmt.setString(12, client.getResidenceType().value);
                stmt.executeUpdate();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }return false;
    }

    @Override
    public Optional<Client> getOne(String s) {
        PreparedStatement statement = null;
        try(Connection connection = ConnectionFactory.getConnection()){
            String sql = "SELECT * FROM client WHERE cpf = ?";
            assert connection != null;
            statement = connection.prepareStatement(sql);
            ResultSet resultSet = statement.executeQuery();
            while(resultSet.next()) {
                String cpf = resultSet.getString("cpf");
                String name = resultSet.getString("name");
                String telephone = resultSet.getString("telephone");
                String email = resultSet.getString("email");
                String street = resultSet.getString("street");
                String neighborhood = resultSet.getString("neighborhood");
                String city = resultSet.getString("city");
                String state = resultSet.getString("state");
                String number = resultSet.getString("number");
                String postalCode = resultSet.getString("postalCode");
                String complement = resultSet.getString("complement");
                /*String residenceType = resultSet.getString("residenceType");*/
                Client client = new Client(cpf, name, telephone, email,
                        new Address(street, neighborhood, city, state,number, postalCode, complement),
                        /*new ResidenceType("1","sjaijsi")*/;
                        ;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return Optional.ofNullable();
    }

    @Override
    public Optional<List<Client>> getAll() {
        List<Client> list = new ArrayList<>();
        PreparedStatement statement = null;
        try(Connection connection = ConnectionFactory.getConnection()){
            String sql = "SELECT * FROM client";
            assert connection != null;
            statement = connection.prepareStatement(sql);
            ResultSet resultSet = statement.executeQuery();
            while(resultSet.next()) {
                String cpf = resultSet.getString("cpf");
                String name = resultSet.getString("name");
                String telephone = resultSet.getString("telephone");
                String email = resultSet.getString("email");
                String street = resultSet.getString("street");
                String neighborhood = resultSet.getString("neighborhood");
                String city = resultSet.getString("city");
                String state = resultSet.getString("state");
                String number = resultSet.getString("number");
                String postalCode = resultSet.getString("postalCode");
                String complement = resultSet.getString("complement");
                /*String residenceType = resultSet.getString("residenceType");*/
                Client client = new Client(cpf, name, telephone, email,
                        new Address(street, neighborhood, city, state,number, postalCode, complement),
                        /*new ResidenceType("1","sjaijsi")*/;
                list.add(client);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return Optional.of(list);
    }

    @Override
    public boolean delete(String cpf) {
        String sql = "DELETE FROM client WHERE cpf = ?";
        try (Connection conn = ConnectionFactory.getConnection()) {
            assert conn != null;
            try (PreparedStatement stmt = conn.prepareStatement(sql)) {
                stmt.setString(1, cpf);
                stmt.execute();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }return false;
    }
}