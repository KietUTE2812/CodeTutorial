package org.example.cuoiki_code_tutorial.View;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.stage.Stage;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.canvas.*;
import javafx.scene.web.*;
import javafx.scene.Group;

import java.io.IOException;

public class demo extends Application {

    @Override
    public void start(Stage stage) throws IOException {

        String pathToFXML = "/FXML/user_home.fxml";
        FXMLLoader fxmlLoader = new FXMLLoader(BaiHocApplication.class.getResource(pathToFXML));

        AnchorPane root = new AnchorPane();
        root.getChildren().add(fxmlLoader.load());
        root.getStyleClass().add("background");
        Scene scene = new Scene(root, 1000, 600);
        // Kết nối tệp CSS với scene
        String pathToStyle = "/CSS/styles_userhome.css";
        scene.getStylesheets().add(getClass().getResource(pathToStyle).toExternalForm());
        stage.setTitle("Code Tutorial");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}