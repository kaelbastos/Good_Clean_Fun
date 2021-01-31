package org.kaelbastos.Domain.UseCases.ServiceUseCases;

import org.kaelbastos.Domain.CustomExceptions.EntityAlreadyExistsException;
import org.kaelbastos.Domain.Entities.Service.ServiceCategory;
import org.kaelbastos.Domain.Entities.Service.ServiceCategoryValidator;
import org.kaelbastos.Domain.Entities.utils.Notification;
import org.kaelbastos.Persistance.PersistenceFacade;

public class CreateServiceCategory {
    public boolean create (ServiceCategory serviceCategory){
        ServiceCategoryValidator validator = new ServiceCategoryValidator();
        Notification notification = validator.validate(serviceCategory);
        
        if (notification.hasErrors())
            throw new IllegalArgumentException(notification.getMessage());
        
        //if (PersistenceFacade.getOneServiceCategory(serviceCategory.getId()).isPresent())
         //   throw new EntityAlreadyExistsException("Service Category");
        //TODO
        //return PersistenceFacade.getInstance().saveServiceCategory(serviceCategory);
        return true;
    }
}
