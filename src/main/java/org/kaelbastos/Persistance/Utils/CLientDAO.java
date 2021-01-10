package org.kaelbastos.Persistance.Utils;

import org.kaelbastos.Domain.Entities.Client.Client;
import org.kaelbastos.Domain.Entities.utils.Observation;

import java.util.ArrayList;
import java.util.Optional;

public abstract class CLientDAO implements DAO<String, Client> {
    public abstract Optional<ArrayList<Observation>> getObservationsFromClient(String clientId);
}
