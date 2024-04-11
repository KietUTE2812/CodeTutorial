package org.example.cuoiki_code_tutorial.View;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Accordion;
import javafx.scene.control.Button;
import javafx.scene.control.TitledPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class HelloApplication extends Application {
    @Override
    public void start(Stage primaryStage) {
        // Tạo một Accordion để chứa các chương
        Accordion accordion = new Accordion();

        // Tạo một VBox chứa danh sách bài học cho mỗi chương
        VBox chapter1Content = new VBox();
        chapter1Content.getChildren().addAll(
                new Button("Bài học 1"),
                new Button("Bài học 2"),
                new Button("Bài học 3")
        );
        TitledPane chapter1 = new TitledPane("Chương 1", chapter1Content);

        VBox chapter2Content = new VBox();
        chapter2Content.getChildren().addAll(
                new Button("Bài học 1"),
                new Button("Bài học 2"),
                new Button("Bài học 3")
        );
        TitledPane chapter2 = new TitledPane("Chương 2", chapter2Content);

        // Thêm các chương vào Accordion
        accordion.getPanes().addAll(chapter1, chapter2);

        // Tạo nút mở rộng
        Button expandButton = new Button("Expand All");
        expandButton.setOnAction(event -> {
            for (TitledPane pane : accordion.getPanes()) {
                pane.setExpanded(true);
            }
        });

        // Tạo layout chính và thêm Accordion và nút mở rộng vào đó
        VBox root = new VBox(10, expandButton, accordion);

        Scene scene = new Scene(root, 400, 400);

        primaryStage.setScene(scene);
        primaryStage.setTitle("Lesson Viewer");
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
