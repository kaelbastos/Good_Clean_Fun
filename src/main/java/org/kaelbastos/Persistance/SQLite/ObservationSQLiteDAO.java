package org.kaelbastos.Persistance.SQLite;

import org.kaelbastos.Domain.Entities.utils.Observation;
import org.kaelbastos.Domain.Entities.utils.ObservationType;
import org.kaelbastos.Domain.Entities.utils.Person;
import org.kaelbastos.Persistance.PersistenceFacade;
import org.kaelbastos.Persistance.SQLite.Utils.ConnectionFactory;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class ObservationSQLiteDAO {

    public boolean save(Observation observation,String ownerCpf) {
        PreparedStatement stmt = null;
        Connection conn = null;
        try {
            conn = ConnectionFactory.getConnection();

            String sqlTable = "CREATE TABLE observation(\n" +
                    "observationType NOT NULL,\n" +
                    "comment text,\n" +
                    "author text,\n" +
                    "owner text,\n" +
                    ");";
            assert conn != null;
            stmt = conn.prepareStatement(sqlTable);
            stmt.execute();

            String sql = "INSERT INTO observation (observationType, comment, author, owner) values (?,?,?,?)";
            stmt = conn.prepareStatement(sql);

            stmt.setString(1, observation.getObservationType().toString());
            stmt.setString(2, observation.getComment());
            stmt.setString(3, observation.getAuthor().getCpf());
            stmt.setString(4, ownerCpf);
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

    public Optional<List<Observation>> getAllByAuthor(Person author) {
        List<Observation> list = new ArrayList<>();
        PreparedStatement statement;
        try(Connection connection = ConnectionFactory.getConnection()){
            String sql = "SELECT * FROM observation WHERE author = ?";
            assert connection != null;
            statement = connection.prepareStatement(sql);
            statement.setString(1, author.getCpf());
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                String observationType = resultSet.getString("observationType");
                String comment = resultSet.getString("comment");
                Observation observation= new Observation(
                        ObservationType.valueOf(resultSet.getString("observationType")), comment,
                        author);
                list.add(observation);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return Optional.of(list);
    }

    public Optional<List<Observation>> getAllByOwner(String ownerCPF) {
        List<Observation> list = new ArrayList<>();
        PreparedStatement statement;
        try(Connection connection = ConnectionFactory.getConnection()){
            String sql = "SELECT * FROM observation WHERE owner = ?";
            assert connection != null;
            statement = connection.prepareStatement(sql);
            statement.setString(1,ownerCPF);
            ResultSet resultSet = statement.executeQuery();
            while(resultSet.next()) {
                String observationType = resultSet.getString("observationType");
                String comment = resultSet.getString("comment");
                Optional<Person> author = PersistenceFacade.getInstance().getOnePerson(resultSet.getString("author"));
                if (author.isPresent()) {
                    Observation observation = new Observation(ObservationType.valueOf(observationType),
                            comment, author.get());
                list.add(observation);
                }
            }
            return Optional.of(list);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return Optional.empty();
    }

    public boolean delete(String s) {
        String sql = "DELETE FROM observation WHERE owner = ?";
        try (Connection conn = ConnectionFactory.getConnection()) {
            assert conn != null;
            try (PreparedStatement stmt = conn.prepareStatement(sql)) {
                stmt.setString(3, s);
                stmt.execute();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }return false;
    }
}
