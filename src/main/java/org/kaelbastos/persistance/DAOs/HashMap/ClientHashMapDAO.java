package org.kaelbastos.persistance.DAOs.HashMap;

import org.kaelbastos.Domain.entities.Client.Client;
import org.kaelbastos.persistance.DAOs.DAO;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Optional;

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
        if (client != null && !map.containsKey(client.getCpf())){
            map.put(client.getCpf(), client);
            return true;
        } else
            return false;
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
    public Optional<Client> getOne(String s) {
        return Optional.ofNullable(map.get(s));
    }

    @Override
    public Optional<List<Client>> getAll() {
        return Optional.of(new ArrayList<>(map.values()));
    }

    @Override
    public boolean delete(String s) {
        return map.remove(s) != null;
    }
}