package org.kaelbastos;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import org.kaelbastos.view.DesktopUI.Controllers.AdministrationController;

/**
 * This is the code, enjoy it.
 *
 *
 * Do or do not, there is no try... Master Yoda.
 */
public class App extends Application {
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage) throws Exception{
        FXMLLoader loader = new FXMLLoader();
        Pane pane = loader.load(getClass().getResource("FXMLs/FXMLadministration.fxml").openStream());
        AdministrationController ctrl = loader.getController();
        ctrl.init();
        stage.setScene(new Scene(pane));
        stage.setTitle("Admnistration Window");
        stage.show();
    }
}