/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXML2.java to edit this template
 */
package com.nazrul.inventorymanagement;

import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

/**
 *
 * @author Rokon Nazrul
 */
public class LoginController implements Initializable {

    @FXML
    private Button exitBtn;

    @FXML
    private Button loginBtn;

    @FXML
    private Button minimizeBtn;

    @FXML
    private TextField password;

    @FXML
    private TextField username;

    private Connection connection;
    private PreparedStatement preparedStatement;
    private Statement statement;
    private ResultSet resultSet;

    @FXML
    public void minimize() {
        Stage stage = (Stage) minimizeBtn.getScene().getWindow();
        stage.setIconified(true);
    }

    @FXML
    public void exit() {
        System.exit(0);
    }

    public void login() throws SQLException, IOException {
        String sqlStatement = "SELECT * FROM user WHERE username=? AND password=?";
        Alert alert;
        try {
            preparedStatement = connection.prepareStatement(sqlStatement);
            preparedStatement.setString(1, username.getText());
            preparedStatement.setString(2, password.getText());
            resultSet = preparedStatement.executeQuery();
        } catch (SQLException ex) {
            System.out.println(ex.toString());
        }

        if (username.getText().isEmpty() || username.getText().isEmpty()) {
            alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Invalid Input");
            alert.setHeaderText(null);
            alert.setContentText("Please enter a valid username and password then try again.\nThank you");
            alert.showAndWait();
        } else {
            if (resultSet.next()) {
                alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("Login Successful");
                alert.setHeaderText(null);
                alert.setContentText("You have successfully logged in.\nPlease wait a little.");
                alert.show();
                alert.close();
                
                Parent root = FXMLLoader.load(getClass().getResource("../view/DashboardView.fxml"));
                Stage stage = new Stage();
                Scene scene = new Scene(root);
                stage.setScene(scene);
                stage.show();
            }
        }
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        exitBtn.setOnMouseClicked(event -> {
            exit();
        });

        minimizeBtn.setOnMouseClicked(event -> {
            minimize();
        });
    }

}
