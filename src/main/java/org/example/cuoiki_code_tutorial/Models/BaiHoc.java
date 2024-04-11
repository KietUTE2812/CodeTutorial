package org.example.cuoiki_code_tutorial.Models;

public class BaiHoc {
    private String maBH;
    private String tenBH;
    private String noiDung;
    private int thoiLuong;
    private String maChuong;
    private int thuTu;
    private int trangThai;

    public String getMaBH() {
        return maBH;
    }

    public void setMaBH(String maBH) {
        this.maBH = maBH;
    }

    public String getTenBH() {
        return tenBH;
    }

    public void setTenBH(String tenBH) {
        this.tenBH = tenBH;
    }

    public String getNoiDung() {
        return noiDung;
    }

    public void setNoiDung(String noiDung) {
        this.noiDung = noiDung;
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

    public int getTrangThai() {
        return trangThai;
    }

    public void setTrangThai(int trangThai) {
        this.trangThai = trangThai;
    }

    public BaiHoc(String maBH, String tenBH, String noiDung, int thoiLuong, String maChuong, int thuTu, int trangThai) {
        this.maBH = maBH;
        this.tenBH = tenBH;
        this.noiDung = noiDung;
        this.thoiLuong = thoiLuong;
        this.maChuong = maChuong;
        this.thuTu = thuTu;
        this.trangThai = trangThai;
    }
}
