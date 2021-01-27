package org.kaelbastos.Domain.Entities.utils;

public class PersonValidator extends Validator<Person> {
    @Override
    public Notification validate(Person person) {
        Notification notification = new Notification();
        if (isNull(person)) {
            notification.addError("Person is null");
            return notification;
        }

        String personCpf = person.getCpf();
        if (isNullOrEmpty(personCpf) || !checkCPFFormat(personCpf))
            notification.addError("CPF null, empty or not formatted.");

        String personName = person.getName();
        if (isNullOrEmpty(personName))
            notification.addError("Name is null or empty.");

        String personTelephone = person.getTelephone();
        if (isNullOrEmpty(personTelephone) || !checkPhoneFormat(personTelephone))
            notification.addError("Telephone null, empty or not formatted.");

        String personEmail = person.getEmail();
        if (isNullOrEmpty(personEmail) || !checkEmailFormat(personEmail))
            notification.addError("Email null, empty or not formatted.");

        Address personAddress = person.getAddress();
        Validator<Address> addressValidator = new AddressValidator();
        Notification addressValidatorNotification = addressValidator.validate(personAddress);
        if (addressValidatorNotification.hasErrors())
            notification.addError(addressValidatorNotification.getMessage());

        return notification;
    }

    public boolean checkPhoneFormat(String telephone) {
        if (telephone != null) {
            int length = telephone.length();
            if (telephone.matches("^[0-9]{11}$")) {
                return true;
            } else {
                return false;
            }
        } else {
            return false;
        }
    }

    public boolean checkEmailFormat(String email) {
        if (email != null && email.matches("^[\\w-_\\.+]*[\\w-_\\.]\\@([\\w]+\\.)+[\\w]+[\\w]$")) {
            return true;
        } else {
            return false;
        }
    }

    public boolean checkCPFFormat(String cpf) {
        if (cpf != null && cpf.matches("^[0-9]{11}$")) {
            return true;
        } else {
            return false;
        }
    }
}
