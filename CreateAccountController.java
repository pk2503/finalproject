package com.example.finalproject;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.*;
import java.net.Socket;
import java.net.URL;
import java.util.ResourceBundle;

public class CreateAccountController implements Initializable {
    BufferedReader reader;
    BufferedWriter writer;
    Socket sc = null;


    @FXML
    private TextField UserName;

    @FXML
    private TextField Password;

    @FXML
    private CheckBox Male;

    @FXML
    private ChoiceBox<String> Date;

    @FXML
    private ChoiceBox<String> Month;

    @FXML
    private ChoiceBox<String> Year;

    @FXML
    private TextField ID;


    @Override
    public void initialize(URL arg0, ResourceBundle arg1) {
        Date.setValue("Date");
        Year.setValue("Year");
        Month.setValue("Month");
        Date.getItems().addAll("1", "2", "3", "4", "5", "6", "7", "8", "9", "10",
                "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21",
                "22", "23", "24", "25", "26", "27", "28", "29", "30", "31");
        Month.getItems().addAll("1", "2", "3", "4", "5", "6", "7", "8", "9", "10",
                "11", "12");
        Year.getItems().addAll("1991", "1992", "1993", "1994", "1995", "1996",
                "1997", "1998", "1999", "2000", "2001", "2002", "2003", "2004", "2005");
    }


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
    void Create() {
        String date, month, year;
        date = Date.getValue();
        month = Month.getValue();
        year = Year.getValue();
        String DOB = date + "/" + month + "/" + year;
        String Sex = "Male";
        if (!(Male.isSelected()))
            Sex = "Female";
        Account account = new Account(UserName.getText(), Password.getText(), Sex, Integer.parseInt(ID.getText()), DOB);

        try {

            sc = new Socket("localhost", 9997);
            OutputStreamWriter o = new OutputStreamWriter(sc.getOutputStream());
            writer = new BufferedWriter(o);

            InputStreamReader isr = new InputStreamReader(sc.getInputStream());
            reader = new BufferedReader(isr);
            writer.write(account.Name + "\n");
            writer.write(account.Password + "\n");
            writer.write(account.ID + "\n");
            writer.write(account.Sex + "\n");
            writer.write(account.DOB + "\n");
            writer.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
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
}

class Account {
    String Name;
    String Password;
    String Sex;
    int ID;
    String DOB;

    public Account(String Name, String Password, String Sex, int ID, String DOB) {
        this.Name = Name;
        this.Password = Password;
        this.ID = ID;
        this.Sex = Sex;
        this.DOB = DOB;
    }
}