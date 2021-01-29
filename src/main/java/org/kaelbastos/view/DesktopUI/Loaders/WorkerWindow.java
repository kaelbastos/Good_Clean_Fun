package org.kaelbastos.view.DesktopUI.Loaders;

import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Modality;
import javafx.stage.Stage;
import org.kaelbastos.view.DesktopUI.Controllers.ClientController;
import org.kaelbastos.view.DesktopUI.Controllers.WorkerController;

import java.io.IOException;

public class WorkerWindow {
    public void showAndWait(){
        FXMLLoader loader = new FXMLLoader();

        try {
            Pane graph = loader.load(getClass().getResource("../FXMLs/FXMLworker.fxml").openStream());
            Scene scene = new Scene(graph, 310, 280);
            WorkerController ctrl = loader.getController();
            Stage stage = new Stage();
            stage.setScene(scene);
            stage.setTitle("New Worker");
            stage.initModality(Modality.APPLICATION_MODAL);
            stage.showAndWait();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
