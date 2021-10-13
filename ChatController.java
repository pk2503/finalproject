package com.example.finalproject;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.*;
import java.net.Socket;
import java.net.SocketException;
import java.net.URL;

public class ChatController {
    boolean isConnected = false;
    BufferedReader reader;
    BufferedWriter writer;
    @FXML
    private TextArea chatTextArea;
    @FXML
    private TextField chatTextField;

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
    void send(ActionEvent event) {
        if (!isConnected) {
            String name = chatTextField.getText();
            chatTextField.clear();

            if (name == null || name.length() == 0) {
                chatTextArea.appendText("Enter a valid name!\n");
                return;
            }
            try {
                Socket sc = new Socket("localhost", 6666);

                OutputStreamWriter o = new OutputStreamWriter(sc.getOutputStream());
                writer = new BufferedWriter(o);

                writer.write(name + "\n");
                writer.flush();

                InputStreamReader isr = new InputStreamReader(sc.getInputStream());
                reader = new BufferedReader(isr);


                Thread serverListener = new Thread(() -> {
                    while (true) {
                        try {
                            String data = reader.readLine() + "\n";
                            chatTextArea.appendText(data);
                        } catch (SocketException e) {
                            chatTextArea.appendText("Connection lost!\n");
                            break;
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }
                });
                serverListener.start();

                chatTextArea.appendText("Connection established!\n");
                chatTextField.setPromptText("Write your message.");
                isConnected = true;

            } catch (IOException e) {
                e.printStackTrace();
            }
        } else {
            try {
                String message = chatTextField.getText();
                chatTextArea.clear();

                if (message == null || message.length() == 0) {
                    return;
                }

                writer.write(message + "\n");
                writer.flush();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

}

