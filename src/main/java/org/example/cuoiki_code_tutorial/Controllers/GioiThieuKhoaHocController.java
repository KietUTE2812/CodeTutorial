package org.example.cuoiki_code_tutorial.Controllers;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.web.WebEngine;
import javafx.scene.web.WebView;
import javafx.stage.Stage;
import org.example.cuoiki_code_tutorial.Dao.KhoaHocDAO;
import org.example.cuoiki_code_tutorial.Models.KhoaHoc;

import java.net.URL;
import java.util.ResourceBundle;

public class GioiThieuKhoaHocController implements Initializable {


    @FXML
    private ImageView imglogout, imglogoCodeLearn;
    @FXML
    private AnchorPane Overview;
    @FXML
    private Label lbl_IDad, lbl_CourseName, lbl_ChungChi, lbl_GioiThieu;
    @FXML
    private Button btnStudyNow, btn_SignCourse;
    @FXML
    private WebView wvGioiThieuKH;


    private String MaKH;

    public void setMaKH(String maKH) {
        MaKH = maKH;
    }

    public GioiThieuKhoaHocController(String maKH) {
        MaKH = maKH;
    }

    private KhoaHocDAO khoaHocDAO = new KhoaHocDAO();

    private void loadKhoaHoc() {

        KhoaHoc kh = khoaHocDAO.getKhoaHoc(MaKH);
        Button hocNgay = new Button("Vào học ngay");
        lbl_CourseName.setText(kh.getTenKH());
        lbl_IDad.setText(kh.getMaAD());
        WebEngine webEngine = wvGioiThieuKH.getEngine();
        webEngine.loadContent(kh.getMoTa());


        hocNgay.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                try {
                    String resPath = "/FXML/chuong.fxml";
                    String cssPath = "/CSS/ChuongCss.css";
                    Stage stage = (Stage) hocNgay.getScene().getWindow();
                    SceneLoader.loadScene(resPath, cssPath, stage);

                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
        Button quayVe = new Button("Quay về");
        quayVe.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                try {
                    String resPath = "/FXML/user_home.fxml";
                    String cssPath = "/CSS/styles_userhome.css";
                    Stage stage = (Stage) quayVe.getScene().getWindow();
                    SceneLoader.loadScene(resPath, cssPath, stage);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });

    }


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        loadKhoaHoc();
        Image imgLogo = new Image(getClass().getResource("/Image/logo_codelearn.png").toString());
        Image imgLogout = new Image(getClass().getResource("/Image/logout.png").toString());
        imglogoCodeLearn.setImage(imgLogo);
        imglogout.setImage(imgLogout);

        imglogoCodeLearn.setOnMouseClicked(e->{
            String resPath = "/FXML/user_home.fxml";
            String cssPath = "/CSS/styles_userhome.css";
            Stage stage = (Stage) imglogoCodeLearn.getScene().getWindow();
            SceneLoader.loadScene(resPath, cssPath, stage);
        });
    }
}
