package org.example.cuoiki_code_tutorial.View;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import org.example.cuoiki_code_tutorial.Controllers.LessonCompiler;

import java.io.IOException;

public class BaiHocApplication extends Application {

    @Override
    public void start(Stage stage) throws IOException {

        String pathToFXML = "/FXML/lesson_compiler.fxml";
        FXMLLoader fxmlLoader = new FXMLLoader(BaiHocApplication.class.getResource(pathToFXML));

        AnchorPane root = new AnchorPane();
        root.getChildren().add(fxmlLoader.load());
        root.getStyleClass().add("background");
        Scene scene = new Scene(root, 1000, 600);
        // Kết nối tệp CSS với scene
        String pathToStyle = "/CSS/styles_baihoc.css";
        scene.getStylesheets().add(getClass().getResource(pathToStyle).toExternalForm());
        stage.setTitle("Code Tutorial");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}