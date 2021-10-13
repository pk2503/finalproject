package com.example.finalproject;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

import java.io.*;
import java.net.Socket;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class AdminHomeController implements Initializable {

    ObservableList<Account2> observableChoiceList = FXCollections.observableArrayList();
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
    void Profile(ActionEvent event) throws IOException {
        URL AdminPage = getClass().getResource("Profile.fxml");

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
    private TextField projectName;

    @FXML
    private ChoiceBox<String> member;

    @FXML
    private ChoiceBox<String> leader;

    @FXML
    private TableView<data> projectTableView;

    @FXML
    private TableColumn<data, String> columnProject;

    @FXML
    private TableColumn<data, String> columnLeader;

    @FXML
    private TableColumn<data, String> columnMember;
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        try {
            choiceData();
        } catch (IOException e) {
            e.printStackTrace();
        }
        columnLeader.setCellValueFactory(new PropertyValueFactory<>("leaderName"));
        columnMember.setCellValueFactory(new PropertyValueFactory<>("memberName"));
        columnProject.setCellValueFactory(new PropertyValueFactory<>("projectName"));
    }

    public void choiceData() throws IOException {
        BufferedReader reader;
        BufferedWriter writer;
        Socket sc = null;
        sc = new Socket("localhost", 7969);
        InputStreamReader isr = new InputStreamReader(sc.getInputStream());
        reader = new BufferedReader(isr);
        String s = reader.readLine();
        String[ ]data = s.split(",");
        for ( int i =0; i<data.length; i++) {
            member.getItems().add(data[i]);
            leader.getItems().add(data[i]);
        }
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

    @FXML
    void AddProject() {
        projectTableView.getItems().add(new data(projectName.getText(),member.getValue(),leader.getValue()));
    }
}
