package org.kaelbastos.persistance.DAOs.clientDAO;

import org.kaelbastos.Domain.entities.Client;
import org.kaelbastos.persistance.DAOs.DAO;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class ClientHashMapDAO implements DAO<String, Client> {
    private static ClientHashMapDAO dao = null;
    private final HashMap<String, Client> map;

    private ClientHashMapDAO() {
        map = new HashMap<>();
    }

    public static ClientHashMapDAO getInstance(){
        if (dao == null)
            dao = new ClientHashMapDAO();
        return dao;
    }

    @Override
    public boolean save(Client client) {
        if (client == null || map.containsKey(client.getCpf()))
            return false;
        else
            map.put(client.getCpf(), client);
            return true;
    }

    @Override
    public boolean update(Client updatedClient) {
        if (updatedClient == null || !map.containsKey(updatedClient.getCpf()))
            return false;
        else
            map.replace(updatedClient.getCpf(), updatedClient);
            return true;
    }

    @Override
    public Client getOne(String s) {
        return map.get(s);
    }

    @Override
    public List<Client> getAll() {
        return new ArrayList<>(map.values());
    }

    @Override
    public boolean delete(String s) {
        return map.remove(s) != null;
    }
}