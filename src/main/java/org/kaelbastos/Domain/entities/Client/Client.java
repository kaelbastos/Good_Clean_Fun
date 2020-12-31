package org.kaelbastos.Domain.entities.Client;

import org.kaelbastos.Domain.entities.Address;
import org.kaelbastos.Domain.entities.Person;

public class Client extends Person {
    private ResidenceType residenceType;
    private ClientWorkerRestrictions restrictions;

    public Client(String cpf, String name, String telephone, String email, Address address) {
        super(cpf, name, telephone, email, address);
    }


}