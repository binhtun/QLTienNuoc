/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ControllerGD;

import DatabaseConnect.DBConnect;
import GiaoDien.GDQuanLyHoTieuThu;
import Model.HoTieuThuNuoc;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;


public class HoTieuThuController {
    Connection connection;
    DBConnect dbConnec;
    GDQuanLyHoTieuThu viewHTTD;
    public void insert(HoTieuThuNuoc httn) {
        try {
            String sql = "INSERT HOTIEUTHU VALUES (?, ? ,? ,? ,? ,? ,? ,? ,?)";
            dbConnec=new DBConnect();
            connection=dbConnec.connect();
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1, httn.getMaKH());
            ps.setString(2, httn.getHoTen());
            ps.setString(3, httn.getCmnd());
            ps.setString(4, httn.getDiaChi());
            ps.setString(5, httn.getGioiTinh());
            ps.setObject(6, httn.utilDateToSQLDate(httn.getNgaySinh()));
            ps.setString(7, httn.getSdt());
            ps.setObject(8, httn.utilDateToSQLDate(httn.getNgayDK()));
            ps.setFloat(9, httn.getKhoiNuoc());
            int result = ps.executeUpdate();
            if (result == 1) {
                JOptionPane.showMessageDialog(viewHTTD, "Thêm thành công!");
            } else {
                JOptionPane.showMessageDialog(viewHTTD, "Thêm thất bại!");
            }
            ps.close();
        } catch (SQLException ex) {
            if (ex.toString().contains("PRIMARY KEY")) {
                JOptionPane.showMessageDialog(viewHTTD, "Trùng khoá chính!");
            }else {
                Logger.getLogger(HoTieuThuController.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    public void update(HoTieuThuNuoc httn){
        try{
            String sql = "UPDATE [dbo].[HOTIEUTHU] SET hoTen = ?"
                        + ",CMND = ?"
                        + ",diaChi = ?"
                        + ",gioiTinh = ?"
                        + ",ngaySinh = ?"
                        + ",sdt = ?"
                        + ",ngayDangKi = ?"
                        + ",khoiNuoc = ?"
                        + " WHERE maKH like ?";
                dbConnec=new DBConnect();
                connection=dbConnec.connect();
                PreparedStatement ps = connection.prepareStatement(sql);
                ps.setString(1, httn.getHoTen());
                ps.setString(2, httn.getCmnd());
                ps.setString(3, httn.getDiaChi());
                ps.setString(4, httn.getGioiTinh());
                ps.setObject(5, httn.utilDateToSQLDate(httn.getNgaySinh()));
                ps.setString(6, httn.getSdt());
                ps.setObject(7, httn.utilDateToSQLDate(httn.getNgayDK()));
                ps.setFloat(8, httn.getKhoiNuoc());
                ps.setString(9, httn.getMaKH());
                int result = ps.executeUpdate();
                if (result == 1) {
                    JOptionPane.showMessageDialog(viewHTTD, "Thay đổi giá trị thành công!");
                }else {
                    JOptionPane.showMessageDialog(viewHTTD, "Thay đổi thất bại!");
                }
                ps.close();
        } catch (SQLException ex) {
                Logger.getLogger(HoTieuThuController.class.getName()).log(Level.SEVERE, null, ex);
                JOptionPane.showMessageDialog(viewHTTD, "Không thể cập nhật giá trị!");
            }
        }
    public void deleteFromChiSoDien(String MaKH) {
        try {
            String sql1 = "delete from CHISONUOC where MaKH=?";
            dbConnec=new DBConnect();
            connection=dbConnec.connect();
            PreparedStatement ps1 = connection.prepareStatement(sql1);
            ps1.setString(1, MaKH);
            int result = ps1.executeUpdate();
            ps1.close();
            ps1.executeQuery();
        } catch (SQLException ex) {
            Logger.getLogger(HoTieuThuController.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
    public void deleteFromThongKe(String MaKH) {
        try {
            String sql2 = "delete from THONGKE where MaKH=?";
            dbConnec=new DBConnect();
            connection=dbConnec.connect();
            PreparedStatement ps2 = connection.prepareStatement(sql2);
            ps2.setString(1, MaKH);
            int result = ps2.executeUpdate();
            ps2.close();
            ps2.executeQuery();
        } catch (SQLException ex) {
            Logger.getLogger(HoTieuThuController.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
    public void deleteFromHoaDon(String MaKH){
        try {
                String sq3 = "DELETE FROM HOADON WHERE MaKH=?";
                dbConnec=new DBConnect();
                connection=dbConnec.connect();
                PreparedStatement ps3 = connection.prepareStatement(sq3);
                ps3.setString(1, MaKH);
                int result = ps3.executeUpdate();
                ps3.close();
        } catch (SQLException ex) {
            {
                Logger.getLogger(HoTieuThuController.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    public void delete(String MaKH){
        try {
                String sq4 = "DELETE FROM HOTIEUTHU WHERE MaKH=?";
                dbConnec=new DBConnect();
                connection=dbConnec.connect();
                PreparedStatement ps4 = connection.prepareStatement(sq4);
                ps4.setString(1, MaKH);
                int result = ps4.executeUpdate();
                if (result == 1) {
                    JOptionPane.showMessageDialog(viewHTTD, "xóa thành công!");
                } else {
                    JOptionPane.showMessageDialog(viewHTTD, "xóa thất bại!");
                }
                ps4.close();
        } catch (SQLException ex) {
            {
                Logger.getLogger(HoTieuThuController.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
}
