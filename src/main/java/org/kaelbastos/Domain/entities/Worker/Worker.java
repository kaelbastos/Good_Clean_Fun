package org.kaelbastos.Domain.entities.Worker;

import org.kaelbastos.Domain.entities.Address;
import org.kaelbastos.Domain.entities.Person;

public class Worker extends Person {
    private String secondaryPhone;
    private boolean active = true;


    public Worker(String cpf, String name, String telephone, String secondaryPhone, String email, Address address) {
        super(cpf, name, telephone, email, address);

    }
}
