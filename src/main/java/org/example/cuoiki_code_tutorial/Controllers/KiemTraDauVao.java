package org.example.cuoiki_code_tutorial.Controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
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
import org.example.cuoiki_code_tutorial.Models.BaiHoc;
import org.example.cuoiki_code_tutorial.View.BaiHocApplication;

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

    private BaiHoc baiHoc;
    private LessonCompiler lessonCompiler;

    public void onClickGoBack(ActionEvent actionEvent) throws SQLException, IOException {
        goBaiHocLayout();
    }

    public KiemTraDauVao(BaiHoc baiHoc, LessonCompiler lessonCompiler) {
        this.baiHoc = baiHoc;
        this.lessonCompiler = lessonCompiler;
    }

    public KiemTraDauVao() {
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {


    }
    public void setLayout2Controller(LessonCompiler controller) {
        this.lessonCompiler = controller;
    }
    @FXML
    public void goBaiHocLayout() throws SQLException, IOException {
        String maBH = "bai1";
        String maChuong = "chuong6";
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/FXML/lesson_compiler.fxml"));

        Parent layout2Root = loader.load();
        layout2Root.getStylesheets().add(getClass().getResource("/CSS/styles_KTDV.css").toExternalForm());
        layout2Root.getStyleClass().add("background");
        LessonCompiler layout2Controller = loader.getController();
        layout2Controller.loadBaiHocByMaBHMaChuong(maBH, maChuong);
        Scene layout2Scene = new Scene(layout2Root);
        Stage stage = (Stage)  btnBack.getScene().getWindow();
        stage.setScene(layout2Scene);
        stage.show();
    }


}




