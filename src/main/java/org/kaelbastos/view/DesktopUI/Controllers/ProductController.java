package org.kaelbastos.view.DesktopUI.Controllers;

import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import org.kaelbastos.Domain.Entities.Product.Kit;
import org.kaelbastos.Domain.Entities.Product.Product;
import org.kaelbastos.Domain.Entities.Product.ProductCategory;
import org.kaelbastos.Domain.Entities.Service.Service;
import org.kaelbastos.Domain.Entities.Service.ServiceStatus;
import org.kaelbastos.Domain.Entities.Worker.Worker;
import org.kaelbastos.Persistance.PersistenceFacade;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ProductController {
    @FXML private TableView<Product> tableProducts;
    @FXML private TableColumn<Product, String> nameProductColumn, salePriceProductColumn, purchaseProductColumn;

    @FXML private TableView<Kit> tableKits;
    @FXML private TableColumn<Kit, String> nameKitColumn, salePriceKitColumn, purchaseKitColumn;

    @FXML private TextField inputName, inputSalePrice, inputPurchasePrice;
    @FXML private ComboBox<ProductCategory> choiceCategory;

    @FXML private Button addProduct, removeProduct,addKit, removeKit;

    private static List<Product> productList = new ArrayList<>();
    private static List<Kit> kitList = new ArrayList<>();
    private List<ProductCategory> productCategoryList = new ArrayList<ProductCategory>(Arrays.asList(ProductCategory.values()));

    public void init() {
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
        tableProducts.setItems(FXCollections.observableArrayList(productList));
        tableKits.setItems(FXCollections.observableArrayList(kitList));

        choiceCategory.getSelectionModel().selectFirst();
        tableProducts.getSelectionModel().selectFirst();
        tableKits.getSelectionModel().selectFirst();
    }

    public void addProduct() {
        if(inputPurchasePrice.getText().isEmpty()){
            PersistenceFacade.getInstance().saveProduct(new Product(productList.size()+1, inputName.getText(), Float.parseFloat(inputSalePrice.getText()), choiceCategory.getSelectionModel().getSelectedItem()));
        }else{
            PersistenceFacade.getInstance().saveProduct(new Product(productList.size()+1, inputName.getText(), Float.parseFloat(inputSalePrice.getText()), Float.parseFloat(inputPurchasePrice.getText()), choiceCategory.getSelectionModel().getSelectedItem()));
        }
        init();
        tableProducts.refresh();
    }

    public void removeProduct() {
        PersistenceFacade.getInstance().deleteProduct(tableProducts.getSelectionModel().getSelectedItem().getId());
        productList.remove(tableProducts.getSelectionModel().getSelectedItem());
        init();
        tableProducts.refresh();
    }

    public void addKit() {
        tableKits.refresh();
    }

    public void removeKit() {
        PersistenceFacade.getInstance().deleteProduct(tableKits.getSelectionModel().getSelectedItem().getId());
        kitList.remove(tableKits.getSelectionModel().getSelectedItem());
        tableKits.refresh();
    }
}
