package org.example.cuoiki_code_tutorial.Controllers;

import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.VBox;
import javafx.fxml.FXML;
import javafx.scene.text.TextAlignment;
import org.example.cuoiki_code_tutorial.Dao.ChuongDAO;
import org.example.cuoiki_code_tutorial.Models.BaiHoc;
import org.example.cuoiki_code_tutorial.Models.Chuong;

import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

public class ChuongController implements Initializable {

    @FXML
    private VBox chuongContainer;//root
    @FXML
    private ScrollPane scrollPane;
    @FXML
    private ImageView imglogoCodeLearn, imglogout;

    Accordion accordion = new Accordion();


    private ChuongDAO chuongDAO = new ChuongDAO();


    private void loadAllChuong() {

        List<Chuong> chuongList = chuongDAO.getAllChuong("python");
        VBox CacChuong = new VBox();
        for (Chuong chuong : chuongList) {
            Button chuongButton = new Button(chuong.getTenChuong());
            CacChuong.getChildren().add(chuongButton);

            VBox vBoxCacBaiHoc = new VBox();
            List<BaiHoc> baiHoc = chuongDAO.getAllBaiHoc(chuong.getMaChuong());
            for (BaiHoc bai : baiHoc)
            {
                Button btn = new Button("Bài " + bai.getThuTu() + ": " +bai.getTenBH());
                btn.setPrefWidth(600);
//                btn.setTextAlignment(TextAlignment.LEFT);
                vBoxCacBaiHoc.getChildren().add(btn);
            }
            TitledPane chapter = new TitledPane(chuong.getTenChuong(), vBoxCacBaiHoc);
            chapter.setExpanded(false);
            chuongButton.setOnAction(event -> toggleBaiHocVisibility(chapter));
            accordion.getPanes().add(chapter);
        }
        chuongContainer.getChildren().add(accordion);

        scrollPane.setContent(chuongContainer);
        scrollPane.setFitToWidth(true);
    }

    private void toggleBaiHocVisibility( TitledPane chapter) {
        chapter.setExpanded(true);
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
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
        loadAllChuong();
    }
}
