package org.kaelbastos.view.DesktopUI.Windows;

import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Modality;
import javafx.stage.Stage;
import org.kaelbastos.view.DesktopUI.Controllers.ServiceCategoryController;
import org.kaelbastos.view.DesktopUI.Controllers.ServiceController;

import java.io.IOException;

public class ServiceCategoryWindow {
    public void showAndWait(){
        FXMLLoader loader = new FXMLLoader();

        try {
            Pane graph = loader.load(getClass().getResource("FXMLserviceCategory.fxml").openStream());
            Scene scene = new Scene(graph, 854, 545);
            ServiceCategoryController ctrl = loader.getController();
            ctrl.init();
            Stage stage = new Stage();
            stage.setScene(scene);
            stage.setTitle("Service Category");
            stage.initModality(Modality.APPLICATION_MODAL);
            stage.showAndWait();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
