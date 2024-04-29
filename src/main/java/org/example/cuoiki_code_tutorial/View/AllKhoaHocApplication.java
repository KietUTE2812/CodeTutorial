package org.example.cuoiki_code_tutorial.View;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class AllKhoaHocApplication extends Application {
    @Override
    public void start(Stage primaryStage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("/FXML/all_khoa_hoc.fxml"));
        primaryStage.setTitle("Học Code Cho Người Mới Bắt Đầu");
        primaryStage.setScene(new Scene(root, 1000, 600));
        primaryStage.show();
    }
    public static void main(String[] args) {
        launch(args);
    }
}
