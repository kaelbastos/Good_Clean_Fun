package org.kaelbastos.view.DesktopUI.Controllers;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;
import org.kaelbastos.Domain.Entities.Worker.Worker;
import org.kaelbastos.Domain.Entities.utils.Address;
import org.kaelbastos.Domain.UseCases.WorkerUseCases.InsertWorker;

public class WorkerController {
    @FXML private TextField inputName, inputCpf, inputPhone, inputPhone2, inputEmail, inputCity, inputStreet, inputState, inputHood, inputNumber, inputPostal, inputComplement;
    @FXML private Button cancelBtn;

    @FXML private ImageView imageWindow;

    public void init(){
        Image img = new Image(getClass().getResourceAsStream("../images/profileLogin.png"));
        imageWindow.setImage(img);
    }

    public void saveWorker(){
        Worker worker = new Worker(inputCpf.getText(), inputName.getText(), inputPhone.getText(), inputPhone2.getText(), inputEmail.getText(), new Address(inputStreet.getText(), inputHood.getText(), inputCity.getText(), inputState.getText(), inputNumber.getText(), inputPostal.getText(),inputComplement.getText()));
        InsertWorker insertWorker = new InsertWorker();
        try {
            System.out.println(insertWorker.insert(worker));
        } catch (Exception e){
            System.out.println(e.getMessage());
        }
        cancel();
    }

    public void cancel(){
        Stage stage = (Stage) cancelBtn.getScene().getWindow();
        stage.close();
    }
}
