package com.sio.javatd3sio2;

import com.sio.javatd3sio2.models.Client;
import com.sio.javatd3sio2.services.ClientService;
import javafx.collections.FXCollections;
import javafx.collections.ObservableArray;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.ResourceBundle;

public class ClientManagerController implements Initializable {

    @FXML
    private Label lblCountClients;
    @FXML
    private TableColumn<Client,String> tcRaisonSociale;
    @FXML
    private TableView<Client> tvClients;
    @FXML
    private TableColumn<Client,String> tcSiret;

    ObservableList<Client> clients = FXCollections.observableArrayList();

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

        if(tvClients.getSelectionModel().getSelectedItem() == null) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Erreur");
            alert.setHeaderText("Aucun client selectionné");
            alert.setContentText("Veuillez selectionner un client");
            alert.showAndWait();
            return;
        }


        //Ouvrir la fenetre de details client
        System.out.println("Details client");
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("show-client.fxml"));
            Parent root = fxmlLoader.load();
            ShowClientController controller = fxmlLoader.getController();
            controller.init(tvClients.getSelectionModel().getSelectedItem().getSiret());
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

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        HashMap<String, Object> clientsMap = new ClientService().findAll();

        if (clientsMap == null) {
            //TODO : afficher un message d'erreur
            return;
        }

        ((ArrayList<Client>) clientsMap.get("clients")).forEach(client -> {
            clients.add((Client) client);
        });

        tcSiret.setCellValueFactory(new PropertyValueFactory<>("siret"));
        tcRaisonSociale.setCellValueFactory(new PropertyValueFactory<>("raisonSociale"));
        tvClients.setItems(clients);
        lblCountClients.setText(String.valueOf(clientsMap.get("count")));
    }
}