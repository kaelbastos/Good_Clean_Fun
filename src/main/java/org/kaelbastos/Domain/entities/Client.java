package org.kaelbastos.Domain.entities;

public class Client {
    private String cpf;

    public Client(String cpf) {
        this.cpf = cpf;
    }

    public String getCpf() {
        return cpf;
    }
}
