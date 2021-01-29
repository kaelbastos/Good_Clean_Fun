package org.kaelbastos.Domain.UseCases;

import org.kaelbastos.Domain.CustomExceptions.EntityAlreadyExistsException;
import org.kaelbastos.Domain.Entities.Product.Product;
import org.kaelbastos.Domain.Entities.Product.ProductValidator;
import org.kaelbastos.Domain.Entities.utils.Notification;
import org.kaelbastos.Persistance.PersistenceFacade;

public class InsertProductKit {
    public boolean insert(Product product){
        ProductValidator productValidator = new ProductValidator();
        Notification notification =  productValidator.validate(product);

        PersistenceFacade persistenceFacade = PersistenceFacade.getInstance();
        if(notification.hasErrors())
            throw new IllegalArgumentException(notification.getMessage());
        else if(persistenceFacade.getOneProduct(product.getId()).isPresent())
            throw new EntityAlreadyExistsException("Product");

        return persistenceFacade.saveProduct(product);
    }
}