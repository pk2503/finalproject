package com.example.finalproject;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import java.io.IOException;
import java.net.URL;


public class ProfileController {

    @FXML
    void Home(ActionEvent event) throws IOException {
        URL AdminPage = getClass().getResource("AdminHome.fxml");

        if (AdminPage == null) {
            return;
        }
        Parent parent = FXMLLoader.load(AdminPage);
        Scene view = new Scene(parent);
        Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
        window.setScene(view);
        window.show();
    }

    @FXML
    void User(ActionEvent event) throws IOException {
        URL AdminPage = getClass().getResource("ShowUserAccount.fxml");

        if (AdminPage == null) {
            return;
        }
        Parent parent = FXMLLoader.load(AdminPage);
        Scene view = new Scene(parent);
        Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
        window.setScene(view);
        window.show();
    }

    @FXML
    void LogOut(ActionEvent event) throws IOException {
        URL AdminPage = getClass().getResource("LogIn.fxml");

        if (AdminPage == null) {
            return;
        }
        Parent parent = FXMLLoader.load(AdminPage);
        Scene view = new Scene(parent);
        Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
        window.setScene(view);
        window.show();
    }
    @FXML void Chat(ActionEvent event) throws IOException {
        URL AdminPage = getClass().getResource("Chat.fxml");

        if (AdminPage == null) {
            return;
        }
        Parent parent = FXMLLoader.load(AdminPage);
        Scene view = new Scene(parent);
        Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
        window.setScene(view);
        window.show();
    }
}
