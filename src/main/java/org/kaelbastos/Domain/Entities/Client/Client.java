package org.kaelbastos.Domain.Entities.Client;

import org.kaelbastos.Domain.Entities.utils.Address;
import org.kaelbastos.Domain.Entities.utils.Observation;
import org.kaelbastos.Domain.Entities.utils.Person;
import java.util.*;

public class Client extends Person {
    private ResidenceType residenceType;
    private final ArrayList<Observation> observations = new ArrayList<>() {};

    public Client(String cpf, String name, String telephone, String email, Address address, ResidenceType residenceType) {
        super(cpf, name, telephone, email, address);
        this.residenceType = residenceType;
    }


    public ResidenceType getResidenceType() {
        return residenceType;
    }

    public void setResidenceType(ResidenceType residenceType) {
        this.residenceType = residenceType;
    }

    public ArrayList<Observation> getObservations() {
        return observations;
    }

    public void addObservation(Observation observation){
        observations.add(observation);
    }
}