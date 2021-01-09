package org.kaelbastos.persistance;

import org.kaelbastos.Domain.entities.Product.Kit;
import org.kaelbastos.Domain.entities.Product.Product;
import org.kaelbastos.Domain.entities.Service.Service;
import org.kaelbastos.persistance.DAOs.HashMap.ClientHashMapDAO;
import org.kaelbastos.persistance.DAOs.HashMap.ProductHashMapDAO;
import org.kaelbastos.persistance.DAOs.HashMap.ServiceHashMapDAO;
import org.kaelbastos.persistance.Utils.CLientDAO;
import org.kaelbastos.persistance.Utils.ProductDAO;
import org.kaelbastos.persistance.Utils.ServiceDAO;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/* in Ingrid We Trust*/
public class PersistenceFacade {
    private static PersistenceFacade instance;

    CLientDAO clientDAO = new ClientHashMapDAO();
    ProductDAO productDAO = new ProductHashMapDAO();
    ServiceDAO serviceDAO = new ServiceHashMapDAO();

    private PersistenceFacade() {}

    public static PersistenceFacade getInstance(){
        if (instance == null)
            instance = new PersistenceFacade();
        return instance;
    }

    public boolean saveService(Service service){
        return serviceDAO.save(service);
    }

    public boolean updateService(Service service){
        return serviceDAO.update(service);
    }

    public boolean deleteService(Integer serviceId){
        return serviceDAO.delete(serviceId);
    }

    public Optional<Service> getOneService(Integer service){
        return serviceDAO.getOne(service);
    }

    public Optional<List<Service>> getAllServices(){
        return serviceDAO.getAll();
    }

    public boolean saveProduct(Product product){
        return productDAO.save(product);
    }

    public boolean updateProduct(Product product){
        return productDAO.update(product);
    }

    public boolean deleteProduct(Integer product){
        return productDAO.delete(product);
    }

    public Optional<Product> getOneProduct(Integer product){
        return productDAO.getOne(product);
    }

    //TODO see
    public Optional<ArrayList<Kit>> getKitsFromProducts(){
        return null;
    }





}
