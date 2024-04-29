package org.example.cuoiki_code_tutorial.Controllers;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;


import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.shape.Line;
import javafx.stage.Stage;
import org.example.cuoiki_code_tutorial.Dao.KhoaHocDAO;
import org.example.cuoiki_code_tutorial.Models.KhoaHoc;

import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

public class UserHomeController implements Initializable {
    @FXML
    private ImageView imglogoCodeLearn, imglogout;
    @FXML
    private AnchorPane StudyingCourses, CompleteCourses, SuggestedCourses;
    @FXML
    private Line line_StudyingCourse, line_CompleteCourse, line_SuggestedCourse;
    @FXML
    private Label lbl_CompleteCourse, lbl_StudyingCourse, lbl_SuggestedCourse;
    @FXML
    private Button btnShowAllCourse;


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        Image imgLogo = new Image(getClass().getResource("/Image/logo_codelearn.png").toString());
        Image imgLogout = new Image(getClass().getResource("/Image/logout.png").toString());
        imglogoCodeLearn.setImage(imgLogo);
        imglogout.setImage(imgLogout);
        loadKhoaHocGoiY();
        loadKhoaHoc();

        btnShowAllCourse.setOnAction(e ->{
            loadAllKhoaHoc(btnShowAllCourse);
        });


    }

    private void loadKhoaHocGoiY() {
        AnchorPane studyingCourses = StudyingCourses;
        AnchorPane suggestedCourses = SuggestedCourses;
        AnchorPane completeCourses = CompleteCourses;

        suggestedCourses.setVisible(true);
        studyingCourses.setVisible(false);
        completeCourses.setVisible(false);

        line_SuggestedCourse.setVisible(true);
        line_CompleteCourse.setVisible(false);
        line_StudyingCourse.setVisible(false);
        KhoaHocDAO khoaHocDAO = new KhoaHocDAO();
        HBox hBox = new HBox();
        List<KhoaHoc> khs = khoaHocDAO.getAllKhoaHoc();

        for (KhoaHoc khoaHoc : khs) {
            VBox vBox = new VBox();
            vBox.setPrefWidth(200);
            vBox.setPadding(new Insets(10, 10, 10, 10));
            vBox.setAlignment(Pos.CENTER);
            ImageView imageView = new ImageView(khoaHoc.getHinhAnh());
            imageView.setFitWidth(300);
            imageView.setFitHeight(200);
            Label tenKH = new Label(khoaHoc.getTenKH());
            tenKH.setAlignment(Pos.CENTER);
            Label tacGia = new Label(khoaHoc.getMaAD());
            tacGia.setAlignment(Pos.CENTER);
            Label ngayTao = new Label(khoaHoc.getNgayTao().toString());
            ngayTao.setAlignment(Pos.CENTER);
            Button button = new Button("Học Ngay");
            vBox.getStyleClass().add("vbox-background");

            vBox.setOnMouseClicked(event -> {
                loadGTKH(khoaHoc, button);

            });
            button.setOnAction(new EventHandler<ActionEvent>() {
                @Override
                public void handle(ActionEvent event) {
                    loadGTKH(khoaHoc, button);
                }
            });
            vBox.getChildren().addAll(imageView, tenKH, tacGia, ngayTao, button);
            hBox.getChildren().add(vBox);
        }
        SuggestedCourses.getChildren().add(hBox);

    }

    public void loadHeaer() {

        imglogoCodeLearn.setOnMouseClicked(e -> {
            String resPath = "/FXML/user_home.fxml";
            String cssPath = "CSS/styles_userhome.css";
            Stage stage = (Stage) imglogoCodeLearn.getScene().getWindow();
            SceneLoader.loadScene(resPath, cssPath, stage);
        });

    }

    public void loadKhoaHocDangHoc() {
        AnchorPane studyingCourses = StudyingCourses;
        AnchorPane suggestedCourses = SuggestedCourses;
        AnchorPane completeCourses = CompleteCourses;

        suggestedCourses.setVisible(false);
        studyingCourses.setVisible(true);
        completeCourses.setVisible(false);

        line_SuggestedCourse.setVisible(false);
        line_CompleteCourse.setVisible(false);
        line_StudyingCourse.setVisible(true);
    }

    public void loadKhoaHocHoanThanh() {
        AnchorPane studyingCourses = StudyingCourses;
        AnchorPane suggestedCourses = SuggestedCourses;
        AnchorPane completeCourses = CompleteCourses;

        suggestedCourses.setVisible(false);
        studyingCourses.setVisible(false);
        completeCourses.setVisible(true);

        line_SuggestedCourse.setVisible(false);
        line_CompleteCourse.setVisible(true);
        line_StudyingCourse.setVisible(false);
    }

    public void loadKhoaHoc() {
        lbl_SuggestedCourse.setOnMouseClicked(e -> {
            loadKhoaHocGoiY();
        });
        lbl_StudyingCourse.setOnMouseClicked(e -> {
            loadKhoaHocDangHoc();
        });
        lbl_CompleteCourse.setOnMouseClicked(e -> {
            loadKhoaHocHoanThanh();
        });
    }

    public void loadGTKH(KhoaHoc khoaHoc, Button button) {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/FXML/gioiThieuKhoaHoc.fxml"));
        GioiThieuKhoaHocController gioiThieuKhoaHocController = new GioiThieuKhoaHocController(khoaHoc.getMaKH());
        loader.setController(gioiThieuKhoaHocController);
        Parent root = null;
        try {
            root = loader.load();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        // Create new scene
        Scene scene = new Scene(root);

        // Get the stage
        Stage stage = (Stage) button.getScene().getWindow();
        String pathToStyle = "/CSS/styles_GTKhoaHoc.css";
        scene.getStylesheets().add(getClass().getResource(pathToStyle).toExternalForm());

        // Set the new scene
        stage.setScene(scene);
        stage.show();
    }

    public void loadAllKhoaHoc(Button btn)
    {
        String resPath ="/FXML/all_khoa_hoc.fxml";
        String cssPath = "/CSS/styles_all_khoahoc.css";
        Stage stage = (Stage) btn.getScene().getWindow();
        SceneLoader.loadScene(resPath, cssPath, stage);
    }
}
