package org.example.cuoiki_code_tutorial.Controllers;

import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.VBox;
import javafx.fxml.FXML;
import javafx.scene.text.TextAlignment;
import javafx.stage.Stage;
import org.example.cuoiki_code_tutorial.Dao.ChuongDAO;
import org.example.cuoiki_code_tutorial.Models.BaiHoc;
import org.example.cuoiki_code_tutorial.Models.Chuong;

import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.List;
import java.util.ResourceBundle;

public class ChuongController implements Initializable {

    @FXML
    private VBox chuongContainer;//root
    @FXML
    private ScrollPane scrollPane;

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
                Button btn = new Button("Bài " + bai.getThuTu() + ": " +bai.getTenBaiHoc());
                btn.setPrefWidth(600);
                btn.setOnAction(event -> {
                    Button clickedButton = (Button) event.getSource();
                    try {
                        goBaiHocLayout(bai.getMaBaiHoc(), bai.getMaChuong(), clickedButton);
                    } catch (SQLException e) {
                        throw new RuntimeException(e);
                    } catch (IOException e) {
                        throw new RuntimeException(e);
                    }
                });
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
        loadAllChuong();
    }


    @FXML
    public void goBaiHocLayout(String maBH, String maChuong, Button btn) throws SQLException, IOException {

        FXMLLoader loader = new FXMLLoader(getClass().getResource("/FXML/lesson_compiler.fxml"));
        Parent layout2Root = loader.load();
        layout2Root.getStylesheets().add(getClass().getResource("/CSS/styles_baihoc.css").toExternalForm());
        layout2Root.getStyleClass().add("background");
        LessonCompiler layout2Controller = loader.getController();
        layout2Controller.loadBaiHocByMaBHMaChuong(maBH, maChuong);
        Scene layout2Scene = new Scene(layout2Root);
        Stage stage = (Stage)  btn.getScene().getWindow();
        stage.setScene(layout2Scene);
        stage.show();
    }

}
