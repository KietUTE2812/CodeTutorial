package org.example.cuoiki_code_tutorial.Controllers;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Insets;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.layout.*;
import javafx.scene.paint.Paint;
import javafx.scene.web.WebEngine;
import javafx.scene.web.WebView;
import javafx.stage.Stage;
import org.example.cuoiki_code_tutorial.Dao.BaiHocDAO;
import org.example.cuoiki_code_tutorial.Models.BaiHoc;
import org.fxmisc.richtext.CodeArea;
import org.fxmisc.richtext.LineNumberFactory;


import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.ResourceBundle;

public class LessonCompiler implements Initializable {
    @FXML
    private AnchorPane layoutBaiHoc;
    @FXML
    private WebView wViewBaiHoc;
    @FXML
    private Label lblTenBaiHoc, lblGHKT;
    @FXML
    private Button btnMucDo, btnBack;
    @FXML
    private Button btnKiemThu1, btnChayThu;
    @FXML
    private HBox hBox;
    @FXML
    private ChoiceBox<String> choiceBoxNgonNgu;
    @FXML
    private VBox vBoxCodeEditor;
    @FXML
    private CodeArea codeArea;
    @FXML
    private TextArea outputArea;


    private BaiHoc baiHoc;
    private KiemTraDauVao kiemTraDauVao;
    private static final BaiHocDAO baiHocDAO = new BaiHocDAO();
    private String ngonNgu;

    private PythonExecutor pythonExecutor;


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        String pathToStyle = "/CSS/styles_baihoc.css";
        layoutBaiHoc.getStylesheets().add(getClass().getResource("/CSS/styles_baihoc.css").toExternalForm());

        ObservableList<String> options = FXCollections.observableArrayList("Python", "Java", "C++");
        choiceBoxNgonNgu.setItems(options);
        choiceBoxNgonNgu.getSelectionModel().select(0);
        choiceBoxNgonNgu.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> {
            System.out.println("Selected item: " + newValue);
            ngonNgu = choiceBoxNgonNgu.getSelectionModel().getSelectedItem();


            System.out.println(ngonNgu);
        });

        setUpCodeArea();
        pythonExecutor = new PythonExecutor(codeArea, outputArea);

        codeArea.replaceText("...\nA simple Python program to display Hello, World! on the screen\nusing");



    }

    public void setUpCodeArea() {
        codeArea.setStyle("-fx-font-family: 'Consolas'; -fx-font-size: 14px; -fx-text-fill: #d4d4d4; ");
        codeArea.setBackground(new Background(new BackgroundFill(Paint.valueOf("#dddddd"), CornerRadii.EMPTY, Insets.EMPTY)));
        codeArea.setParagraphGraphicFactory(LineNumberFactory.get(codeArea));
        codeArea.setOnKeyTyped(e -> codeArea.autosize());
        codeArea.setOnKeyPressed(e -> codeArea.autosize());
        codeArea.setTextInsertionStyle(Collections.singleton("-fx-background-color: red;"));
        codeArea.showParagraphAtTop(1);
        codeArea.setStyle("-fx-paragraph-graph-color: #d900d1;");

    }

    public void onBackButtonClick(ActionEvent actionEvent) throws SQLException, IOException {
        goChuongBaiHoc();

    }


    public void onKiemThuClick(ActionEvent actionEvent) throws SQLException {
        goKiemtraDauVaoLayout();
    }

    public void getBaiHocByThuTu(int thuTu) {
        BaiHoc baiHoc = baiHocDAO.getBaiHocByThuTu(thuTu);

        String tenBH = baiHoc.getTenBaiHoc();
        String noiDung = baiHoc.getNoiDung();
        if (tenBH.length() > 50) {
            tenBH = tenBH.substring(0, 50) + "...";
        }
        lblTenBaiHoc.setText(tenBH);
        WebEngine webEngine = wViewBaiHoc.getEngine();
        webEngine.loadContent(noiDung);

        String mucDo = baiHoc.getMucDo();
        int GHKT = baiHoc.getGioiHanKyTu();
        lblGHKT.setText("Giới hạn ký tự: " + GHKT);

        String codeMau = baiHoc.getCodeMau();
        codeArea.replaceText(codeMau);
        System.out.println(codeMau);

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
        BaiHoc baiHoc = baiHocDAO.getBaiHocByMaBHMaChuong(maBH, maChuong);

        String tenBH = baiHoc.getTenBaiHoc();
        String noiDung = baiHoc.getNoiDung();
        if (tenBH.length() > 50) {
            tenBH = tenBH.substring(0, 50) + "...";
        }
        lblTenBaiHoc.setText(tenBH);
        WebEngine webEngine = wViewBaiHoc.getEngine();
        webEngine.loadContent(noiDung);

        String mucDo = baiHoc.getMucDo();
        int GHKT = baiHoc.getGioiHanKyTu();
        lblGHKT.setText("Giới hạn ký tự: " + GHKT);
        String codeMau = baiHoc.getCodeMau();

        codeArea.replaceText(codeMau);

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


    public void onClickChayThu(ActionEvent actionEvent) {
        String testcse = "";
        String output = pythonExecutor.executeCode(testcse);
        outputArea.appendText(output);

    }

    @FXML
    public void goChuongBaiHoc() throws SQLException, IOException {



        try {
            Parent root = FXMLLoader.load(getClass().getResource("/FXML/chuong.fxml"));
            root.getStyleClass().add("background");
            Scene scene = new Scene(root, 1000, 600);
            // Kết nối tệp CSS với scene
            String pathToStyle = "/CSS/chuongCss.css";
            scene.getStylesheets().add(getClass().getResource(pathToStyle).toExternalForm());
            Stage stage = (Stage) btnBack.getScene().getWindow();
            stage.setScene(scene);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
