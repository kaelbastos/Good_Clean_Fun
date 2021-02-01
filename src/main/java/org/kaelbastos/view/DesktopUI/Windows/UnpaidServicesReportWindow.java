package org.kaelbastos.view.DesktopUI.Windows;

import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.layout.Pane;
import javafx.stage.Modality;
import javafx.stage.Stage;
import org.kaelbastos.view.DesktopUI.Controllers.MonthlyProfitReportController;

import java.io.IOException;

public class UnpaidServicesReportWindow {
    public void showAndWait(){
        FXMLLoader loader = new FXMLLoader();

        try {
            Pane graph = loader.load(getClass().getResource("FXMLUnpaidServicesReport.fxml").openStream());
            Scene scene = new Scene(graph, 690, 400);
            MonthlyProfitReportController ctrl = loader.getController();
            ctrl.init();
            Stage stage = new Stage();
            stage.setScene(scene);
            stage.getIcons().add(new Image(getClass().getResourceAsStream("../images/logo.png")));
            stage.setTitle("Products");
            stage.initModality(Modality.APPLICATION_MODAL);
            stage.showAndWait();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
