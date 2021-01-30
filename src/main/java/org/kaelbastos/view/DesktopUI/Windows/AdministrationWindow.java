package org.kaelbastos.view.DesktopUI.Windows;

import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Modality;
import javafx.stage.Stage;
import org.kaelbastos.view.DesktopUI.Controllers.AdministrationController;
import org.kaelbastos.view.DesktopUI.Controllers.ClientController;

import java.io.IOException;

public class AdministrationWindow {
    public void showAndWait(){
        FXMLLoader loader = new FXMLLoader();
        try {
            Pane pane = loader.load(getClass().getResource("FXMLadministration.fxml").openStream());
            AdministrationController ctrl = loader.getController();
            ctrl.init();
            Stage stage = new Stage();
            stage.setScene(new Scene(pane));
            stage.setTitle("Admnistration Window");
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
