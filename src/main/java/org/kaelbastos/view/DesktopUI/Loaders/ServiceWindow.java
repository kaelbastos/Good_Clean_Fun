package org.kaelbastos.view.DesktopUI.Loaders;

import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Modality;
import javafx.stage.Stage;
import org.kaelbastos.view.DesktopUI.Controllers.ServiceController;
import org.kaelbastos.view.DesktopUI.Controllers.WorkerController;

import java.io.IOException;

public class ServiceWindow {
    public void showAndWait(){
        FXMLLoader loader = new FXMLLoader();

        try {
            Pane graph = loader.load(getClass().getResource("../FXMLs/FXMLservice.fxml").openStream());
            Scene scene = new Scene(graph, 310, 280);
            ServiceController ctrl = loader.getController();
            ctrl.init();
            Stage stage = new Stage();
            stage.setScene(scene);
            stage.setTitle("Services");
            stage.initModality(Modality.APPLICATION_MODAL);
            stage.showAndWait();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
