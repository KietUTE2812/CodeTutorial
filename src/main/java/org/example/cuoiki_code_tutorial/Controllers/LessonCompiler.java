package org.example.cuoiki_code_tutorial.Controllers;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.event.ActionEvent;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.image.Image;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Region;
import javafx.scene.web.WebEngine;
import javafx.scene.web.WebView;
import org.example.cuoiki_code_tutorial.Dao.BaiHocDAO;


import java.io.File;
import java.net.URL;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

public class LessonCompiler implements Initializable {
    @FXML
    private Label statusLabel;
    @FXML
    private AnchorPane rootPane, layoutBaiHoc;
    @FXML
    private BorderPane rootBorder;
    @FXML
    private ImageView imageView;

    @FXML
    private WebView wViewBaiHoc;
    @FXML
    private Label lblTenBaiHoc;

    @FXML
    private Button btnMucDo;
    @FXML
    private HBox hBox;

    private ObservableList<Button> buttons = FXCollections.observableArrayList();

    private static final BaiHocDAO baiHocDAO = new BaiHocDAO();

    public void handleCompileButtonAction(ActionEvent actionEvent) {
        statusLabel.setText("Compilation started...");
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        WebEngine webEngine = wViewBaiHoc.getEngine();

        // HTML content
        String htmlContent = "";

        // Load HTML content vào WebView
        webEngine.loadContent(htmlContent);
        String pathToStyle = "/CSS/styles_baihoc.css";
        layoutBaiHoc.getStylesheets().add(getClass().getResource("/CSS/styles_baihoc.css").toExternalForm());

    }

    public void onBackButtonClick(ActionEvent actionEvent) {
        String maBH = "bai1";
        String maChuong = "chuong1";

        WebEngine webEngine = wViewBaiHoc.getEngine();

        // HTML content


        String tenBaiHoc = baiHocDAO.tenBaiHoc(maBH, maChuong);
        String noiDung = baiHocDAO.noiDungBaiHoc(maBH, maChuong);
        //String test = "<img src=\"/codelearn-logo.png\" alt=\"logo\" class=\"mantine-kfwiow mantine-Image-image\" style=\"object-fit: cover; width: 7.6875rem; height: 2.5rem;\">";
        //lblTenBaiHoc.setText("Tên bài học dài quá lần này, vì vậy chỉ một phần sẽ được hiển thị và cuối cùng là dấu '...' để biểu thị.");
        // Load HTML content vào WebView
        webEngine.loadContent(noiDung);
        if (tenBaiHoc.length() > 50) {
            tenBaiHoc = tenBaiHoc.substring(0, 50) + "...";
        }
        lblTenBaiHoc.setText(tenBaiHoc);

        System.out.println("tenbai: " + tenBaiHoc);
        String mucDo = "Khó";
        switch (mucDo) {
            case "Dễ":
                btnMucDo.setStyle("-fx-background-color: green;");
                btnMucDo.setText("Dễ");
                break;
            case "Khó":
                btnMucDo.setStyle("-fx-background-color: red;");
                btnMucDo.setText("Khó");
                break;
            case "Vừa":
                btnMucDo.setStyle("-fx-background-color: blue;");
                btnMucDo.setText("Vừa");
                break;
            default:

                break;
        }


    }

    public void onButton1Click(ActionEvent actionEvent) {
    }

    public void onKiemThuClick(ActionEvent actionEvent) throws SQLException {
        List<Integer> thuTu = new ArrayList<>();
        hBox.getChildren().clear();
        hBox.setStyle("-fx-spacing: 10px;");

        thuTu = baiHocDAO.getThuTuByMaChuong("chuong2")  ;

        for (int i = 0; i < thuTu.size(); i++) {
            int count = thuTu.get(i);
            Button button = new Button();
            button.setText(String.valueOf(count));
            button.setPrefSize(30, 30);
            button.setOnAction(event -> {
                // Xác định button được click
                Button clickedButton = (Button) event.getSource();
                int clickedValue = Integer.parseInt(clickedButton.getText());
                System.out.println("Button clicked: " + clickedValue);
            });

            hBox.getChildren().addAll(button, new Region());

        }
    }
}
