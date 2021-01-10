package org.kaelbastos.Domain.Entities.Worker;

import org.kaelbastos.Domain.Entities.utils.Address;
import org.kaelbastos.Domain.Entities.utils.Observation;
import org.kaelbastos.Domain.Entities.utils.Person;

import java.util.ArrayList;
import java.util.List;

public class Worker extends Person {
    private String secondaryPhone;
    private boolean active = true;
    private final ArrayList<Observation> observations = new ArrayList<>();
    private final List<DayOfWeekRestriction> dayOfWeekRestrictions = new ArrayList<>();


    public Worker(String cpf, String name, String telephone, String secondaryPhone, String email, Address address) {
        super(cpf, name, telephone, email, address);
        this.secondaryPhone = secondaryPhone;
    }

    public String getSecondaryPhone() {
        return secondaryPhone;
    }

    public void setSecondaryPhone(String secondaryPhone) {
        this.secondaryPhone = secondaryPhone;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public List<DayOfWeekRestriction> getDayOfWeekRestrictions() {
        return dayOfWeekRestrictions;
    }

    public void addDayOfWeekRestrictions(DayOfWeekRestriction dayOfWeekRestriction) {
        this.dayOfWeekRestrictions.add(dayOfWeekRestriction);
    }

    public boolean removeDayOfWeekRestriction(DayOfWeekRestriction dayOfWeekRestriction){
        return dayOfWeekRestrictions.remove(dayOfWeekRestriction);
    }

    public ArrayList<Observation> getObservations() {
        return observations;
    }

    public void addObservation(Observation observation) {
        this.observations.add(observation);
    }

    public boolean removeObservation(Observation observation){
        return observations.remove(observation);
    }
}
