package org.kaelbastos.view.DesktopUI.Controllers;

import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import org.kaelbastos.Domain.Entities.Service.Service;
import org.kaelbastos.Domain.UseCases.ReportUseCases.GenerateUnpaidServicesReport;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class UnpaidServicesReportController {
    @FXML private TableView<Service> tableServices;
    @FXML private TableColumn<Service, String> priceColumn,statusColumn,clientColumn;


    List<Service> report  = new ArrayList<>();
    public void init() {
        try{
            Optional<List<Service>> optionalReport = new GenerateUnpaidServicesReport().generate();
            optionalReport.ifPresent(services -> report = services);
        } catch (Exception e){
            System.out.println(e.getMessage());
        }
        bindTable();
    }

    public void bindTable() {
        priceColumn.setCellValueFactory(new PropertyValueFactory<>("totalPrice"));
        statusColumn.setCellValueFactory(new PropertyValueFactory<>("status"));
        clientColumn.setCellValueFactory(new PropertyValueFactory<>("client.getClientName()"));
        tableServices.setItems(FXCollections.observableArrayList(report));
    }
}
