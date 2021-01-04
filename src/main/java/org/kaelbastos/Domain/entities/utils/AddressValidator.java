package org.kaelbastos.Domain.entities.utils;

public class AddressValidator extends Validator<Address>{
    @Override
    public Notification validate(Address address) {
        Notification notification = new Notification();

        if(address != null){
            if (isNullOrEmpty(address.getStreet()))
                notification.addError("Street is null or Empty.");

            if (isNullOrEmpty(address.getNeighborhood()))
                notification.addError("Neighborhood is null or Empty.");

            if (isNullOrEmpty(address.getCity()))
                notification.addError("City is null or Empty.");

            if (isNullOrEmpty(address.getState()))
                notification.addError("State is null or Empty.");

            if (isNullOrEmpty(address.getNumber()))
                notification.addError("Number is null or Empty.");

            if (isNullOrEmpty(address.getPostalCode()))
                notification.addError("PostalCode is null or Empty.");
        } else {
            notification.addError("Address is null");
        }

        return notification;
    }
}
