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
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import java.io.*;
import java.net.Socket;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class ShowUserAccountController implements Initializable {
    BufferedReader reader;
    BufferedWriter writer;
    Socket sc = null;

    ObservableList<Account2> observableAccount2List = FXCollections.observableArrayList();

    @FXML
    private TableView<Account2> userTableView;
    @FXML
    private TableColumn<Account2, Integer> columnId;
    @FXML
    private TableColumn<Account2, String> columnName;
    @FXML
    private TableColumn<Account2, String> columnPassword;
    @FXML
    private TableColumn<Account2, String> columnSex;
    @FXML
    private TableColumn<Account2, String> columnDob;

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
    void CreateAccount(ActionEvent event) throws IOException {
        URL AdminPage = getClass().getResource("CreateAccount.fxml");

        if (AdminPage == null) {
            return;
        }
        Parent parent = FXMLLoader.load(AdminPage);
        Scene view = new Scene(parent);
        Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
        window.setScene(view);
        window.show();
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        columnId.setCellValueFactory(new PropertyValueFactory<>("Id"));
        columnName.setCellValueFactory(new PropertyValueFactory<>("Name"));
        columnPassword.setCellValueFactory(new PropertyValueFactory<>("Password"));
        columnSex.setCellValueFactory(new PropertyValueFactory<>("Sex"));
        columnDob.setCellValueFactory(new PropertyValueFactory<>("Dob"));
        userTableView.setItems(observableAccount2List);
        try {

            sc = new Socket("localhost", 1999);
            OutputStreamWriter o = new OutputStreamWriter(sc.getOutputStream());
            writer = new BufferedWriter(o);
            InputStreamReader isr = new InputStreamReader(sc.getInputStream());
            reader = new BufferedReader(isr);


            int size = Integer.parseInt(reader.readLine());
            ArrayList<Account> accounts = new ArrayList<>();
            for (int i = 0; i < size; i++) {
                Account ac = new Account(reader.readLine(),
                        reader.readLine(), reader.readLine(), Integer.parseInt(reader.readLine()), reader.readLine());
                accounts.add(ac);
            }
            for (Account account : accounts) {

                Account2 account2 = new Account2(account.Name,
                        account.Password, account.ID,
                        account.Sex, account.DOB);
                observableAccount2List.add(account2);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}


