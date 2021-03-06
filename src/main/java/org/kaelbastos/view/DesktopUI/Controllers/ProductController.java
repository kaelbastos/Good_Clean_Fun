package org.kaelbastos.view.DesktopUI.Controllers;

import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import org.kaelbastos.Domain.Entities.Product.Kit;
import org.kaelbastos.Domain.Entities.Product.Product;
import org.kaelbastos.Domain.Entities.Product.ProductCategory;
import org.kaelbastos.Domain.UseCases.ProductsUseCases.DeleteProductKit;
import org.kaelbastos.Domain.UseCases.ProductsUseCases.InsertProductKit;
import org.kaelbastos.Persistance.PersistenceFacade;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ProductController {
    @FXML private TableView<Product> tableProducts;
    @FXML private TableColumn<Product, String> nameProductColumn, salePriceProductColumn, purchaseProductColumn;

    @FXML private TableView<Kit> tableKits;
    @FXML private TableColumn<Kit, String> nameKitColumn, salePriceKitColumn, purchaseKitColumn;

    @FXML private TextField inputName, inputSalePrice, inputPurchasePrice, inputNameKit;
    @FXML private ComboBox<ProductCategory> choiceCategory, choiceCategoryKit;

    @FXML private ImageView imageWindow;

    private static final List<Product> productList = new ArrayList<>();
    private static final List<Kit> kitList = new ArrayList<>();
    private final List<ProductCategory> productCategoryList = new ArrayList<>(Arrays.asList(ProductCategory.values()));

    public void init() {
        Image img = new Image(getClass().getResourceAsStream("../images/box.png"));
        imageWindow.setImage(img);

        productList.clear();
        kitList.clear();
        if (PersistenceFacade.getInstance().getAllProducts().isPresent() &&
                PersistenceFacade.getInstance().getKitsFromProducts().isPresent()){
            productList.addAll(PersistenceFacade.getInstance().getAllProducts().get());
            kitList.addAll(PersistenceFacade.getInstance().getKitsFromProducts().get());
        }
        bindTable();
        loadTable();
    }

    private void bindTable() {
        nameProductColumn.setCellValueFactory(new PropertyValueFactory<>("name"));
        salePriceProductColumn.setCellValueFactory(new PropertyValueFactory<>("salePrice"));
        purchaseProductColumn.setCellValueFactory(new PropertyValueFactory<>("purchasePrice"));

        nameKitColumn.setCellValueFactory(new PropertyValueFactory<>("name"));
        salePriceKitColumn.setCellValueFactory(new PropertyValueFactory<>("salePrice"));
        purchaseKitColumn.setCellValueFactory(new PropertyValueFactory<>("purchasePrice"));
    }

    private void loadTable() {
        choiceCategory.setItems(FXCollections.observableArrayList(productCategoryList));
        choiceCategoryKit.setItems(FXCollections.observableArrayList(productCategoryList));
        tableProducts.setItems(FXCollections.observableArrayList(productList));
        tableKits.setItems(FXCollections.observableArrayList(kitList));

        choiceCategoryKit.getSelectionModel().selectFirst();
        choiceCategory.getSelectionModel().selectFirst();
        tableProducts.getSelectionModel().selectFirst();
        tableKits.getSelectionModel().selectFirst();

        tableProducts.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);
    }

    public void addProduct() {
        Product product;
        if(inputPurchasePrice.getText().isEmpty()){
            product = new Product(productList.size()+1, inputName.getText(), Float.parseFloat(inputSalePrice.getText()), choiceCategory.getSelectionModel().getSelectedItem());
        }else{
            product = new Product(productList.size()+1, inputName.getText(), Float.parseFloat(inputSalePrice.getText()), Float.parseFloat(inputPurchasePrice.getText()), choiceCategory.getSelectionModel().getSelectedItem());
        }

        InsertProductKit insertProductKit = new InsertProductKit();
        try {
            insertProductKit.insert(product);
            init();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        inputName.clear();
        inputSalePrice.clear();
        inputPurchasePrice.clear();
        tableProducts.refresh();
    }

    public void removeProduct() {
        DeleteProductKit deleteProductKit = new DeleteProductKit();
        try {
            deleteProductKit.delete(tableProducts.getSelectionModel().getSelectedItem().getId());
        } catch (Exception e){
            System.out.println(e.getMessage());
        }
        tableKits.refresh();
    }

    public void addKit() {
        Kit newKit = new Kit(kitList.size()+1, inputNameKit.getText(), choiceCategoryKit.getSelectionModel().getSelectedItem());
        for (Product p:tableProducts.getSelectionModel().getSelectedItems()){
            newKit.addProduct(p);
        }
        PersistenceFacade.getInstance().saveProduct(newKit);
        
        init();
        inputNameKit.setText("");
        tableKits.refresh();
    }

    public void removeKit() {
        DeleteProductKit deleteProductKit = new DeleteProductKit();
        try {
            deleteProductKit.delete(tableKits.getSelectionModel().getSelectedItem().getId());
        } catch (Exception e){
            System.out.println(e.getMessage());
        }
        tableKits.refresh();
    }
}
