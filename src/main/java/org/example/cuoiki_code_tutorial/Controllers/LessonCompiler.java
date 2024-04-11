package org.example.cuoiki_code_tutorial.Controllers;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Region;
import javafx.scene.web.WebEngine;
import javafx.scene.web.WebView;
import javafx.stage.Stage;
import org.example.cuoiki_code_tutorial.Dao.BaiHocDAO;


import java.io.IOException;
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
    private Button btnKiemThu1;
    @FXML
    private HBox hBox;


    private static final BaiHocDAO baiHocDAO = new BaiHocDAO();

    public LessonCompiler() {
        this.hBox = new HBox();
        this.wViewBaiHoc = new WebView();
        this.lblTenBaiHoc = new Label();
        this.btnMucDo = new Button();
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        String pathToStyle = "/CSS/styles_baihoc.css";
        layoutBaiHoc.getStylesheets().add(getClass().getResource("/CSS/styles_baihoc.css").toExternalForm());

    }

    public void onBackButtonClick(ActionEvent actionEvent) throws SQLException {

        String maBH = "bai1";
        String maChuong = "chuong4";
        loadBaiHocByMaBHMaChuong(maBH, maChuong);


    }


    public void onKiemThuClick(ActionEvent actionEvent) throws SQLException {
        goKiemtraDauVaoLayout();
    }

    public void getBaiHocByThuTu(int thuTu) {

        String tenBH = baiHocDAO.tenBaiHocByThuTu(thuTu);
        String noiDung = baiHocDAO.noiDungByThuTu(thuTu);
        if (tenBH.length() > 50) {
            tenBH = tenBH.substring(0, 50) + "...";
        }
        lblTenBaiHoc.setText(tenBH);
        WebEngine webEngine = wViewBaiHoc.getEngine();
        webEngine.loadContent(noiDung);

        String mucDo = "Vừa";
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

    public void getSoLuongBaiHoc(String maChuong) throws SQLException {
        List<Integer> thuTu = new ArrayList<>();
        hBox.getChildren().clear();
        hBox.setStyle("-fx-spacing: 10px;");

        thuTu = baiHocDAO.getThuTuByMaChuong(maChuong);

        for (int i = 0; i < thuTu.size(); i++) {
            int count = thuTu.get(i);
            Button button = new Button();
            button.setText(String.valueOf(count));
            button.setPrefSize(30, 30);
            button.setOnAction(event -> {
                // Xác định button được click
                Button clickedButton = (Button) event.getSource();
                int clickedValue = Integer.parseInt(clickedButton.getText());
                getBaiHocByThuTu(clickedValue);
            });

            hBox.getChildren().addAll(button, new Region());

        }
    }

    public void goKiemtraDauVaoLayout() {
        try {
            Parent root = FXMLLoader.load(getClass().getResource("/FXML/KiemTraDauVao.fxml"));
            root.getStyleClass().add("background");
            Scene scene = new Scene(root, 1000, 600);
            // Kết nối tệp CSS với scene
            String pathToStyle = "/CSS/styles_baihoc.css";
            scene.getStylesheets().add(getClass().getResource(pathToStyle).toExternalForm());
            Stage stage = (Stage) btnKiemThu1.getScene().getWindow();
            stage.setScene(scene);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void loadBaiHocByMaBHMaChuong(String maBH, String maChuong) throws SQLException {

        getSoLuongBaiHoc(maChuong);

        WebEngine webEngine = wViewBaiHoc.getEngine();
        String tenBaiHoc = baiHocDAO.tenBaiHoc(maBH, maChuong);
        String noiDung = baiHocDAO.noiDungBaiHoc(maBH, maChuong);
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


}
