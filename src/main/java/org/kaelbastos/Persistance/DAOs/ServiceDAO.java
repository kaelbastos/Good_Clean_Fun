package org.kaelbastos.Persistance.DAOs;

import org.kaelbastos.Domain.Entities.Product.Product;
import org.kaelbastos.Domain.Entities.Service.Service;
import java.util.ArrayList;
import java.util.Optional;

public abstract class ServiceDAO implements DAO<Integer, Service> {
    public abstract Optional<ArrayList<Product>> getProductsFromService(Integer serviceId);
}
