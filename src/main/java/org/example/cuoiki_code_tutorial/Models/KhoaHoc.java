package org.example.cuoiki_code_tutorial.Models;

import java.time.LocalDate;

public class KhoaHoc {
    private String maKH;
    private String tenKH;
    private String moTa;
    private String hinhAnh;
    private LocalDate ngayTao;
    private int TrangThai;
    private String maAD;

    public KhoaHoc(String maKH, String tenKH, String moTa, String hinhAnh, LocalDate ngayTao, int trangThai, String maAD) {
        this.maKH = maKH;
        this.tenKH = tenKH;
        this.moTa = moTa;
        this.hinhAnh = hinhAnh;
        this.ngayTao = ngayTao;
        TrangThai = trangThai;
        this.maAD = maAD;
    }

    public String getMaKH() {
        return maKH;
    }

    public void setMaKH(String maKH) {
        this.maKH = maKH;
    }

    public String getTenKH() {
        return tenKH;
    }

    public void setTenKH(String tenKH) {
        this.tenKH = tenKH;
    }

    public String getMoTa() {
        return moTa;
    }

    public void setMoTa(String moTa) {
        this.moTa = moTa;
    }

    public String getHinhAnh() {
        return hinhAnh;
    }

    public void setHinhAnh(String hinhAnh) {
        this.hinhAnh = hinhAnh;
    }

    public LocalDate getNgayTao() {
        return ngayTao;
    }

    public void setNgayTao(LocalDate ngayTao) {
        this.ngayTao = ngayTao;
    }

    public int getTrangThai() {
        return TrangThai;
    }

    public void setTrangThai(int trangThai) {
        TrangThai = trangThai;
    }

    public String getMaAD() {
        return maAD;
    }

    public void setMaAD(String maAD) {
        this.maAD = maAD;
    }
}
