package org.kaelbastos.Persistance.HashMap;

import org.kaelbastos.Domain.Entities.Product.Product;
import org.kaelbastos.Domain.Entities.Service.Service;
import org.kaelbastos.Domain.Entities.Worker.Worker;
import org.kaelbastos.Persistance.DAOs.ServiceDAO;

import java.util.*;
import java.util.stream.Collectors;

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

    @Override
    public Optional<List<Service>> getServicesByWorker(String workerCpf) {
        return Optional.of(map.values().stream()
                .filter(service -> {
                    return service.getWorkers().stream().map(Worker::getCpf).anyMatch(cpf -> cpf.equals(workerCpf));
                }).collect(Collectors.toList()));
    }
}
