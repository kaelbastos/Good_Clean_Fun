package org.kaelbastos.Persistance.DAOs.HashMap;

import org.kaelbastos.Domain.Entities.Product.Product;
import org.kaelbastos.Domain.Entities.Service.Service;
import org.kaelbastos.Persistance.Utils.ServiceDAO;

import java.util.*;

public class ServiceHashMapDAO extends ServiceDAO {
    private final HashMap<Integer, Service> map = new HashMap<>();

    @Override
    public boolean save(Service service) {
        if(service != null && !map.containsKey(service.getId())){
            map.put(service.getId(), service);
            return true;
        }else
            return false;
    }

    @Override
    public boolean update(Service updateService) {
        if(updateService == null || !map.containsKey(updateService.getId()))
            return false;
        else
            map.replace(updateService.getId(), updateService);
            return true;
    }

    @Override
    public Optional<Service> getOne(Integer integer) {
        return Optional.ofNullable(map.get(integer));
    }

    @Override
    public Optional<List<Service>> getAll() {
        return Optional.of(new ArrayList<>(map.values()));
    }

    @Override
    public boolean delete(Integer i) {
        return map.remove(i) != null;
    }

    @Override
    public Optional<ArrayList<Product>> getProductsFromService(Integer serviceId) {
        return Optional.ofNullable(map.get(serviceId).getProducts());
    }
}
