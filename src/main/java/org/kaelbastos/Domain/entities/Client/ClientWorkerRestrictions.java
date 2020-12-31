package org.kaelbastos.Domain.entities.Client;

public class ClientWorkerRestrictions {
    private String motive;

    public ClientWorkerRestrictions(String motive) {
        this.motive = motive;
    }

    public String getMotive() {
        return motive;
    }

    public void setMotive(String motive) {
        this.motive = motive;
    }
}
