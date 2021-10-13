package com.example.finalproject;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import java.io.*;
import java.net.Socket;
import java.net.URL;

public class LogInController {
    private static boolean adminFile = false;
    private static int i = 1;
    BufferedReader reader;
    BufferedWriter writer;
    Socket sc = null;
    @FXML
    private TextField UserName;
    @FXML
    private PasswordField UserPassword;
    @FXML
    private Label heading;
    @FXML
    private Button au;

    @FXML
    void adminLog() {
        if (i % 2 != 0) {
            adminFile = true;
            heading.setText("Login to Admin Account");
            au.setText("Login as user");
        } else {
            adminFile = false;
            heading.setText("Login to User Account");
            au.setText("Login as admin");
        }
        i++;

    }

    @FXML
    void userlogin(ActionEvent event) throws IOException {
        String name = UserName.getText();
        String password = UserPassword.getText();

        try {

            sc = new Socket("localhost", 6969);
            OutputStreamWriter o = new OutputStreamWriter(sc.getOutputStream());
            writer = new BufferedWriter(o);

            InputStreamReader isr = new InputStreamReader(sc.getInputStream());
            reader = new BufferedReader(isr);
            writer.write(adminFile + "\n");
            writer.write(name + "\n");
            writer.write(password + "\n");
            writer.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
        if (Boolean.parseBoolean(reader.readLine())) {
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
        else {
            URL UserPage = getClass().getResource("UserHome.fxml");

            if (UserPage == null) {
                return;
            }
            Parent parent = FXMLLoader.load(UserPage);
            Scene view = new Scene(parent);
            Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
            window.setScene(view);
            window.show();
        }

    }

}