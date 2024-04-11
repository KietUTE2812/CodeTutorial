package org.example.cuoiki_code_tutorial.View;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class GioiThieuApplication extends Application {
    @Override
    public void start(Stage primaryStage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("/FXML/gioiThieuKhoaHoc.fxml"));
        primaryStage.setTitle("Chuong and BaiHoc Viewer");
        primaryStage.setScene(new Scene(root, 800, 600));
        primaryStage.show();
    }
    public static void main(String[] args) {
        launch(args);
    }
}