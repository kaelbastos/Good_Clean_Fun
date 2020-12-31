package org.kaelbastos.Domain.entities.Service;

public class Rating {
    private String observation;
    private int nota;
    private boolean votar;

    public Rating(String observation, int nota, boolean votar) {
        this.observation = observation;
        this.nota = nota;
        this.votar = votar;
    }

    public String getObservation() {
        return observation;
    }

    public void setObservation(String observation) {
        this.observation = observation;
    }

    public int getNota() {
        return nota;
    }

    public void setNota(int nota) {
        this.nota = nota;
    }

    public boolean isVotar() {
        return votar;
    }

    public void setVotar(boolean votar) {
        this.votar = votar;
    }
}