package org.kaelbastos.view.DesktopUI.Controllers;

import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import org.kaelbastos.Domain.Entities.Client.Client;
import org.kaelbastos.Domain.Entities.Service.ServiceCategory;
import org.kaelbastos.Domain.Entities.utils.Address;
import org.kaelbastos.Domain.UseCases.ClientUseCases.InsertClient;
import org.kaelbastos.Persistance.PersistenceFacade;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public class ServiceCategoryController {
    @FXML private TableView<ServiceCategory> tableCategory;
    @FXML private TableColumn<ServiceCategory, String> idColumn, nameColumn, durationColumn;
    @FXML private TextField inputName, inputDuration;

    private static List<ServiceCategory> serviceCategories = new ArrayList<>();
    //private List<ServiceCategory> serviceCategories = new ArrayList<ServiceCategory>(Arrays.asList(ServiceCategory.values()));

    public void init() {
        serviceCategories.clear();

        //Optional<List<ServiceCategory>> optionalServiceCategoryList = PersistenceFacade.getInstance().getAllServiceCategories();
        //optionalServiceCategoryList.ifPresent(servicesCategory -> serviceCategories.addAll(servicesCategory));

        bindTable();
    }

    private void bindTable() {
        idColumn.setCellValueFactory(new PropertyValueFactory<>("id"));
        nameColumn.setCellValueFactory(new PropertyValueFactory<>("name"));
        durationColumn.setCellValueFactory(new PropertyValueFactory<>("duration"));
        tableCategory.setItems(FXCollections.observableArrayList(serviceCategories));
    }

    public void addCategory(ActionEvent actionEvent) {
        ServiceCategory serviceCategory = new ServiceCategory(serviceCategories.size()+1, inputName.getText(), Double.parseDouble(inputDuration.getText()));
        //InsertServiceCategory insertServiceCategory = new InsertServiceCategory();
        try {
            //System.out.println(insertCategory.insert(serviceCategory));
        } catch (Exception e){
            System.out.println(e.getMessage());
        }
        inputName.setText("");
        inputDuration.setText("");
        init();
    }

}
