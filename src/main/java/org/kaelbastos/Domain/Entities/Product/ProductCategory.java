package org.kaelbastos.Domain.Entities.Product;

public enum ProductCategory {
    Chemical("chemical"),
    Utensil("utensil"),
    UtensilKit("utensilKit"),
    ChemicalKit("chemicalKit"),
    Kit("kit"),
    Other("Other");

    public String value;

    ProductCategory(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
