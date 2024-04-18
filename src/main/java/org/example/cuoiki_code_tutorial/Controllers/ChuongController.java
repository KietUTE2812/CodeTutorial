package org.example.cuoiki_code_tutorial.Controllers;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
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

import java.net.URL;
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
                Button btn = new Button("Bài " + bai.getThuTu() + ": " +bai.getTenBH());
                btn.setOnAction(new EventHandler<ActionEvent>() {
                    @Override
                    public void handle(ActionEvent event) {
                        try {
                            // Load FXML file
                            FXMLLoader loader = new FXMLLoader(getClass().getResource("/FXML/lesson_compiler.fxml"));
                            LessonCompiler ls = new LessonCompiler(bai.getMaBH(), bai.getMaChuong());
                            loader.setController(ls);
                            Parent root = loader.load();

                            // Create new scene
                            Scene scene = new Scene(root);

                            // Get the stage
                            Stage stage = (Stage) btn.getScene().getWindow();

                            // Set the new scene
                            stage.setScene(scene);
                            stage.show();
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    }
                });
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
        loadAllChuong();
    }
}
