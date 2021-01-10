package org.kaelbastos.Domain.entities.Product;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

class KitTest {

    int id1 = 1;
    String name1 = "vanish power o2 max";
    float price1 = 10F;
    ProductCategory productCategory1 = ProductCategory.Chemical;
    Product product1 = new Product(id1, name1, price1, productCategory1);

    int id2 = 2;
    String name2 = "omo";
    float price2 = 3F;
    ProductCategory productCategory2 = ProductCategory.Chemical;
    Product product2 = new Product(id2, name2, price2, productCategory2);

    int id3 = 3;
    String name3 = "Soap";
    float price3 = 5.10F;
    ProductCategory productCategory3 = ProductCategory.Other;
    Product product3 = new Product(id3, name3, price3, productCategory3);

    int id4 = 4;
    String name4 = "green devil";
    float price4 = 5.10F;
    ProductCategory productCategory4 = ProductCategory.Other;
    Product product4 = new Product(id4, name4, price4, productCategory4);

    int id5 = 4;
    String name5 = "Lysol";
    float price5 = 3.F;
    ProductCategory productCategory5 = ProductCategory.Chemical;
    Product product5 = new Product(id5, name5, price5, productCategory5);

    int kitId = 0;
    String kitName = "broom";
    float kitPrice = price1 + price2 + price3 + price4 + price5;
    ProductCategory kitCategory = ProductCategory.Other;
    Kit kit = new Kit(kitId, kitName, kitCategory);

    @Test
    void getProducts() {
        assertNotNull(kit.getProducts());
    }

    @Test
    void addProduct() {
        assertTrue(kit.addProduct(product1));
        assertTrue(kit.getProducts().contains(product1));
    }

    @Test
    void removeProduct() {
        assertTrue(kit.addProduct(product1));
        assertTrue(kit.getProducts().contains(product1));
        assertTrue(kit.removeProduct(product1.getId()));
        assertFalse(kit.getProducts().contains(product1));
    }

    @Test
    void removeProductWithNoProducts() {
        assertFalse(kit.removeProduct(product1.getId()));
    }

    @Test
    void getSalePrice() {
        kit.addProduct(product1);
        kit.addProduct(product2);
        kit.addProduct(product3);
        kit.addProduct(product4);
        kit.addProduct(product5);
        assertEquals(kitPrice, kit.getSalePrice());
    }
}