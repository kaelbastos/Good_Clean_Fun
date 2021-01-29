package org.kaelbastos.view.DesktopUI.Controllers;

import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import org.kaelbastos.Domain.Entities.Client.Client;
import org.kaelbastos.Domain.Entities.Client.ResidenceType;
import org.kaelbastos.Domain.Entities.Worker.Worker;
import org.kaelbastos.Domain.Entities.utils.Address;
import org.kaelbastos.Domain.UseCases.InsertClient;
import org.kaelbastos.view.CLI.WorkerCLI;

import java.util.ArrayList;
import java.util.Arrays;

public class WorkerController {
    @FXML private TextField inputName, inputCpf, inputPhone, inputPhone2, inputEmail, inputCity, inputStreet, inputState, inputHood, inputNumber, inputPostal, inputComplement;
    @FXML private Button cancelBtn;

    public void saveWorker(){
        Worker worker = new Worker(inputCpf.getText(), inputName.getText(), inputPhone.getText(), inputPhone2.getText(), inputEmail.getText(), new Address(inputStreet.getText(), inputHood.getText(), inputCity.getText(), inputState.getText(), inputNumber.getText(), inputPostal.getText(),inputComplement.getText()));
        WorkerCLI.insertWorker(worker);
        cancel();
    }

    public void cancel(){
        Stage stage = (Stage) cancelBtn.getScene().getWindow();
        stage.close();
    }
}
