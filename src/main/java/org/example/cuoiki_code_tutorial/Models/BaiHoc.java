package org.example.cuoiki_code_tutorial.Models;

public class BaiHoc {
    private String maBaiHoc;
    private String tenBaiHoc;
    private String noiDung;
    private String dinhDang;
    private int thoiLuong;
    private String maChuong;
    private int thuTu;
    private String trangThai;
    private int gioiHanKyTu;
    private String mucDo;

    public String getMucDo() {
        return mucDo;
    }

    public void setMucDo(String mucDo) {
        this.mucDo = mucDo;
    }

    public int getGioiHanKyTu() {
        return gioiHanKyTu;
    }

    public void setGioiHanKyTu(int gioiHanKyTu) {
        this.gioiHanKyTu = gioiHanKyTu;
    }

    public BaiHoc( String tenBaiHoc, String noiDung, int gioiHanKyTu, String mucDo) {
        this.tenBaiHoc = tenBaiHoc;
        this.noiDung = noiDung;
        this.gioiHanKyTu = gioiHanKyTu;
        this.mucDo = mucDo;
    }

    public BaiHoc() {
    }

    public BaiHoc(String maBaiHoc, String tenBaiHoc, String noiDung, String dinhDang, int thoiLuong, String maChuong, int thuTu, String trangThai) {
        this.maBaiHoc = maBaiHoc;
        this.tenBaiHoc = tenBaiHoc;
        this.noiDung = noiDung;
        this.dinhDang = dinhDang;
        this.thoiLuong = thoiLuong;
        this.maChuong = maChuong;
        this.thuTu = thuTu;
        this.trangThai = trangThai;
    }

    public String getMaBaiHoc() {
        return maBaiHoc;
    }

    public void setMaBaiHoc(String maBaiHoc) {
        this.maBaiHoc = maBaiHoc;
    }

    public String getTenBaiHoc() {
        return tenBaiHoc;
    }

    public void setTenBaiHoc(String tenBaiHoc) {
        this.tenBaiHoc = tenBaiHoc;
    }

    public String getNoiDung() {
        return noiDung;
    }

    public void setNoiDung(String noiDung) {
        this.noiDung = noiDung;
    }

    public String getDinhDang() {
        return dinhDang;
    }

    public void setDinhDang(String dinhDang) {
        this.dinhDang = dinhDang;
    }

    public int getThoiLuong() {
        return thoiLuong;
    }

    public void setThoiLuong(int thoiLuong) {
        this.thoiLuong = thoiLuong;
    }

    public String getMaChuong() {
        return maChuong;
    }

    public void setMaChuong(String maChuong) {
        this.maChuong = maChuong;
    }

    public int getThuTu() {
        return thuTu;
    }

    public void setThuTu(int thuTu) {
        this.thuTu = thuTu;
    }

    public String getTrangThai() {
        return trangThai;
    }

    public void setTrangThai(String trangThai) {
        this.trangThai = trangThai;
    }
}
