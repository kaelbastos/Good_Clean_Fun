package org.kaelbastos.persistance.DAOs.HashMap;

import org.kaelbastos.Domain.entities.Product.Kit;
import org.kaelbastos.Domain.entities.Product.Product;
import org.kaelbastos.persistance.Utils.ProductDAO;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Optional;

public class ProductHashMapDAO extends ProductDAO {
    private final HashMap<Integer, Product> map = new HashMap<>();

    @Override
    public boolean save(Product product) {
        if(product != null && !map.containsKey(product.getId())){
            map.put(product.getId(), product);
            return true;
        }else
            return false;
    }

    @Override
    public boolean update(Product updateProduct) {
        if(updateProduct == null || map.containsKey(updateProduct.getId()))
            return false;
        else
            map.replace(updateProduct.getId(), updateProduct);
            return true;
    }

    @Override
    public Optional<Product> getOne(Integer productId) {
        return Optional.ofNullable(map.get(productId));
    }

    @Override
    public Optional<List<Product>> getAll() {
        return Optional.of(new ArrayList<>(map.values()));
    }

    @Override
    public boolean delete(Integer productId) {
        return map.remove(productId) != null;
    }

    //REVER
    @Override
    public Optional<ArrayList<Kit>> getKitsFromProducts() {
        //Optional<ArrayList<Kit>> kits = (Optional<ArrayList<Kit>>)map.values().stream()
                //.filter(value -> value instanceof Kit)
                //.map(value -> (Kit) value)
                //.collect(Collectors.toList());
        return Optional.empty();
    }
}
