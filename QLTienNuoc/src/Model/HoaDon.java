/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;


public class HoaDon {

    private String maKH;
    private String maHoaDon;
    private float khoiNuoc;
    private String hoten;
    private float thanhTien;

    public HoaDon() {
    }

    public HoaDon(String maKH, String maHoaDon, float khoiNuoc, String hoten, float thanhTien) {
        this.maKH = maKH;
        this.maHoaDon = maHoaDon;
        this.khoiNuoc = khoiNuoc;
        this.hoten = hoten;
        this.thanhTien = thanhTien;
    }

    public String getMaKH() {
        return maKH;
    }

    public void setMaKH(String maKH) {
        this.maKH = maKH;
    }

    public String getMaHoaDon() {
        return maHoaDon;
    }

    public void setMaHoaDon(String maHoaDon) {
        this.maHoaDon = maHoaDon;
    }

    public float getKhoiNuoc() {
        return khoiNuoc;
    }

    public void setKhoiNuoc(float khoiNuoc) {
        this.khoiNuoc = khoiNuoc;
    }

    public void setThanhTien(float thanhTien) {
        this.thanhTien = thanhTien;
    }

    public float getThanhTien() {
        return thanhTien;
    }

    public void setThanhTien(int thanhTien) {
        this.thanhTien = thanhTien;
    }

    public String getHoten() {
        return hoten;
    }

    public void setHoten(String hoten) {
        this.hoten = hoten;
    }

    public String[] toStringArray() {
        String k = String.valueOf(khoiNuoc);
        String t = String.valueOf(thanhTien);
        String[] arr = {maHoaDon, hoten, maKH, k, t};
        return arr;
    }

    @Override
    public String toString() {
        return "HoaDon{" + "maKH=" + maKH + ", maHoaDon=" + maHoaDon + ", khoiNuoc=" + khoiNuoc + ", hoten=" + hoten + ", thanhTien=" + thanhTien + '}';
    }


}
