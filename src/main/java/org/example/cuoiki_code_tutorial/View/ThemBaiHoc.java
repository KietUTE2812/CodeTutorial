package org.example.cuoiki_code_tutorial.View;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.web.HTMLEditor;
import javafx.stage.Stage;

public class ThemBaiHoc extends Application {
    @Override
    public void start(Stage primaryStage) {
        BorderPane root = new BorderPane();

        // Header
        Label headerLabel = new Label("Tạo bài học mới");
        headerLabel.setStyle("-fx-font-size: 20px; -fx-font-weight: bold;");
        root.setTop(headerLabel);

        // Center - HTML Editor
        HTMLEditor htmlEditor = new HTMLEditor();
        root.setCenter(htmlEditor);

        // Bottom - Buttons
        Button saveButton = new Button("Lưu");
        saveButton.setOnAction(e -> {
            String htmlContent = htmlEditor.getHtmlText();
            // Lưu htmlContent vào cơ sở dữ liệu
            // Code để lưu vào cơ sở dữ liệu ở đây
            System.out.println("Đã lưu HTML vào cơ sở dữ liệu:\n" + htmlContent);
        });

        Button cancelButton = new Button("Hủy");
        cancelButton.setOnAction(e -> primaryStage.close());

        HBox buttonBox = new HBox(10, saveButton, cancelButton);
        buttonBox.setStyle("-fx-padding: 10px;");
        buttonBox.setAlignment(javafx.geometry.Pos.CENTER_RIGHT);
        root.setBottom(buttonBox);

        Scene scene = new Scene(root, 800, 600);
        primaryStage.setScene(scene);
        primaryStage.setTitle("Tạo Bài Học");
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
