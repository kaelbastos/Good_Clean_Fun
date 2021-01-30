package org.kaelbastos.view.DesktopUI.Windows;

import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import org.kaelbastos.view.DesktopUI.Controllers.AdministrationController;

import java.io.IOException;

public class AboutWindow {
    public void showAndWait(){
        FXMLLoader loader = new FXMLLoader();
        try {
            Pane pane = loader.load(getClass().getResource("FXMLabout.fxml").openStream());
            Stage stage = new Stage();
            stage.setScene(new Scene(pane));
            stage.setTitle("About");
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
