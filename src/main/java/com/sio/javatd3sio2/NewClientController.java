package com.sio.javatd3sio2;

import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class NewClientController {
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

    public void init() {
        System.out.println("New Client initialized");
    }

    @FXML
    public void backBtnClicked(Event event) {
        System.out.println("Back button clicked");
        // Récupérer le stage actuel via le bouton cliqué
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.close(); // Fermer la fenêtre
    }

    @FXML
    public void saveBtnClicked(Event event) {
        System.out.println("Save button clicked");
        // Récupérer le stage actuel via le bouton cliqué
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.close(); // Fermer la fenêtre
    }
}
