package org.kaelbastos.view.DesktopUI.Controllers;

import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import org.kaelbastos.Domain.Entities.Service.ServiceCategory;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ServiceCategoryController {
    @FXML private TableView<ServiceCategory> tableCategory;
    @FXML private TableColumn<ServiceCategory, String> nameColumn;
    @FXML private TextField inputName;

    private List<ServiceCategory> serviceCategories = new ArrayList<ServiceCategory>(Arrays.asList(ServiceCategory.values()));

    public void init() {
        serviceCategories.clear();
        //serviceCategories.addAll(ServiceCategory.values());
        bindTable();
        loadTable();
    }

    private void bindTable() {
        nameColumn.setCellValueFactory(new PropertyValueFactory<>("value"));
        tableCategory.setItems(FXCollections.observableArrayList(serviceCategories));
    }

    private void loadTable() {
        /*choiceCategory.setItems(FXCollections.observableArrayList(productCategoryList));
        choiceCategoryKit.setItems(FXCollections.observableArrayList(productCategoryList));
        tableProducts.setItems(FXCollections.observableArrayList(productList));
        tableKits.setItems(FXCollections.observableArrayList(kitList));

        choiceCategoryKit.getSelectionModel().selectFirst();
        choiceCategory.getSelectionModel().selectFirst();
        tableProducts.getSelectionModel().selectFirst();
        tableKits.getSelectionModel().selectFirst();*/
    }

    public void addCategory(ActionEvent actionEvent) {
    }

    public void removeCategory(ActionEvent actionEvent) {
    }
}
