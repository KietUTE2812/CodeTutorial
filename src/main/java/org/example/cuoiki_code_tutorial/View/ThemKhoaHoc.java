package org.example.cuoiki_code_tutorial.View;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class ThemKhoaHoc extends Application{
    @Override
    public void start(Stage primaryStage) {
        BorderPane root = new BorderPane();

        // Header
        Label headerLabel = new Label("Thêm Khóa Học Mới");
        headerLabel.setStyle("-fx-font-size: 24px; -fx-font-weight: bold;");
        root.setTop(headerLabel);

        // Center - Add Course Form
        GridPane addCourseForm = new GridPane();
        addCourseForm.setPadding(new Insets(10));
        addCourseForm.setVgap(10);
        addCourseForm.setHgap(10);

        // Tên khóa học
        Label nameLabel = new Label("Tên Khóa Học:");
        TextField nameField = new TextField();
        addCourseForm.addRow(0, nameLabel, nameField);

        // Giới thiệu khóa học
        Label introLabel = new Label("Giới Thiệu:");
        TextArea introArea = new TextArea();
        introArea.setPrefRowCount(5);
        introArea.setWrapText(true);
        addCourseForm.addRow(1, introLabel, introArea);

        // Thêm Chương
        Button addChapterButton = new Button("Thêm Chương");
        addChapterButton.setOnAction(e -> {
            // Mở cửa sổ để thêm chương mới
            // Code để mở cửa sổ thêm chương mới ở đây
            System.out.println("Mở cửa sổ thêm chương mới");
        });
        addCourseForm.addRow(2, addChapterButton);

        root.setCenter(addCourseForm);

        // Bottom - Buttons
        Button saveButton = new Button("Lưu");
        saveButton.setOnAction(e -> {
            // Lưu thông tin khóa học vào cơ sở dữ liệu
            // Code để lưu thông tin vào cơ sở dữ liệu ở đây
            System.out.println("Thông tin khóa học đã được lưu vào cơ sở dữ liệu");
        });

        Button cancelButton = new Button("Hủy");
        cancelButton.setOnAction(e -> primaryStage.close());

        BorderPane bottomPane = new BorderPane();
        bottomPane.setRight(saveButton);
        bottomPane.setLeft(cancelButton);
        root.setBottom(bottomPane);

        Scene scene = new Scene(root, 600, 400);
        primaryStage.setScene(scene);
        primaryStage.setTitle("Thêm Khóa Học Mới");
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
