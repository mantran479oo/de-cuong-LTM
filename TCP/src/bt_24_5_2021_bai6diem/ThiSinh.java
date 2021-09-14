/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bt_24_5_2021_bai6diem;

import java.io.Serializable;


/**
 *
 * @author vuan
 */
public class ThiSinh implements Serializable {
    
     private static final long serialVersionUID = 1234567L;
    
    private int id;
    private String hoTen;
    private int cmt;
    private String diaChi;
    private int namSinh;
    private float diem1;
    private float diem2;
    private float diem3;

    public ThiSinh() {
    }

    public ThiSinh(int id, String hoTen, int cmt, String diaChi, int namSinh, float diem1, float diem2, float diem3) {
        this.id = id;
        this.hoTen = hoTen;
        this.cmt = cmt;
        this.diaChi = diaChi;
        this.namSinh = namSinh;
        this.diem1 = diem1;
        this.diem2 = diem2;
        this.diem3 = diem3;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getHoTen() {
        return hoTen;
    }

    public void setHoTen(String hoTen) {
        this.hoTen = hoTen;
    }

    public int getCmt() {
        return cmt;
    }

    public void setCmt(int cmt) {
        this.cmt = cmt;
    }

    public String getDiaChi() {
        return diaChi;
    }

    public void setDiaChi(String diaChi) {
        this.diaChi = diaChi;
    }

    public int getNamSinh() {
        return namSinh;
    }

    public void setNamSinh(int namSinh) {
        this.namSinh = namSinh;
    }

    public float getDiem1() {
        return diem1;
    }

    public void setDiem1(float diem1) {
        this.diem1 = diem1;
    }

    public float getDiem2() {
        return diem2;
    }

    public void setDiem2(float diem2) {
        this.diem2 = diem2;
    }

    public float getDiem3() {
        return diem3;
    }

    public void setDiem3(float diem3) {
        this.diem3 = diem3;
    }

    @Override
    public String toString() {
        return "ThiSinh{" + "id=" + id + ", hoTen=" + hoTen + ", cmt=" + cmt + ", diaChi=" + diaChi + ", namSinh=" + namSinh + ", diem1=" + diem1 + ", diem2=" + diem2 + ", diem3=" + diem3 + '}';
    }    
}
