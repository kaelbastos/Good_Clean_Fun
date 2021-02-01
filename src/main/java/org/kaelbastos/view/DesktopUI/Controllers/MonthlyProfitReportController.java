package org.kaelbastos.view.DesktopUI.Controllers;

import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import org.kaelbastos.Domain.Entities.Reports.ProfitMonthReport;
import org.kaelbastos.Domain.UseCases.ReportUseCases.GenerateProfitMonthReport;
import java.time.Month;
import java.util.ArrayList;
import java.util.List;

public class MonthlyProfitReportController {

    @FXML TableView<ProfitMonthReport> reportTableView;
    @FXML TableColumn<ProfitMonthReport, Integer> yearColumn;
    @FXML TableColumn<ProfitMonthReport, Month> monthColumn;
    @FXML TableColumn<ProfitMonthReport, Float> profitColumn;

    List<ProfitMonthReport> report  = new ArrayList<>();
    public void init() {
        try{
            report = new GenerateProfitMonthReport().generate();
        } catch (Exception e){
            System.out.println(e.getMessage());
        }
        bindTable();
    }

    public void bindTable() {
        yearColumn.setCellValueFactory(new PropertyValueFactory<>("year"));
        monthColumn.setCellValueFactory(new PropertyValueFactory<>("month"));
        profitColumn.setCellValueFactory(new PropertyValueFactory<>("profit"));
        reportTableView.setItems(FXCollections.observableArrayList(report));
    }
}
