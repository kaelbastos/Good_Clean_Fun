package org.kaelbastos.persistance.Utils;

import org.kaelbastos.Domain.entities.Client.Client;
import org.kaelbastos.Domain.entities.utils.Observation;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Optional;

public abstract class CLientDAO implements DAO<String, Client> {
    public abstract Optional<ArrayList<Observation>> getObservationsFromClient(String clientId);
}
