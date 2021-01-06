package org.kaelbastos.Domain.entities.Restrictions;

public class ClientWorkerRestrictions {
    private String clientCPF;
    private String clientName;
    private String workerCPF;
    private String workerName;
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
