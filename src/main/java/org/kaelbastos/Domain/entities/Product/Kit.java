package org.kaelbastos.Domain.entities.Product;

import java.util.ArrayList;
import java.util.List;

public class Kit extends Product {
    private List<Product> products = new ArrayList<>();

    public Kit(int id, String name, String category) {
        super(id, name, category);
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
    
    


}