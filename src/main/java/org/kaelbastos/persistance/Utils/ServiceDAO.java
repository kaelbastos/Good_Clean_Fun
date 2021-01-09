package org.kaelbastos.persistance.Utils;

import org.kaelbastos.Domain.entities.Product.Product;
import org.kaelbastos.Domain.entities.Service.Service;

import java.util.ArrayList;
import java.util.Optional;

public abstract class ServiceDAO implements DAO<Integer, Service> {
    public abstract Optional<ArrayList<Product>> getProductsFromService(Integer serviceId);
}
