package org.example.cuoiki_code_tutorial.Controllers;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import org.example.cuoiki_code_tutorial.Dao.HocVienDao;
import org.example.cuoiki_code_tutorial.Models.HocVien;
import org.example.cuoiki_code_tutorial.Utils.Session;

import java.sql.Date;
import java.time.LocalDate;

public class UserController {

    @FXML
    private Button btnAccount;
    @FXML
    private Button btnHome;
    @FXML
    private AnchorPane paneAccount;
    @FXML
    private AnchorPane paneHome;
    @FXML
    private AnchorPane paneUser;
    @FXML
    private Label labelTen;
    @FXML
    private Button btnCapNhat;
    @FXML
    private Button btnThemAnh;
    @FXML
    private ComboBox<String> checkGioiTinh;
    @FXML
    private ComboBox<String> checkTrangThai;
    @FXML
    private ImageView image;
    @FXML
    private TextField txtDiaChi;
    @FXML
    private TextField txtEmail;
    @FXML
    private DatePicker txtNgaySinh;
    @FXML
    private TextField txtSDT;
    @FXML
    private TextField txtTen;
    private HocVienDao hocVienDao;

    public void CapNhatThongTin() {
        hocVienDao = new HocVienDao();
        String loggedInUsername = Session.getInstance().getLoggedInUsername();
        if (loggedInUsername != null) {
            HocVien hocVien = hocVienDao.getInfoHocVien(loggedInUsername);
            if (hocVien != null) {
                txtTen.setText(hocVien.getTenHV());
                txtEmail.setText(hocVien.getEmail());
                txtSDT.setText(hocVien.getSoDienThoai());
                txtDiaChi.setText(hocVien.getDiaChi());
                java.sql.Date ngaySinhSQL = (Date) hocVien.getNgaySinh();
                if (ngaySinhSQL != null) {
                    LocalDate ngaySinhLocalDate = ngaySinhSQL.toLocalDate();
                    txtNgaySinh.setValue(ngaySinhLocalDate);
                }
                ObservableList<String> gioiTinhList = FXCollections.observableArrayList("Nam", "Nữ");
                checkGioiTinh.setItems(gioiTinhList);
                if (hocVien.getGioiTinh()) {
                    checkGioiTinh.setValue("Nam");
                } else {
                    checkGioiTinh.setValue("Nữ");
                }

                ObservableList<String> trangThaiList = FXCollections.observableArrayList("Hoạt động", "Không hoạt động");
                checkTrangThai.setItems(trangThaiList);
                if (hocVien.getTrangThai()) {
                    checkTrangThai.setValue("Hoạt động");
                } else {
                    checkTrangThai.setValue("Không hoạt động");
                }

                checkTrangThai.setDisable(true);
            } else {
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Lỗi");
                alert.setHeaderText(null);
                alert.setContentText("Không tìm thấy thông tin học viên!");
                alert.showAndWait();
            }
        } else {
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("Chưa đăng nhập");
            alert.setHeaderText(null);
            alert.setContentText("Vui lòng đăng nhập để truy cập thông tin học viên!");
            alert.showAndWait();
        }
    }

    @FXML
    void switchForm(ActionEvent event) {
        if (event.getSource() == btnAccount) {
            paneAccount.setVisible(true);
            paneHome.setVisible(false);
            CapNhatThongTin(); // Gọi phương thức cập nhật thông tin học viên khi chuyển tab
        } else if (event.getSource() == btnHome) {
            paneAccount.setVisible(false);
            paneHome.setVisible(true);
        }
    }
}
