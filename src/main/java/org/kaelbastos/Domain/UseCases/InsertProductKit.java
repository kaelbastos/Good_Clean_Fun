package org.kaelbastos.Domain.UseCases;

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
            throw new IllegalArgumentException("Product does not exists");

        return persistenceFacade.saveProduct(product);
    }
}

