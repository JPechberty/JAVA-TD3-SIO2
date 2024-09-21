package com.sio.javatd3sio2;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.stage.Stage;

import java.io.IOException;

public class ClientManagerController {

    @FXML
    private Label lblCountClients;
    @FXML
    private TableColumn tcRaisonSociale;
    @FXML
    private TableView tvClients;
    @FXML
    private TableColumn tcSiret;

    @FXML
    public void btnNewClientClicked() {
        //Ouvrir la fenetre de creation de client
        System.out.println("Nouveau client");
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("new-client.fxml"));
            Parent root = fxmlLoader.load();
            NewClientController controller = fxmlLoader.getController();
            controller.init();
            Scene scene = new Scene(root);
            Stage stage = new Stage();
            stage.setTitle("Clients Manager - Nouveau Client");
            stage.setScene(scene);
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    public void btnShowClientClicked() {
        //Ouvrir la fenetre de details client
        System.out.println("Details client");
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("show-client.fxml"));
            Parent root = fxmlLoader.load();
            ShowClientController controller = fxmlLoader.getController();
            controller.init();
            Scene scene = new Scene(root);
            Stage stage = new Stage();
            stage.setTitle("Clients Manager - Nouveau Client");
            stage.setScene(scene);
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    public void btnDeleteClientClicked() {
        //TODO : supprimer le client selectionné
        System.out.println("Supprimer client");
    }

    @FXML
    public void btnRefreshClicked() {
        //TODO : rafraichir la liste des clients
        System.out.println("Rafrachir");
    }
}