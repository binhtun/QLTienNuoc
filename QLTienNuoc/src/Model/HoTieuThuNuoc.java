/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.text.SimpleDateFormat;
import java.util.Date;


public class HoTieuThuNuoc {
    protected String  maKH;
    protected String  hoTen;
    protected String  gioiTinh;
    protected Date    ngaySinh;
    protected String  cmnd;
    protected String  sdt;
    protected Date  ngayDK;
    protected String  diaChi;
    protected float khoiNuoc;

    public HoTieuThuNuoc() {
    }

    public HoTieuThuNuoc(String maKH, String hoTen, String gioiTinh, Date ngaySinh, String cmnd, String sdt, Date ngayDK, String diaChi, float khoiNuoc) {
        this.maKH = maKH;
        this.hoTen = hoTen;
        this.gioiTinh = gioiTinh;
        this.ngaySinh = ngaySinh;
        this.cmnd = cmnd;
        this.sdt = sdt;
        this.ngayDK = ngayDK;
        this.diaChi = diaChi;
        this.khoiNuoc = khoiNuoc;
    }


    public String getMaKH() {
        return maKH;
    }

    public void setMaKH(String maKH) {
        this.maKH = maKH;
    }

    public String getHoTen() {
        return hoTen;
    }

    public void setHoTen(String hoTen) {
        this.hoTen = hoTen;
    }

    public String getGioiTinh() {
        return gioiTinh;
    }

    public void setGioiTinh(String gioiTinh) {
        this.gioiTinh = gioiTinh;
    }

    public Date getNgaySinh() {
        return ngaySinh;
    }

    public void setNgaySinh(Date ngaySinh) {
        this.ngaySinh = ngaySinh;
    }

    public String getCmnd() {
        return cmnd;
    }

    public void setCmnd(String cmnd) {
        this.cmnd = cmnd;
    }

    public String getSdt() {
        return sdt;
    }

    public void setSdt(String sdt) {
        this.sdt = sdt;
    }

    public Date getNgayDK() {
        return ngayDK;
    }

    public void setNgayDK(Date ngayDK) {
        this.ngayDK = ngayDK;
    }

    public String getDiaChi() {
        return diaChi;
    }

    public void setDiaChi(String diaChi) {
        this.diaChi = diaChi;
    }

    public float getKhoiNuoc() {
        return khoiNuoc;
    }

    public void setKhoiNuoc(float khoiNuoc) {
        this.khoiNuoc = khoiNuoc;
    }

    public String dateToString(Date date)
    {
        return new SimpleDateFormat("dd/MM/yyyy").format(date);
    }
  
    public String[] toStringArray()
    {
        String [] stringArray= {maKH, hoTen,gioiTinh, dateToString(ngaySinh), cmnd,sdt,dateToString(ngayDK),diaChi,(String.valueOf(khoiNuoc))};
        return stringArray;
    }
    public java.sql.Date utilDateToSQLDate(Date date)
    {
        return new java.sql.Date(date.getTime()); 
    }
    public Date sqlDateToUtilDate(java.sql.Date date)
    {
        return new java.util.Date(date.getTime()); 
    }

    @Override
    public String toString() {
        return "ThongTinHoTieuThuModel{" + "cmnd=" + cmnd + ", diaChi=" + diaChi + ", maKH=" + maKH + ", ngayDK=" + ngayDK + ", ngaySinh=" + ngaySinh + ", sdt=" + sdt + ", ten=" + hoTen + '}';
    }
}
