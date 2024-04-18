package org.example.cuoiki_code_tutorial.Models;

public class KiemThu {
    private int thuTu;
    private int thuTuKiemThu;
    private String input;
    private String output;

    public KiemThu() {
    }

    public KiemThu(int thuTu, int thuTuKiemThu, String input, String output) {
        this.thuTu = thuTu;
        this.thuTuKiemThu = thuTuKiemThu;
        this.input = input;
        this.output = output;
    }

    public int getThuTu() {
        return thuTu;
    }

    public void setThuTu(int thuTu) {
        this.thuTu = thuTu;
    }

    public int getThuTuKiemThu() {
        return thuTuKiemThu;
    }

    public void setThuTuKiemThu(int thuTuKiemThu) {
        this.thuTuKiemThu = thuTuKiemThu;
    }

    public String getInput() {
        return input;
    }

    public void setInput(String input) {
        this.input = input;
    }

    public String getOutput() {
        return output;
    }

    public void setOutput(String output) {
        this.output = output;
    }
}
