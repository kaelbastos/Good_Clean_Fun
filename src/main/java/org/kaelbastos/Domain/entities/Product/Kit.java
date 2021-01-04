package org.kaelbastos.Domain.entities.Product;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class Kit extends Product {
    private List<Product> products = new ArrayList<>();

    public Kit(int id, String name, String category) {
        super(id, name,0, category);
    }

    public boolean addProduct(Product product){
        products.add(product);
        super.setPrice(super.getPrice() + product.getPrice());
        return true;
    }

    public boolean removeProduct(int id){
        for (Product product:products) {
            if (product.getId() == id) {
                products.remove(product);
                super.setPrice(super.getPrice() - product.getPrice());
            }
        }
        return true;
    }

    @Override
    public float getPrice() {
        Optional<Float> sum = products.stream()
                .map(Product::getPrice)
                .reduce(Float::sum);
        return sum.isPresent() ? sum.get() : 0;
    }
}