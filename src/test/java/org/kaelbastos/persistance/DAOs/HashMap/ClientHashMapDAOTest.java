package org.kaelbastos.persistance.DAOs.HashMap;

import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.NullSource;
import org.kaelbastos.Domain.entities.Client.Client;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

class ClientHashMapDAOTest {
    ClientHashMapDAO clientHashMapDAO = new ClientHashMapDAO();
    Client client = new Client("000", "name", "00", "email", null, null);

    @Test
    void save() {
        assertTrue(clientHashMapDAO.save(new Client("000", "name", "00", "email", null, null)));
    }

    @Test
    void saveNull() {
        assertFalse(clientHashMapDAO.save(null));
    }

    @Test
    void saveTheSameClientTwice() {
        assertTrue(clientHashMapDAO.save(client));
        assertFalse(clientHashMapDAO.save(client));
    }

    @Test
    void update() {
        assertTrue(clientHashMapDAO.save(client));
        client.setEmail("new Email");
        assertTrue(clientHashMapDAO.update(client));
    }

    @Test
    void updateNull() {
        assertFalse(clientHashMapDAO.update(null));
    }

    @Test
    void updateNonExistingClient() {
        assertFalse(clientHashMapDAO.update(client));
    }

    @Test
    void getOne() {
        clientHashMapDAO.save(client);
        assertTrue(clientHashMapDAO.getOne("000").isPresent());
    }

    @Test
    void getOneWithNonExistingId() {
        assertFalse(clientHashMapDAO.getOne("1").isPresent());
    }

    @Test
    void getAll() {
        clientHashMapDAO.save(client);
        assertFalse(clientHashMapDAO.getAll().get().isEmpty());
    }

    @Test
    void delete() {
        clientHashMapDAO.save(client);
        assertTrue(clientHashMapDAO.delete(client.getCpf()));
    }

    @Test
    void deleteWithNonExistingId() {
        assertFalse(clientHashMapDAO.delete("1"));
    }

    @Test
    void getObservationsFromClient() {
        clientHashMapDAO.save(client);
        assertTrue(clientHashMapDAO.getObservationsFromClient(client.getCpf()).get().isEmpty());
    }

    @Test
    void getObservationsFromNonExistingClient() {
        assertTrue(clientHashMapDAO.getObservationsFromClient("1").isEmpty());
    }
}