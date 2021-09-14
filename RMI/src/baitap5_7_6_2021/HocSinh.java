/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package baitap5_7_6_2021;

/**
 *
 * @author vuan
 */
public class HocSinh {
    int maSV;
    String ten;
    String diaChi;
    String gioiTinh;
    float diemTongKet;

    public HocSinh() {
    }

    public HocSinh(int maSV, String ten, String diaChi, String gioiTinh, float diemTongKet) {
        this.maSV = maSV;
        this.ten = ten;
        this.diaChi = diaChi;
        this.gioiTinh = gioiTinh;
        this.diemTongKet = diemTongKet;
    }

    public int getMaSV() {
        return maSV;
    }

    public void setMaSV(int maSV) {
        this.maSV = maSV;
    }

    public String getTen() {
        return ten;
    }

    public void setTen(String ten) {
        this.ten = ten;
    }

    public String getDiaChi() {
        return diaChi;
    }

    public void setDiaChi(String diaChi) {
        this.diaChi = diaChi;
    }

    public String getGioiTinh() {
        return gioiTinh;
    }

    public void setGioiTinh(String gioiTinh) {
        this.gioiTinh = gioiTinh;
    }

    public float getDiemTongKet() {
        return diemTongKet;
    }

    public void setDiemTongKet(float diemTongKet) {
        this.diemTongKet = diemTongKet;
    }

    @Override
    public String toString() {
        return "HocSinh{" + "maSV=" + maSV + ", ten=" + ten + ", diaChi=" + diaChi + ", gioiTinh=" + gioiTinh + ", diemTongKet=" + diemTongKet + '}';
    }
    
}
