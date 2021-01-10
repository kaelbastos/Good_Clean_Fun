package org.kaelbastos.Domain.Entities.Service;

import org.kaelbastos.Domain.Entities.Client.Client;
import org.kaelbastos.Domain.Entities.Client.ClientValidator;
import org.kaelbastos.Domain.Entities.Product.Product;
import org.kaelbastos.Domain.Entities.Product.ProductValidator;
import org.kaelbastos.Domain.Entities.Worker.Worker;
import org.kaelbastos.Domain.Entities.Worker.WorkerValidator;
import org.kaelbastos.Domain.Entities.utils.Notification;
import org.kaelbastos.Domain.Entities.utils.Validator;

import java.time.LocalDateTime;
import java.util.ArrayList;

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

            ServiceEvaluation serviceEvaluation = service.getServiceEvaluation();
            if(isNotNull(serviceEvaluation)){
                Notification serviceEvaluationNotification = new ServiceEvaluationValidator().validate(serviceEvaluation);
                if(serviceEvaluationNotification.hasErrors())
                    notification.addError(serviceEvaluationNotification.getMessage());
            }

            ArrayList<Product> serviceProducts = service.getProducts();
            if(!serviceProducts.isEmpty()) {
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