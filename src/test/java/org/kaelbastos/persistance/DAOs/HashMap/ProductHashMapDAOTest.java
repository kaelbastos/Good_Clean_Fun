package org.kaelbastos.persistance.DAOs.HashMap;

import org.junit.jupiter.api.Test;
import org.kaelbastos.Domain.entities.Product.Product;
import org.kaelbastos.Domain.entities.Product.ProductCategory;

import static org.junit.jupiter.api.Assertions.*;

class ProductHashMapDAOTest {
    Product product =
            new Product(
                    1,
                    "Detergente",
                    5.00F,
                    ProductCategory.Chemical);

    ProductHashMapDAO productHashMapDAO = new ProductHashMapDAO();

    @Test
    void saveProduct() {
        assertTrue(productHashMapDAO.save(product));
    }

    @Test
    void saveSameProductTwice() {
        assertTrue(productHashMapDAO.save(product));
        assertFalse(productHashMapDAO.save(product));
    }

    @Test
    void saveNullProduct() {
        assertFalse(productHashMapDAO.save(null));
    }

    @Test
    void updateSalePriceProduct() {
        assertTrue(productHashMapDAO.save(product));
        product.setSalePrice(9.00F);
        assertTrue(productHashMapDAO.update(product));
    }

    @Test
    void updateCategoryProduct() {
        assertTrue(productHashMapDAO.save(product));
        product.setCategory(ProductCategory.Other);
        assertTrue(productHashMapDAO.update(product));
    }

    @Test
    void deleteProduct() {
        assertTrue(productHashMapDAO.save(product));
        assertTrue(productHashMapDAO.delete(1));
    }

    @Test
    void deleteSameProductTwice() {
        assertTrue(productHashMapDAO.save(product));
        assertTrue(productHashMapDAO.delete(1));
        assertFalse(productHashMapDAO.delete(1));
    }

    @Test
    void getAllProductsWithoutProductSaved() {
        assertTrue(productHashMapDAO.getAll().get().isEmpty());
    }

    @Test
    void getNoProductFromAllProducts() {
        assertFalse(productHashMapDAO.getAll().isEmpty());
    }

    @Test
    void getOneProductWithNullKey() {
        assertFalse(productHashMapDAO.getOne(null).isPresent());
    }

    @Test
    void getNonExistingWorker() {
        assertFalse(productHashMapDAO.getOne(0).isPresent());
    }

    @Test
    void getKitsFromProducts() {
        assertTrue(productHashMapDAO.save(product));
        assertTrue(productHashMapDAO.getKitsFromProducts().isPresent());
    }

    @Test
    void getKitsFromProductsIsNull() {
        assertTrue(productHashMapDAO.save(product));
        assertFalse(productHashMapDAO.getKitsFromProducts().isEmpty());
    }
}