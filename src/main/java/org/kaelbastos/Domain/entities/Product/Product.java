package org.kaelbastos.Domain.entities.Product;

public class Product {
    private int id;
    private String name;
    private float salePrice;
    private float purchasePrice;
    private ProductCategory category;

    public Product(int id, String name, float salePrice, ProductCategory category) {
        this.id = id;
        this.name = name;
        this.salePrice = salePrice;
        this.category = category;
    }

    public Product(int id, String name, float purchasePrice, float salePrice, ProductCategory category) {
        this.id = id;
        this.name = name;
        this.salePrice = salePrice;
        this.purchasePrice = purchasePrice;
        this.category = category;
    }

    public Integer getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public ProductCategory getCategory() {
        return category;
    }

    public float getSalePrice() {
        return salePrice;
    }

    protected void setSalePrice(float salePrice) {
        this.salePrice = salePrice;
    }

    public float getPurchasePrice() {
        return purchasePrice;
    }

    public void setPurchasePrice(float purchasePrice) {
        this.purchasePrice = purchasePrice;
    }
}