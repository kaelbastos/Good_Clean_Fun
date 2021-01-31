package org.kaelbastos.view.DesktopUI.Controllers;

import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import org.kaelbastos.Domain.Entities.Client.Client;
import org.kaelbastos.Domain.Entities.Client.ResidenceType;
import org.kaelbastos.Domain.Entities.utils.Address;
import org.kaelbastos.Domain.UseCases.ClientUseCases.InsertClient;
import java.util.ArrayList;
import java.util.Arrays;

public class ClientController {
    @FXML private ComboBox<ResidenceType> residenceType;
    @FXML private TextField inputName, inputCpf, inputPhone, inputEmail, inputCity, inputStreet, inputState, inputHood, inputNumber, inputPostal, inputComplement;
    @FXML private Button cancelBtn;

    public void init() {
        residenceType.setItems(
                FXCollections.observableArrayList(
                new ArrayList<ResidenceType>(Arrays.asList(ResidenceType.values()))
        ));
        residenceType.getSelectionModel().selectFirst();
    }

    public void saveClient(){
        Client client = new Client(inputCpf.getText(), inputName.getText(), inputPhone.getText(), inputEmail.getText(), new Address(inputStreet.getText(), inputHood.getText(), inputCity.getText(), inputState.getText(), inputNumber.getText(), inputPostal.getText(),inputComplement.getText()), residenceType.getSelectionModel().getSelectedItem());
        InsertClient insertClient = new InsertClient();
        try {
            System.out.println(insertClient.insert(client));
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
