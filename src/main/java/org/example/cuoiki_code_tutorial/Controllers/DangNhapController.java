package org.example.cuoiki_code_tutorial.Controllers;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import org.example.cuoiki_code_tutorial.Dao.DangNhapDao;
import org.example.cuoiki_code_tutorial.Models.TaiKhoan;
import org.example.cuoiki_code_tutorial.Utils.Session;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class DangNhapController implements Initializable {
    @FXML
    private Button btnBackApp;

    @FXML
    private Button btnDangNhap;

    @FXML
    private Label labelDangKi;

    @FXML
    private Label labelQuenMatKhau;

    @FXML
    private AnchorPane paneDangNhap;

    @FXML
    private RadioButton rdHocVien;

    @FXML
    private RadioButton rdQuanTriVien;

    @FXML
    private PasswordField txtMatKhau;

    @FXML
    private TextField txtTenDangNhap;


    //gọi DAO
    private DangNhapDao dangNhapDao;


    // biến check vai trò
    private boolean ischeck;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        dangNhapDao = new DangNhapDao();
        btnDangNhap.setOnAction(ActionEvent->dangnhap());
        labelDangKi.setOnMouseClicked(ActionEvent-> {
            try {
                dangki();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        });
        rdQuanTriVien.setOnAction(actionEvent -> {
            rdQuanTriVien.setSelected(true);
            rdHocVien.setSelected(false);
            ischeck=false;
        });
        rdHocVien.setOnAction(actionEvent -> {
            ischeck=true;
            rdHocVien.setSelected(true);
            rdQuanTriVien.setSelected(false);
        });

    }

    public void dangnhap() {
        String tenDangnhap = txtTenDangNhap.getText();
        String matkhau = txtMatKhau.getText();
        if (!rdQuanTriVien.isSelected() && !rdHocVien.isSelected()) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Đăng nhập không thành công");
            alert.setHeaderText(null);
            alert.setContentText("Vui lòng chọn vai trò (Quản trị viên/Học viên) trước khi đăng nhập!");
            alert.showAndWait();
            return;
        }

        TaiKhoan taiKhoan = new TaiKhoan(tenDangnhap, matkhau, ischeck);
        try{
            TaiKhoan checktaikhoan = dangNhapDao.onLogin(taiKhoan);
            if(checktaikhoan != null) {
                if (checktaikhoan.isVaiTro()) {
//                    // Nếu là học viên
//                    Alert alert = new Alert(Alert.AlertType.ERROR);
//                    alert.setTitle("Đăng nhập");
//                    alert.setHeaderText(null);
//                    alert.setContentText("Bạn đang đăng nhập với tư cách là Học Viên!");
//                    alert.showAndWait();
                    btnDangNhap.getScene().getWindow().hide();
                    Parent root = FXMLLoader.load(getClass().getResource("/FXML/user.fxml"));
                    Stage stage = new Stage();
                    Image icon = new Image(getClass().getResourceAsStream("/Image/icon.png"));
                    stage.getIcons().add(icon);
                    stage.setScene(new Scene(root));
                    stage.show();
                } else {
                    // Nếu là quản trị viên
//                    Alert alert = new Alert(Alert.AlertType.ERROR);
//                    alert.setTitle("Đăng nhập");
//                    alert.setHeaderText(null);
//                    alert.setContentText("Bạn đang đăng nhập với tư cách là Quản trị viên!");
//                    alert.showAndWait();
                    btnDangNhap.getScene().getWindow().hide();
                    Parent root = FXMLLoader.load(getClass().getResource("/FXML/admin.fxml"));
                    Stage stage = new Stage();
                    Image icon = new Image(getClass().getResourceAsStream("/Image/icon.png"));
                    stage.getIcons().add(icon);
                    stage.setScene(new Scene(root));
                    stage.show();
                }
            } else {
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Đăng nhập không thành công");
                alert.setHeaderText(null);
                alert.setContentText("Tên đăng nhập hoặc mật khẩu không đúng. Vui lòng thử lại!");
                alert.showAndWait();
            }
        } catch (ClassNotFoundException |IOException e) {
            throw new RuntimeException(e);
        }
        String tendangnhap = txtTenDangNhap.getText();
        Session.getInstance().setLoggedInUsername(tendangnhap);
    }


    public void dangki() throws IOException {
        labelDangKi.getScene().getWindow().hide();
        Parent root = FXMLLoader.load(getClass().getResource("/FXML/register.fxml"));
        Stage stage = new Stage();
        stage.setScene(new Scene(root));
        stage.show();
    }

    public void thoat() {
        System.exit(0);
    }
    @FXML
    void passwordField(KeyEvent event) {


    }
}
