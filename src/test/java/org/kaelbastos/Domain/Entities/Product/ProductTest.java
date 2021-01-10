package org.kaelbastos.Domain.Entities.Product;

import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ProductTest {

    int id = 01;
    String name = "broom";
    float price = 5.10F;
    ProductCategory productCategory = ProductCategory.Other;

    Product product = new Product(id, name, price, productCategory);


    @Test
    void getId() {
        assertEquals(id, product.getId());
    }

    @Test
    void getName() {
        assertEquals(name, product.getName());
    }

    @Test
    void getCategory() {
        assertEquals(productCategory, product.getCategory());
    }

    @Order(1)
    @Test
    void getPrice() {
        assertEquals(price, product.getSalePrice());
    }

    @Order(2)
    @Test
    void setPrice() {
        float newPrice = 10F;
        product.setSalePrice(newPrice);
        assertEquals(newPrice, product.getSalePrice());
    }
}