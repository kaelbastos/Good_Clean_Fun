package org.kaelbastos.view.CLI;


import org.kaelbastos.Domain.Entities.Product.Product;
import org.kaelbastos.Domain.Entities.Product.ProductCategory;
import org.kaelbastos.Domain.UseCases.ProductsUseCases.AlterProductKit;
import org.kaelbastos.Domain.UseCases.ProductsUseCases.InsertProductKit;
import org.kaelbastos.Persistance.PersistenceFacade;

public class ProductCLI {
    public static void run() {

        System.out.println("Product Kit");

        PersistenceFacade persistenceFacade = PersistenceFacade.getInstance();

        Product product = new Product(1, "broom", 5.10F, ProductCategory.Other);
        Product product2 = new Product(1, "vanish", 1.10F, ProductCategory.Chemical);

        System.out.println("\nInsert ProductKit");
        insertProductKit(product);
        System.out.println(product);

        System.out.println("\nAlter ProductKit");
        alterProductKit(product2);
        System.out.println(product2);

    }

    public static void insertProductKit(Product product){
        InsertProductKit insertProductKit = new InsertProductKit();
        try {
            System.out.println(insertProductKit.insert(product));
        } catch (Exception e){
            System.out.println(e.getMessage());
        }
    }

    public static void alterProductKit(Product product){
        AlterProductKit alterProductKit = new AlterProductKit();
        try {
            System.out.println(alterProductKit.alter(product));
        } catch (Exception e){
            System.out.println(e.getMessage());
        }
    }


}
