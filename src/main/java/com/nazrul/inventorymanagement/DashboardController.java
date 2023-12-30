/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.nazrul.inventorymanagement;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.animation.FadeTransition;
import javafx.animation.TranslateTransition;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import javafx.util.Duration;

/**
 *
 * @author Rokon Nazrul
 */
public class DashboardController implements Initializable {

    @FXML
    private Button exit, menu;

    @FXML
    private AnchorPane panel1, panel2;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        exit.setOnMouseClicked(event -> {
            System.exit(0);
        });

        panel1.setVisible(false);

        handleTransition(1, 0, -600);

        menu.setOnMouseClicked(event -> {
            handleTransition(0, 0.5, 600);
        });

        panel1.setOnMouseClicked(event -> {
            handleTransition(0.5, 0, -600);
        });
    }

    public void handleTransition(double from, double to, int xPosition) {
        FadeTransition fadeTransition = new FadeTransition(Duration.seconds(0.5), panel1);
        fadeTransition.setFromValue(from);
        fadeTransition.setToValue(to);
        fadeTransition.play();

        TranslateTransition translateTransition = new TranslateTransition(Duration.seconds(0.5), panel2);
        translateTransition.setByX(xPosition);
        translateTransition.play();
    }

}
