package org.kaelbastos.persistance.DAOs.HashMap;

import org.kaelbastos.Domain.entities.Product.Product;
import org.kaelbastos.persistance.Utils.DAO;
import org.kaelbastos.persistance.Utils.ProductDAO;

import java.util.HashMap;
import java.util.List;
import java.util.Optional;

public class ProductHashMapDAO extends ProductDAO {
    private final HashMap<String, Product> map = new  HashMap<String, Product>();


    @Override
    public boolean save(Product product) {
        return false;
    }

    @Override
    public boolean update(Product product) {
        return false;
    }

    @Override
    public Optional<Product> getOne(Integer productId) {
        return Optional.empty();
    }

    @Override
    public Optional<List<Product>> getAll() {
        return Optional.empty();
    }

    @Override
    public boolean delete(Integer productId) {
        return false;
    }
}
