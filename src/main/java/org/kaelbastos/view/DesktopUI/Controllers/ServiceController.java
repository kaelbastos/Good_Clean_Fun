package org.kaelbastos.view.DesktopUI.Controllers;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.ImageView;
import org.kaelbastos.Domain.Entities.Client.Client;
import org.kaelbastos.Domain.Entities.Product.Product;
import org.kaelbastos.Domain.Entities.Service.Service;
import org.kaelbastos.Domain.Entities.Service.ServiceCategory;
import org.kaelbastos.Domain.Entities.Service.ServiceStatus;
import org.kaelbastos.Domain.Entities.Worker.Worker;
import org.kaelbastos.Persistance.PersistenceFacade;
import org.kaelbastos.view.DesktopUI.Windows.AboutWindow;
import org.kaelbastos.view.DesktopUI.Windows.AdministrationWindow;
import org.kaelbastos.view.DesktopUI.Windows.ClientWindow;
import org.kaelbastos.view.DesktopUI.Windows.ProductWindow;

import java.awt.*;
import java.io.File;
import java.io.FileInputStream;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class ServiceController {
    @FXML private TableView<Service> tableServices;
    @FXML private TableColumn<Service, String> startColumn, endColumn, priceColumn, porcentageColumn, statusColumn, categoryColumn, clientColumn, workerColumn, productColumn;

    @FXML private ComboBox<ServiceStatus> choiceStatus;
    @FXML private ComboBox<ServiceCategory> choiceCategory;
    @FXML private ComboBox<Product> choiceProduct;
    @FXML private ComboBox<String> choiceClient;
    @FXML private ComboBox<String> choiceWorker;
    @FXML private DatePicker dataPicker;
    @FXML private ImageView imageWindow;

    @FXML private Button addService, removeService,finishService;

    @FXML private TextField inputStart, inputEnd, inputPrice, inputPorcentage;

    private static List<Service> serviceList = new ArrayList<>();
    private static List<Client> clientList = new ArrayList<>();
    private static List<Worker> workerList = new ArrayList<>();
    private static List<Product> productList = new ArrayList<>();

    private List<ServiceStatus> serviceStatusList = new ArrayList<ServiceStatus>(Arrays.asList(ServiceStatus.values()));
    //private List<ServiceCategory> serviceCategoryList = new ArrayList<ServiceCategory>(Arrays.asList(ServiceCategory.values()));

    public void init() {
        clientList.clear();
        workerList.clear();
        serviceList.clear();
        productList.clear();

        Optional<List<Client>> optionalClientList = PersistenceFacade.getInstance().getAllClient();
        optionalClientList.ifPresent(clients -> clientList.addAll(clients));

        Optional<List<Worker>> optionalWorkerList = PersistenceFacade.getInstance().getAllWorkers();
        optionalWorkerList.ifPresent(workers -> workerList.addAll(workers));

        Optional<List<Service>> optionalServiceList = PersistenceFacade.getInstance().getAllServices();
        optionalServiceList.ifPresent(services -> serviceList.addAll(services));

        Optional<List<Product>> optionalProductList = PersistenceFacade.getInstance().getAllProducts();
        optionalProductList.ifPresent(products -> productList.addAll(products));

        bindTable();
        loadTable();
    }

    private void bindTable() {
        startColumn.setCellValueFactory(new PropertyValueFactory<>("start"));
        endColumn.setCellValueFactory(new PropertyValueFactory<>("end"));
        priceColumn.setCellValueFactory(new PropertyValueFactory<>("servicePrice"));
        porcentageColumn.setCellValueFactory(new PropertyValueFactory<>("workerPercentage"));
        statusColumn.setCellValueFactory(new PropertyValueFactory<>("status"));
        categoryColumn.setCellValueFactory(new PropertyValueFactory<>("category"));
        clientColumn.setCellValueFactory(new PropertyValueFactory<>("client"));
        workerColumn.setCellValueFactory(new PropertyValueFactory<>("workers"));
        productColumn.setCellValueFactory(new PropertyValueFactory<>("products"));
    }

    private void loadTable() {
        choiceStatus.setItems(FXCollections.observableArrayList(serviceStatusList));
        //choiceCategory.setItems(FXCollections.observableArrayList(serviceCategoryList));

        choiceClient.setItems(FXCollections.observableArrayList(clientList.stream()
                .map(Client::getName)
                .collect(Collectors.toList())
        ));

        choiceWorker.setItems(FXCollections.observableArrayList(workerList.stream()
                .map(Worker::getName)
                .collect(Collectors.toList())
        ));

        choiceProduct.setItems(FXCollections.observableArrayList(productList));
        tableServices.setItems(FXCollections.observableArrayList(serviceList));

        choiceStatus.getSelectionModel().selectFirst();
        choiceCategory.getSelectionModel().selectFirst();
        choiceClient.getSelectionModel().selectFirst();
        choiceWorker.getSelectionModel().selectFirst();
        choiceProduct.getSelectionModel().selectFirst();
        tableServices.getSelectionModel().selectFirst();
    }

    public void administrationWindow(){
        AdministrationWindow administrationWindow = new AdministrationWindow();
        administrationWindow.showAndWait();
        init();
    }

    public void productWindow(){
        ProductWindow productWindow = new ProductWindow();
        productWindow.showAndWait();
    }

    public void addService(){
        LocalDateTime dateTime;
        try{
            dateTime = LocalDateTime.of(dataPicker.getValue(), LocalTime.of(Integer.parseInt(inputStart.getText()), 0));
            inputStart.setStyle("-fx-background-color: #545454");
        }catch (Exception e){
            inputStart.setStyle("-fx-background-color: #f77474");
        }
        /*
        Service newSchedule = new Service(serviceList.size()+1,
                LocalDateTime.now(),
                //LocalDateTime(dataPicker.getValue(), Integer.parseInt(inputStart.getText())),
                Float.parseFloat(priceColumn.getText()),
                Integer.parseInt(porcentageColumn.getText()),
                ServiceStatus.valueOf(statusColumn.getText()),
                ServiceCategory.valueOf(categoryColumn.getText()),
                PersistenceFacade.getInstance().getOneClient(choiceClient.getSelectionModel().getSelectedItem()),
                PersistenceFacade.getInstance().getOneWorker(choiceWorker.getSelectionModel().getSelectedItem()),
                PersistenceFacade.getInstance().getOneProduct(choiceProduct.getSelectionModel().getSelectedIndex())
        );*/

        //PersistenceFacade.getInstance().saveService(newSchedule);
        init();
        tableServices.refresh();

    }

    public void removeService(){
        PersistenceFacade.getInstance().deleteService(tableServices.getSelectionModel().getSelectedItem().getId());
        PersistenceFacade.getInstance().getOneService(tableServices.getSelectionModel().getSelectedItem().getId()).get().setStatus(ServiceStatus.Canceled);
        tableServices.refresh();
    }

    public void finishService(){
        PersistenceFacade.getInstance().getOneService(tableServices.getSelectionModel().getSelectedItem().getId()).get().setStatus(ServiceStatus.Done);
    }

    public void openAbout() {
        AboutWindow window = new AboutWindow();
        window.showAndWait();
    }
}
