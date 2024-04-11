package org.example.cuoiki_code_tutorial.Controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.web.WebEngine;
import javafx.scene.web.WebView;
import javafx.stage.Stage;
import org.example.cuoiki_code_tutorial.Dao.BaiHocDAO;

import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;



public class KiemTraDauVao implements Initializable {
    @FXML
    private Button btnBack, btnMucDo;
    @FXML
    private HBox hBox;
    @FXML
    private WebView wViewBaiHoc;
    @FXML
    private Label lblTenBaiHoc;
    public void onClickGoBack(ActionEvent actionEvent) throws SQLException {
        goBaiHocLayout();
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }



    public void goBaiHocLayout() throws SQLException {
        hBox = new HBox();
        wViewBaiHoc = new WebView();
        lblTenBaiHoc = new Label();
        btnMucDo = new Button();
        LessonCompiler lessonCompiler = new LessonCompiler();
        String maBH = "bai1";
        String maChuong = "chuong1";
        try {
            lessonCompiler.loadBaiHocByMaBHMaChuong(maBH, maChuong);
            // Chuyển sang layout bài học
            Parent root = FXMLLoader.load(getClass().getResource("/FXML/lesson_compiler.fxml"));
            root.getStyleClass().add("background");
            Scene scene = new Scene(root, 1000, 600);

            // Kết nối tệp CSS với scene
            String pathToStyle = "/CSS/styles_baihoc.css";
            scene.getStylesheets().add(getClass().getResource(pathToStyle).toExternalForm());
            Stage stage = (Stage) btnBack.getScene().getWindow();
            stage.setScene(scene);
        } catch (IOException e) {
            e.printStackTrace();
            // Hiển thị thông báo lỗi cho người dùng
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Lỗi");
            alert.setHeaderText("Có lỗi xảy ra khi chuyển sang layout bài học");
            alert.setContentText(e.getMessage());
            alert.showAndWait();
        }
    }



}




