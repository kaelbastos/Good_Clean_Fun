package org.kaelbastos.view.DesktopUI.Controllers;

import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import org.kaelbastos.Domain.Entities.Client.Client;
import org.kaelbastos.Domain.Entities.Worker.Worker;
import org.kaelbastos.Domain.UseCases.WorkerUseCases.DeactivateWorker;
import org.kaelbastos.Persistance.PersistenceFacade;
import org.kaelbastos.view.DesktopUI.Windows.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class AdministrationController {

    @FXML private TableView<Client> clientsTable;
    @FXML private TableColumn<Client, String> nameClientsColumn;
    @FXML private TableColumn<Client, String> emailClientsColumn;
    @FXML private TableColumn<Client, String> cpfClientsColumn;

    @FXML private TableView<Worker> workersTable;
    @FXML private TableColumn<Worker, String> nameWorkersColumn;
    @FXML private TableColumn<Worker, String> emailWorkersColumn;
    @FXML private TableColumn<Worker, String> cpfWorkersColumn;
    @FXML private TableColumn<Worker, String> statusWorkersColumn;

    private static final List<Client> clientList = new ArrayList<>();
    private static final List<Worker> workerList = new ArrayList<>();

    public void init() {
        clientList.clear();
        workerList.clear();

        Optional<List<Client>> optionalClientList = PersistenceFacade.getInstance().getAllClient();
        optionalClientList.ifPresent(clientList::addAll);

        Optional<List<Worker>> optionalWorkerList = PersistenceFacade.getInstance().getAllWorkers();
        optionalWorkerList.ifPresent(workerList::addAll);

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
        statusWorkersColumn.setCellValueFactory(new PropertyValueFactory<>("active"));
        workersTable.setItems(FXCollections.observableArrayList(workerList));
    }

    public void addWorker() {
        WorkerWindow workerControl = new WorkerWindow();
        workerControl.showAndWait();
        init();
        clientsTable.refresh();
        workersTable.refresh();
    }

    public void addClient() {
        ClientWindow clientControl = new ClientWindow();
        clientControl.showAndWait();
        init();
        clientsTable.refresh();
        workersTable.refresh();
    }

    public void viewDetailClient() {
        DetailWindow detailControl = new DetailWindow();
        detailControl.showAndWait(clientsTable.getSelectionModel().getSelectedItem(),"Client");
        init();
        clientsTable.refresh();
        workersTable.refresh();
    }

    public void viewDetailWorker() {
        DetailWindow detailControl = new DetailWindow();
        detailControl.showAndWait(workersTable.getSelectionModel().getSelectedItem(),"Worker");
        init();
        clientsTable.refresh();
        workersTable.refresh();
    }

    public void deactivateWorker() {
        if(workersTable.getSelectionModel().getSelectedCells()!=null){
            DeactivateWorker deactivateWorker = new DeactivateWorker();
            try {
                System.out.println(deactivateWorker.deactivate(workersTable.getSelectionModel().getSelectedItem().getCpf()));
            } catch (Exception e){
                System.out.println(e.getMessage());
            }
            init();
            clientsTable.refresh();
            workersTable.refresh();
        }
    }
}
