package org.example.cuoiki_code_tutorial.View;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import org.example.cuoiki_code_tutorial.Controllers.KiemTraDauVao;
import org.example.cuoiki_code_tutorial.Controllers.LessonCompiler;

public class MainApplication extends Application {
    @Override
    public void start(Stage primaryStage) throws Exception {
        FXMLLoader loader1 = new FXMLLoader(getClass().getResource("/FXML/KiemTraDauVao.fxml"));
        Parent layout1Root = loader1.load();
        Scene layout1Scene = new Scene(layout1Root);
        primaryStage.setScene(layout1Scene);
        primaryStage.show();


    }
}
