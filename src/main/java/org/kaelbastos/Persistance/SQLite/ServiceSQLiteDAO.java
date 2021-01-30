package org.kaelbastos.Persistance.SQLite;

import org.kaelbastos.Domain.Entities.Client.Client;
import org.kaelbastos.Domain.Entities.Product.Product;
import org.kaelbastos.Domain.Entities.Service.Service;
import org.kaelbastos.Domain.Entities.Service.ServiceCategory;
import org.kaelbastos.Domain.Entities.Service.ServiceStatus;
import org.kaelbastos.Domain.Entities.Worker.Worker;
import org.kaelbastos.Persistance.DAOs.ServiceDAO;
import org.kaelbastos.Persistance.SQLite.Utils.ConnectionFactory;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class ServiceSQLiteDAO extends ServiceDAO {
    @Override
    public boolean save(Service service) {
        return false;
    }

    @Override
    public boolean update(Service service) {
        return false;
    }

    @Override
    public Optional<Service> getOne(Integer integer) {
        return Optional.empty();
    }

    @Override
    public Optional<List<Service>> getAll() {
        return Optional.empty();
    }

    @Override
    public boolean delete(Integer integer) {
        return false;
    }

    @Override
    public Optional<ArrayList<Product>> getProductsFromService(Integer serviceId) {
        return Optional.empty();
    }
}
