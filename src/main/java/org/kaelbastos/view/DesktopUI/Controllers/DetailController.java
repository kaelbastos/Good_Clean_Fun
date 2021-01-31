package org.kaelbastos.view.DesktopUI.Controllers;

import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import org.kaelbastos.Domain.Entities.Client.Client;
import org.kaelbastos.Domain.Entities.Client.ResidenceType;
import org.kaelbastos.Domain.Entities.Worker.Worker;
import org.kaelbastos.Domain.Entities.utils.Address;
import org.kaelbastos.Domain.Entities.utils.Person;
import org.kaelbastos.Domain.UseCases.ClientUseCases.AlterClient;
import org.kaelbastos.Domain.UseCases.WorkerUseCases.AlterWorker;

import java.util.ArrayList;
import java.util.Arrays;

public class DetailController {
    @FXML private ComboBox<ResidenceType> residenceType;
    @FXML private Label labelResidence;
    @FXML private TextField inputName, inputCpf, inputPhone, inputPhone2, inputEmail, inputCity, inputStreet, inputState, inputHood, inputNumber, inputPostal, inputComplement;
    @FXML private Button cancelBtn;

    private String PersonType = "";

    public void initClient(Person person) {
        PersonType = "Client";
        inputPhone2.setVisible(false);

        residenceType.setItems(
                FXCollections.observableArrayList(
                        new ArrayList<>(Arrays.asList(ResidenceType.values()))
                ));
        residenceType.getSelectionModel().selectFirst();
        inputName.setText(person.getName());
        inputCpf.setText(person.getCpf());
        inputPhone.setText(person.getTelephone());
        inputEmail.setText(person.getEmail());
        inputCity.setText(person.getAddress().getCity());
        inputStreet.setText(person.getAddress().getStreet());
        inputState.setText(person.getAddress().getState());
        inputHood.setText(person.getAddress().getNeighborhood());
        inputNumber.setText(person.getAddress().getNumber());
        inputPostal.setText(person.getAddress().getPostalCode());
        inputComplement.setText(person.getAddress().getComplement());

    }

    public void initWorker(Person person) {
        PersonType = "Worker";
        residenceType.setVisible(false);
        labelResidence.setVisible(false);

        inputName.setText(person.getName());
        inputCpf.setText(person.getCpf());
        inputPhone.setText(person.getTelephone());
        inputPhone2.setText(person.getTelephone());
        inputEmail.setText(person.getEmail());
        inputCity.setText(person.getAddress().getCity());
        inputStreet.setText(person.getAddress().getStreet());
        inputState.setText(person.getAddress().getState());
        inputHood.setText(person.getAddress().getNeighborhood());
        inputNumber.setText(person.getAddress().getNumber());
        inputPostal.setText(person.getAddress().getPostalCode());
        inputComplement.setText(person.getAddress().getComplement());
    }

    public void update(){
        if(PersonType.equals("Client")){
            Client client = new Client(inputCpf.getText(), inputName.getText(), inputPhone.getText(), inputEmail.getText(), new Address(inputStreet.getText(), inputHood.getText(), inputCity.getText(), inputState.getText(), inputNumber.getText(), inputPostal.getText(),inputComplement.getText()), residenceType.getSelectionModel().getSelectedItem());
            AlterClient alterClient = new AlterClient();
            try {
                System.out.println(alterClient.alter(client));
            } catch (Exception e){
                System.out.println(e.getMessage());
            }
        }else if(PersonType.equals("Worker")){
            Worker worker = new Worker(inputCpf.getText(), inputName.getText(), inputPhone.getText(), inputPhone2.getText(), inputEmail.getText(), new Address(inputStreet.getText(), inputHood.getText(), inputCity.getText(), inputState.getText(), inputNumber.getText(), inputPostal.getText(),inputComplement.getText()));
            AlterWorker alterWorker = new AlterWorker();
            try {
                System.out.println(alterWorker.alter(worker));
            } catch (Exception e){
                System.out.println(e.getMessage());
            }
        }
        cancel();
    }

    public void cancel(){
        Stage stage = (Stage) cancelBtn.getScene().getWindow();
        stage.close();
    }
}
