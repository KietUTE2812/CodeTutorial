package org.example.cuoiki_code_tutorial.View;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class TrangChuAdmin extends Application {
    @Override
    public void start(Stage primaryStage) {
        BorderPane root = new BorderPane();

        // Header
        Label headerLabel = new Label("Trang Chủ Người Quản Trị");
        headerLabel.setStyle("-fx-font-size: 24px; -fx-font-weight: bold;");
        root.setTop(headerLabel);

        // Center - Khóa Học
        VBox courseBox = new VBox(10);
        courseBox.setPadding(new Insets(10));
        Label courseLabel = new Label("Các Khóa Học:");
        courseLabel.setStyle("-fx-font-size: 18px; -fx-font-weight: bold;");
        courseBox.getChildren().add(courseLabel);

        // TODO: Thêm mã để hiển thị danh sách các khóa học của người quản trị ở đây

        root.setCenter(courseBox);

        // Bottom - Buttons
        Button addCourseButton = new Button("Thêm Khóa Học Mới");
        addCourseButton.setOnAction(e -> {
            ThemKhoaHoc themKhoaHoc = new ThemKhoaHoc();
            themKhoaHoc.start(new Stage());
            System.out.println("Mở cửa sổ thêm khóa học mới");
        });

        HBox buttonBox = new HBox(10, addCourseButton);
        buttonBox.setStyle("-fx-padding: 10px;");
        buttonBox.setAlignment(javafx.geometry.Pos.CENTER_RIGHT);
        root.setBottom(buttonBox);

        Scene scene = new Scene(root, 800, 600);
        primaryStage.setScene(scene);
        primaryStage.setTitle("Trang Chủ Người Quản Trị");
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
