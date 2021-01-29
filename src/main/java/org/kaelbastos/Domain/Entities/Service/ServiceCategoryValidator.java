package org.kaelbastos.Domain.Entities.Service;

import org.kaelbastos.Domain.Entities.utils.Notification;
import org.kaelbastos.Domain.Entities.utils.Validator;

public class ServiceCategoryValidator extends Validator<ServiceCategory> {
    @Override
    public Notification validate(ServiceCategory serviceCategory) {
        Notification notification = new Notification();

        if(isNull(serviceCategory)){
            notification.addError("Service Category is Null");
        } else {
            if(serviceCategory.getId() < 0)
                notification.addError("Id is invalid");

            String categoryName = serviceCategory.getName();
            if(isNullOrEmpty(categoryName))
                notification.addError("Category name is null or empty");

            if(serviceCategory.getDuration() <= 0.5)
                notification.addError("Duration is invalid");
        }
        return notification;
    }
}
