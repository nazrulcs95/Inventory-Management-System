/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXML.java to edit this template
 */
package com.nazrul.inventorymanagement;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

/**
 *
 * @author Rokon Nazrul
 */
public class InventoryManagement extends Application {

    private double x = 0.0;
    private double y = 0.0;

    @Override
    public void start(Stage stage) throws Exception {
        DashboardController dashboardController = new DashboardController();
        Parent root = FXMLLoader.load(getClass().getResource("LoginView.fxml"));

        FXMLLoader loader = new FXMLLoader(getClass().getResource("DashboardView.fxml"));
        //loader.setController(dashboardController);

        //Parent root = loader.load();

        //Parent root = FXMLLoader.load(getClass().getResource("./view/DashboardView.fxml"));
//        root.getStylesheets().clear();
//        root.getStylesheets().add(getClass().getResource("loginDesign.css").toExternalForm());
        Scene scene = new Scene(root);
        root.setOnMousePressed(((event) -> {
            x = event.getSceneX();
            y = event.getSceneY();
        }));

        root.setOnMouseDragged((event) -> {
            stage.setX(event.getScreenX() - x);
            stage.setY(event.getScreenY() - y);
        });

        stage.initStyle(StageStyle.TRANSPARENT);

        stage.setScene(scene);
        stage.show();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }

}
