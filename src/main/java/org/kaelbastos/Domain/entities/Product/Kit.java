package org.kaelbastos.Domain.entities.Product;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class Kit extends Product {
    private List<Product> products = new ArrayList<>();

    public Kit(int id, String name, ProductCategory category) {
        super(id, name,0, category);
    }

    public boolean addProduct(Product product){
        products.add(product);
        super.setSalePrice(super.getSalePrice() + product.getSalePrice());
        return true;
    }

    public boolean removeProduct(int id){
        if(!products.isEmpty()){
            for (Product product:products) {
                if (product.getId() == id) {
                    products.remove(product);
                    return true;
                }
            }

        }
        return false;
    }

    public List<Product> getProducts(){
        return products;
    }

    @Override
    public float getSalePrice() {
        Optional<Float> sum = products.stream()
                .map(Product::getSalePrice)
                .reduce(Float::sum);
        return sum.isPresent() ? sum.get() : 0;
    }
}

