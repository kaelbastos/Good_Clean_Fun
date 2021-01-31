package org.kaelbastos.Domain.UseCases.ProductsUseCases;

import org.kaelbastos.Domain.CustomExceptions.EntityDoesNotExistsException;
import org.kaelbastos.Persistance.PersistenceFacade;

public class DeleteProductKit {
    public boolean Delete(Integer productId) throws Exception{
        PersistenceFacade persistenceFacade = PersistenceFacade.getInstance();
        if(persistenceFacade.getOneProduct(productId).isEmpty())
            throw new EntityDoesNotExistsException("Product");
        return persistenceFacade.deleteProduct(productId);
    }
}
