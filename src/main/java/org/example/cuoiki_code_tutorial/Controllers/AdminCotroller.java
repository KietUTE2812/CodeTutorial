package org.example.cuoiki_code_tutorial.Controllers;


import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import org.example.cuoiki_code_tutorial.Dao.HocVienDao;
import org.example.cuoiki_code_tutorial.Models.HocVien;

import java.net.URL;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import java.util.ResourceBundle;

public class AdminCotroller implements Initializable {


    @FXML
    private TableView<HocVien> tableHocVien;
    @FXML
    private TableColumn<HocVien, String> columnMaHV, columnTen,columnEmail,columnSDT,columnDiaChi,columnMaTK;
    @FXML
    private TableColumn<HocVien, Date> columnNgaySinh;
    @FXML
    private TableColumn<HocVien, Boolean> columnGioiTinh,columnTrangThai;

    @FXML
    private Button btnThem, btnCapNhat, btnXoa, btnThemAnh;
    @FXML
    private ImageView image;

    @FXML
    private TextField txtTen;
    @FXML
    private  TextField txtEmail;
    @FXML
    private  TextField txtSDT;
    @FXML
    private TextField txtDiaChi;
    @FXML
    private DatePicker txtNgaySinh;
    @FXML
    private ComboBox checkGioiTinh;
    @FXML
    private  ComboBox checkTrangThai;


    private ObservableList<HocVien> listhocvien;
    private HocVienDao hocVienDao;
    ObservableList<String> gioiTinhOptions = FXCollections.observableArrayList("Nam", "Nữ");
    ObservableList<String> trangThaiOptions = FXCollections.observableArrayList("Hoạt động", "Không hoạt động");


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        hocVienDao=new HocVienDao();
        listhocvien= FXCollections.observableArrayList();
        loadData();
        setCellValueFactory();

        // Set items for ComboBoxes outside the listener (one-time setup)
        checkGioiTinh.setItems(gioiTinhOptions);
        checkTrangThai.setItems(trangThaiOptions);

        // Handle table selection for pre-populating form and ComboBoxes
        tableHocVien.getSelectionModel().selectedItemProperty().addListener((obs, oldSelection, newSelection) -> {
            if (newSelection != null) {
                txtTen.setText(newSelection.getTenHV());
                txtEmail.setText(newSelection.getEmail());
                txtSDT.setText(newSelection.getSoDienThoai());
                txtDiaChi.setText(newSelection.getDiaChi());
                checkGioiTinh.getSelectionModel().select(newSelection.getGioiTinh() ? 0 : 1);
                checkTrangThai.getSelectionModel().select(newSelection.getTrangThai() ? 0 : 1);
            } else {

            }
        });



        //Xử lí sự kiện các nút
        btnThem.setOnAction(ActionEvent -> them());
        btnCapNhat.setOnAction(ActionEvent -> capnhat());
        btnXoa.setOnAction(ActionEvent -> xoa());
        btnThemAnh.setOnAction(ActionEvent -> themanh());

    }

    public void loadData() {
        listhocvien.clear();
        List<HocVien> hocvien = HocVienDao.selectAllHocVien();
        listhocvien.addAll(hocvien);
        tableHocVien.setItems(listhocvien);
    }
    private void setCellValueFactory() {
        columnMaHV.setCellValueFactory(new PropertyValueFactory<HocVien,String>("MaHV"));
        columnTen.setCellValueFactory(new PropertyValueFactory<HocVien,String>("TenHV"));
        columnEmail.setCellValueFactory(new PropertyValueFactory<HocVien,String>("Email"));
        columnSDT.setCellValueFactory(new PropertyValueFactory<HocVien,String>("SoDienThoai"));
        columnDiaChi.setCellValueFactory(new PropertyValueFactory<HocVien,String>("DiaChi"));
        columnMaTK.setCellValueFactory(new PropertyValueFactory<HocVien,String>("MaTK"));
        columnNgaySinh.setCellValueFactory(new PropertyValueFactory<HocVien,Date>("NgaySinh"));
        columnGioiTinh.setCellValueFactory(new PropertyValueFactory<HocVien,Boolean>("GioiTinh"));
        columnTrangThai.setCellValueFactory(new PropertyValueFactory<HocVien,Boolean>("TrangThai"));

    }
    public void them()
    {

    }
    public void capnhat()
    {

    }
    public void xoa()
    {

    }

    public void themanh()
    {

    }





    // Xử lí pane

    @FXML
    private AnchorPane paneAccount;

    @FXML
    private AnchorPane paneAddStudent;

    @FXML
    private AnchorPane paneAdmin;
    @FXML
    private AnchorPane paneAddLesson;

    @FXML
    private AnchorPane paneHome;
    @FXML
    private Button btnAccount;

    @FXML
    private Button btnAddLesson;

    @FXML
    private Button btnAddStudent;
    @FXML
    private Button btnHome;

        public  void switchForm(ActionEvent event)
    {
        if(event.getSource()==btnAccount)
        {
            paneAccount.setVisible(true);
            paneAddStudent.setVisible(false);
            paneHome.setVisible(false);
            paneAddLesson.setVisible(false);
        }
        else if(event.getSource()==btnHome)
        {
            paneAccount.setVisible(false);
            paneAddStudent.setVisible(false);
            paneHome.setVisible(true);
            paneAddLesson.setVisible(false);
        }
        else if(event.getSource()==btnAddLesson)
        {
            paneAccount.setVisible(false);
            paneAddStudent.setVisible(false);
            paneHome.setVisible(false);
            paneAddLesson.setVisible(true);
        }
        else if(event.getSource()==btnAddStudent)
        {
            paneAccount.setVisible(false);
            paneAddStudent.setVisible(true);
            paneHome.setVisible(false);
            paneAddLesson.setVisible(false);
        }
    }

}
