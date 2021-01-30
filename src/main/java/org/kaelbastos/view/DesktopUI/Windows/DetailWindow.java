package org.kaelbastos.view.DesktopUI.Windows;

import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Modality;
import javafx.stage.Stage;
import org.kaelbastos.Domain.Entities.utils.Person;
import org.kaelbastos.view.DesktopUI.Controllers.DetailController;

import java.io.IOException;

public class DetailWindow {

    public void showAndWait(Person person, String viewModel){
        FXMLLoader loader = new FXMLLoader();

        try {
            Pane graph = loader.load(getClass().getResource("../FXMLs/FXMLdetail.fxml").openStream());
            Scene scene = new Scene(graph, 310, 280);
            DetailController ctrl = loader.getController();
            if(viewModel.equals("Client")){
                ctrl.initClient(person);
            }else if(viewModel.equals("Worker")){
                ctrl.initWorker(person);
            }
            Stage stage = new Stage();
            stage.setScene(scene);
            stage.setTitle("View and Edit Details");
            stage.initModality(Modality.APPLICATION_MODAL);
            stage.showAndWait();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
