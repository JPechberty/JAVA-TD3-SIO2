package com.sio.javatd3sio2;

import com.sio.javatd3sio2.models.Client;
import com.sio.javatd3sio2.services.ClientService;
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class ShowClientController {
    @FXML
    private TextField inputAdresse;
    @FXML
    private TextField inputCodePostal;
    @FXML
    private TextField inputSiret;
    @FXML
    private TextField inputRaisonSociale;
    @FXML
    private TextField inputVille;

    public void init(String siret) {
        System.out.println("Show Client initialized");
        ClientService service = new ClientService();
        Client client = service.find(siret);

        inputSiret.setText(client.getSiret());
        inputRaisonSociale.setText(client.getRaisonSociale());
        inputAdresse.setText(client.getAdresse());
        inputCodePostal.setText(client.getCodePostal());
        inputVille.setText(client.getVille());
    }

    @FXML
    public void backBtnClicked(Event event) {
        System.out.println("Back button clicked");
        // Récupérer le stage actuel via le bouton cliqué
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.close(); // Fermer la fenêtre
    }

    @FXML
    public void updateBtnClicked(Event event) {
        System.out.println("Update button clicked");
        // Récupérer le stage actuel via le bouton cliqué
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.close(); // Fermer la fenêtre
    }
}
