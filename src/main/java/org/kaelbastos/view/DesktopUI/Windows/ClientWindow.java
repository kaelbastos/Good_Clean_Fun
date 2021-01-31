package org.kaelbastos.view.DesktopUI.Windows;

import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.layout.Pane;
import javafx.stage.Modality;
import javafx.stage.Stage;
import org.kaelbastos.view.DesktopUI.Controllers.ClientController;

import java.io.IOException;

public class ClientWindow {

    public void showAndWait(){
        FXMLLoader loader = new FXMLLoader();
        try {
            Pane graph = loader.load(getClass().getResource("FXMLclient.fxml").openStream());
            Scene scene = new Scene(graph);
            ClientController ctrl = loader.getController();
            ctrl.init();
            Stage stage = new Stage();
            stage.setScene(scene);
            stage.setTitle("New Client");
            stage.getIcons().add(new Image(getClass().getResourceAsStream("../images/logo.png")));
            stage.initModality(Modality.APPLICATION_MODAL);
            stage.showAndWait();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
