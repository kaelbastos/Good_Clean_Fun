package org.kaelbastos.persistance.DAOs.clientDAO;

public class ClientHashMapDAOTest {
    /*
    @Test
    public void getInstanceWithInstanceInMemory() {
        ClientHashMapDAO clientDAO1 = ClientHashMapDAO.getInstance();
        ClientHashMapDAO clientDAO2 = ClientHashMapDAO.getInstance();
        assertEquals(clientDAO1, clientDAO2);
    }

    @Test
    public void saveOneClient() {
        ClientHashMapDAO clientDAO = ClientHashMapDAO.getInstance();
        Client client = new Client("0", "batata");
        assertTrue(clientDAO.save(client));
    }

    @Test
    public void saveClientTwoTimes() {
        ClientHashMapDAO clientDAO = ClientHashMapDAO.getInstance();
        Client client = new Client("1", "batata");
        assertTrue(clientDAO.save(client));
        assertFalse(clientDAO.save(client));
    }

    @Test
    public void saveNull() {
        ClientHashMapDAO clientDAO = ClientHashMapDAO.getInstance();
        assertFalse(clientDAO.save(null));
    }

    @Test
    public void updateOneClient() {
        ClientHashMapDAO clientDAO = ClientHashMapDAO.getInstance();
        Client client = new Client("2", "batata");
        clientDAO.save(client);
        Client client2 = new Client("2", "batata");
        assertTrue(clientDAO.update(client2));
    }

    @Test
    public void updateTwoTimesConsecutively() {
        ClientHashMapDAO clientDAO = ClientHashMapDAO.getInstance();
        Client client1 = new Client("3", "batata");
        Client client2 = new Client("3", "batata");
        Client client3 = new Client("3", "batata");
        clientDAO.save(client1);
        assertTrue(clientDAO.update(client2));
        assertTrue(clientDAO.update(client3));
    }

    @Test
    public void updateAbsentClient() {
        ClientHashMapDAO clientDAO = ClientHashMapDAO.getInstance();
        Client client = new Client("4", "batata");
        assertFalse(clientDAO.update(client));
    }

    @Test
    public void updateNull() {
        ClientHashMapDAO clientDAO = ClientHashMapDAO.getInstance();
        assertFalse(clientDAO.update(null));
    }

    @Test
    public void getOne() {
        ClientHashMapDAO clientDAO = ClientHashMapDAO.getInstance();
        Client client = new Client("5", "batata");
        assertTrue(clientDAO.save(client));
        assertEquals(client, clientDAO.getOne("5"));
    }

    @Test
    public void getOne_EmptyStringParameter() {
        ClientHashMapDAO clientDAO = ClientHashMapDAO.getInstance();
        assertNull(clientDAO.getOne(""));
    }

    @Test
    public void getOne_NullStringParameter() {
        ClientHashMapDAO clientDAO = ClientHashMapDAO.getInstance();
        assertNull(clientDAO.getOne(null));
    }

    @Test
    public void getAll() {
        ClientHashMapDAO clientDAO = ClientHashMapDAO.getInstance();
        assertNotNull(clientDAO.getAll());
    }

    @Test
    public void deleteOnePreviousSaved() {
        ClientHashMapDAO clientDAO = ClientHashMapDAO.getInstance();
        Client client = new Client("6", "batata");
        clientDAO.save(client);
        assertTrue(clientDAO.delete("6"));
    }

    @Test
    public void deleteOneNotSaved() {
        ClientHashMapDAO clientDAO = ClientHashMapDAO.getInstance();
        assertFalse(clientDAO.delete("7"));
    }

    @Test
    public void deleteEmptyStringParameter() {
        ClientHashMapDAO clientDAO = ClientHashMapDAO.getInstance();
        assertFalse(clientDAO.delete(""));
    }

    @Test
    public void deleteNullStringParameter() {
        ClientHashMapDAO clientDAO = ClientHashMapDAO.getInstance();
        assertFalse(clientDAO.delete(null));
    }*/
}