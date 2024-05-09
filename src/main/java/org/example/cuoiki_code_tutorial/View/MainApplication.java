package org.example.cuoiki_code_tutorial.View;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class MainApplication extends Application {
    @Override
    public void start(Stage primaryStage) throws Exception {
        FXMLLoader loader1 = new FXMLLoader(getClass().getResource("/FXML/user_home.fxml"));
        Parent root = loader1.load();
        Scene layout1Scene = new Scene(root);
        root.getStyleClass().add("background");
        String pathToStyle = "/CSS/styles_userhome.css";
        layout1Scene.getStylesheets().add(getClass().getResource(pathToStyle).toExternalForm());
        primaryStage.setTitle("Code Tutorial");
        primaryStage.setScene(layout1Scene);
        primaryStage.show();


    }
}
