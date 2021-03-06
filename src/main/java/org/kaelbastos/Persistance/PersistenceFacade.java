package org.kaelbastos.Persistance;

import org.kaelbastos.Domain.Entities.Client.Client;
import org.kaelbastos.Domain.Entities.Product.Kit;
import org.kaelbastos.Domain.Entities.Product.Product;
import org.kaelbastos.Domain.Entities.Service.Service;
import org.kaelbastos.Domain.Entities.Worker.DayOfWeekRestriction;
import org.kaelbastos.Domain.Entities.Worker.Worker;
import org.kaelbastos.Domain.Entities.utils.Observation;
import org.kaelbastos.Domain.Entities.utils.Person;
import org.kaelbastos.Persistance.HashMap.ClientHashMapDAO;
import org.kaelbastos.Persistance.HashMap.ProductHashMapDAO;
import org.kaelbastos.Persistance.HashMap.ServiceHashMapDAO;
import org.kaelbastos.Persistance.HashMap.WorkerHashMapDAO;
import org.kaelbastos.Persistance.DAOs.*;
import org.kaelbastos.Persistance.SQLite.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/* in Ingrid We Trust*/
public class PersistenceFacade {
    private static PersistenceFacade instance;

    CLientDAO clientDAO = new ClientHashMapDAO();
    ProductDAO productDAO = new ProductHashMapDAO();
    ServiceDAO serviceDAO = new ServiceHashMapDAO();
    WorkerDAO workerDAO = new WorkerHashMapDAO();
    PersonDAO personDAO = new PersonSQLiteDAO();

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

    public Optional<List<Service>> getServiceByWorker(String cpf) {
        return serviceDAO.getServicesByWorker(cpf);
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

    public Optional<List<Product>> getAllProducts() {
        return productDAO.getAll();
    }

    public Optional<List<Kit>> getKitsFromProducts(){
        return productDAO.getKitsFromProducts();
    }

    public boolean saveWorker(Worker worker){
        return workerDAO.save(worker);
    }

    public boolean updateWorker(Worker worker){
        return workerDAO.update(worker);
    }

    public boolean deleteWorker(String workerId){
        return workerDAO.delete(workerId);
    }

    public Optional<Worker> getOneWorker(String worker){
        return workerDAO.getOne(worker);
    }

    public Optional<List<Worker>> getAllWorkers(){
        return workerDAO.getAll();
    }

    public Optional<ArrayList<Observation>> getObservationsFromWorker(String workerId){
        return workerDAO.getObservationsFromWorker(workerId);
    }

    public Optional<ArrayList<DayOfWeekRestriction>> getDayOfWeekRestrictionFromWorker(String workerId){
        return workerDAO.getDayOfWeekRestrictionFromWorker(workerId);
    }

    public boolean saveClient(Client worker){
        return clientDAO.save(worker);
    }

    public boolean updateClient(Client worker){
        return clientDAO.update(worker);
    }

    public boolean deleteClient(String clientId){
        return clientDAO.delete(clientId);
    }

    public Optional<Client> getOneClient(String client){
        return clientDAO.getOne(client);
    }

    public Optional<List<Client>> getAllClient(){
        return clientDAO.getAll();
    }

    public Optional<ArrayList<Observation>> getObservationsFromClient(String clientId){
        return clientDAO.getObservationsFromClient(clientId);
    }

    public boolean savePerson(Person person){
        return personDAO.save(person);
    }

    public boolean updatePerson(Person person){
        return personDAO.update(person);
    }

    public boolean deletePerson(String personCPF){
        return personDAO.delete(personCPF);
    }

    public Optional<Person> getOnePerson(String personCPF){
        return personDAO.getOne(personCPF);
    }

    public Optional<List<Person>> getAllPerson(){
        return personDAO.getAll();
    }
}