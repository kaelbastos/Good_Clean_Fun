package org.kaelbastos.view.DesktopUI.Controllers;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import org.kaelbastos.Domain.Entities.Client.Client;
import org.kaelbastos.Domain.Entities.Worker.Worker;
import org.kaelbastos.Persistance.PersistenceFacade;
import org.kaelbastos.view.DesktopUI.Windows.*;

import java.util.ArrayList;
import java.util.List;

public class AdministrationController {

    @FXML private TableView<Client> clientsTable;
    @FXML private TableColumn<Client, String> nameClientsColumn;
    @FXML private TableColumn<Client, String> emailClientsColumn;
    @FXML private TableColumn<Client, String> cpfClientsColumn;

    @FXML private TableView<Worker> workersTable;
    @FXML private TableColumn<Worker, String> nameWorkersColumn;
    @FXML private TableColumn<Worker, String> emailWorkersColumn;
    @FXML private TableColumn<Worker, String> cpfWorkersColumn;

    @FXML private Button btnAdd;
    @FXML private Button btnRemove;
    @FXML private Button btnDetails;
    @FXML private Button btnProducts;
    @FXML private Button btnServices;
    @FXML private ComboBox<String> selectChoice;

    private static List<Client> clientList = new ArrayList<>();
    private static List<Worker> workerList = new ArrayList<>();

    public void init() {
        if(PersistenceFacade.getInstance().getAllClient().isPresent())
            clientList.addAll(PersistenceFacade.getInstance().getAllClient().get());
        if(PersistenceFacade.getInstance().getAllWorkers().isPresent())
            workerList.addAll(PersistenceFacade.getInstance().getAllWorkers().get());
        bindTable();
    }

    public void bindTable() {
        nameClientsColumn.setCellValueFactory(new PropertyValueFactory<>("name"));
        emailClientsColumn.setCellValueFactory(new PropertyValueFactory<>("email"));
        cpfClientsColumn.setCellValueFactory(new PropertyValueFactory<>("cpf"));
        clientsTable.setItems(FXCollections.observableArrayList(clientList));

        nameWorkersColumn.setCellValueFactory(new PropertyValueFactory<>("name"));
        emailWorkersColumn.setCellValueFactory(new PropertyValueFactory<>("email"));
        cpfWorkersColumn.setCellValueFactory(new PropertyValueFactory<>("cpf"));
        clientsTable.setItems(FXCollections.observableArrayList(clientList));

        ObservableList<String> optionCB = FXCollections.observableArrayList();
        optionCB.addAll("Client", "Worker");
        selectChoice.setItems(optionCB);
    }

    public void addPerson(){
        if(selectChoice.getSelectionModel().getSelectedItem().equals("Client")){
            ClientWindow clientControl = new ClientWindow();
            clientControl.showAndWait();
        }else if(selectChoice.getSelectionModel().getSelectedItem().equals("Worker")){
            WorkerWindow workerControl = new WorkerWindow();
            workerControl.showAndWait();
        }
        clientsTable.refresh();
        workersTable.refresh();
    }

    public void viewDetail(){
        DetailWindow detailControl = new DetailWindow();
        if(selectChoice.getSelectionModel().getSelectedItem().equals("Client")){
            detailControl.showAndWait(clientsTable.getSelectionModel().getSelectedItem(),"Client");
        }else if(selectChoice.getSelectionModel().getSelectedItem().equals("Worker")){
            detailControl.showAndWait(workersTable.getSelectionModel().getSelectedItem(),"Worker");
        }
        clientsTable.refresh();
        workersTable.refresh();
    }

    public void viewProduct() {
        ProductWindow productControl = new ProductWindow();
        productControl.showAndWait();
    }

    public void viewServices() {
        ServiceWindow serviceControl = new ServiceWindow();
        serviceControl.showAndWait();
    }
}
