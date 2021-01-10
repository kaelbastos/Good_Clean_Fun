package org.kaelbastos.persistance.DAOs.HashMap;

import org.kaelbastos.Domain.entities.Client.Client;
import org.kaelbastos.Domain.entities.utils.Observation;
import org.kaelbastos.persistance.PersistenceFacade;
import org.kaelbastos.persistance.Utils.CLientDAO;

import java.util.*;

public class ClientHashMapDAO extends CLientDAO {
    private final HashMap<String, Client> map = new HashMap<>();

    @Override
    public boolean save(Client client) {

        if (client != null && !map.containsKey(client.getCpf())){
            if(PersistenceFacade.getInstance().getOneWorker(client.getCpf()).isPresent())
                return false;
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

    @Override
    public Optional<ArrayList<Observation>> getObservationsFromClient(String clientId) {
        if(map.get(clientId) == null)
            return Optional.empty();
        return Optional.ofNullable(map.get(clientId).getObservations());
    }
}