package org.kaelbastos.Domain.entities.Service;

import org.kaelbastos.Domain.entities.Client.Client;
import org.kaelbastos.Domain.entities.Client.ClientValidator;
import org.kaelbastos.Domain.entities.Product.Product;
import org.kaelbastos.Domain.entities.Product.ProductValidator;
import org.kaelbastos.Domain.entities.Worker.Worker;
import org.kaelbastos.Domain.entities.Worker.WorkerValidator;
import org.kaelbastos.Domain.entities.utils.Notification;
import org.kaelbastos.Domain.entities.utils.Validator;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;

public class ServiceValidator extends Validator<Service> {
    @Override
    public Notification validate(Service service) {
        Notification notification = new Notification();
        if(isNotNull(service)){
            int serviceId = service.getId();
            if(serviceId < 0)
                notification.addError("ID is invalid.");

            LocalDateTime serviceStart = service.getStart();
            if (isNull(serviceStart))
                notification.addError("Start is null.");

            LocalDateTime serviceEnd = service.getEnd();
            if(isNull(serviceEnd))
                notification.addError("End is null.");

            if(serviceStart.isAfter(serviceEnd))
                notification.addError("Start is after End.");

            if(serviceStart.equals(serviceEnd))
                notification.addError("Start and end are at the same time.");

            float servicePrice = service.getServicePrice();
            if(servicePrice < 0)
                notification.addError("Service Price is invalid.");

            int workerPercentage = service.getWorkerPercentage();
            if(workerPercentage < 0 || workerPercentage > 100)
                notification.addError("Worker percentage is invalid.");

            ServiceCategory serviceCategory = service.getCategory();
            if(isNull(serviceCategory))
                notification.addError("Category is null.");

            ServiceStatus serviceStatus = service.getStatus();
            if(isNull(serviceStatus))
                notification.addError("Status is null.");

            ArrayList<Product> serviceProducts = service.getProducts();
            if(serviceProducts.isEmpty()) {
                notification.addError("Products is empty.");
            } else {
                serviceProducts.stream()
                        .map(product -> new ProductValidator().validate(product))
                        .filter(Notification::hasErrors)
                        .map(Notification::getMessage)
                        .forEach(notification::addError);
            }

            ArrayList<Worker> serviceWorkers = service.getWorkers();
            if(serviceWorkers.isEmpty()) {
                notification.addError("Workers is empty.");
            } else {
                serviceWorkers.stream()
                        .map(worker -> new WorkerValidator().validate(worker))
                        .filter(Notification::hasErrors)
                        .map(Notification::getMessage)
                        .forEach(notification::addError);
            }

            Client serviceClient = service.getClient();
            Notification clientValidatorNotification = new ClientValidator().validate(serviceClient);
            if(clientValidatorNotification.hasErrors())
                notification.addError(clientValidatorNotification.getMessage());

        } else {
            notification.addError("Service is null.");
        }

        return notification;
    }
}