package org.kaelbastos.Domain.entities.Product;

import org.kaelbastos.Domain.entities.utils.Notification;
import org.kaelbastos.Domain.entities.utils.Validator;

public class ProductValidator extends Validator<Product> {
    @Override
    public Notification validate(Product product) {
        Notification notification = new Notification();
        if(product != null){
            if(isNullOrEmpty(product.getName()))
                notification.addError("Name is null or empty.");

            if(product.getSalePrice() < 0)
                notification.addError("Product price is negative.");

            if(isNull(product.getCategory()))
                notification.addError("Category is null.");

        } else {
            notification.addError("Product is null.");
        }

        return notification;
    }
}
