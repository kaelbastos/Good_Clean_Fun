package org.kaelbastos.persistance.DAOs.HashMap;

import org.kaelbastos.Domain.entities.Product.Product;
import org.kaelbastos.persistance.DAOs.DAO;
import java.util.HashMap;
import java.util.List;
import java.util.Optional;

public class ProductHashMapDAO implements DAO<String, Product> {
    private static ProductHashMapDAO dao = null;
    private final HashMap<String, Product> map;

    public ProductHashMapDAO(HashMap<String, Product> map) {
        this.map = map;
    }

    @Override
    public boolean save(Product product) {
        return false;
    }

    @Override
    public boolean update(Product product) {
        return false;
    }

    @Override
    public Optional<Product> getOne(String s) {
        return Optional.empty();
    }

    @Override
    public Optional<List<Product>> getAll() {
        return Optional.empty();
    }

    @Override
    public boolean delete(String s) {
        return false;
    }
}
