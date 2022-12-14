/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ControllerGD;
import DatabaseConnect.DBConnect;
import GiaoDien.GDChiSoNuoc;
import Model.ChiSoNuoc;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;


public class ChiSoNuocController {
    Connection connection;
    DBConnect dbConnec;
    GDChiSoNuoc viewCSD;
    public void insert(ChiSoNuoc csd) {
        try {
            String sql = "insert CHISONUOC values(?,?,?,?)";
            dbConnec=new DBConnect();
            connection=dbConnec.connect();
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1, csd.getMaKH());
            ps.setString(2, csd.getMaThang());
            ps.setString(3, String.valueOf(csd.getChiSoCu()));
            ps.setString(4, String.valueOf(csd.getChiSoMoi()));
            int result = ps.executeUpdate();
            if (result == 1) {
                JOptionPane.showMessageDialog(viewCSD,"Thêm thành công!");
            }
            ps.close();
        } catch (Exception e) {
            if (e.toString().contains("PRIMARY KEY")) {
                JOptionPane.showMessageDialog(viewCSD, "Trùng khoá chính!");
            }else {
                Logger.getLogger(ChiSoNuoc.class.getName()).log(Level.SEVERE, null, e);
            }
        }
    }
    public void update(ChiSoNuoc csd){
        try {
                String sql = "UPDATE CHISONUOC SET chisocu = ?,chisomoi = ? WHERE maKH = ?";
                dbConnec=new DBConnect();
                connection=dbConnec.connect();
                PreparedStatement ps = connection.prepareStatement(sql);
                ps.setInt(1, csd.getChiSoCu());
                ps.setInt(2, csd.getChiSoMoi());
                ps.setString(3, csd.getMaKH());
                int result = ps.executeUpdate();
                if (result == 1) {
                    JOptionPane.showMessageDialog(viewCSD, "Thay đổi giá trị thành công!");
                } else {
                    JOptionPane.showMessageDialog(viewCSD, "Thay đổi thất bại!");
                }
                ps.close();
        } catch (SQLException ex) {
            if (ex.toString().contains("PRIMARY KEY")) {
                JOptionPane.showMessageDialog(viewCSD, "Trùng khoá chính!");
            }
            else {
                Logger.getLogger(ChiSoNuoc.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    public void delete(String MaKH, String MaThang){
        try {
                String sql = "DELETE FROM CHISONUOC WHERE MaKH=? and MaThang=?";
                dbConnec=new DBConnect();
                connection=dbConnec.connect();
                PreparedStatement ps = connection.prepareStatement(sql);
                ps.setString(1, MaKH);
                ps.setString(2, MaThang);
                int result = ps.executeUpdate();
                if (result == 1) {
                    JOptionPane.showMessageDialog(viewCSD, "xóa thành công!");
                } else {
                    JOptionPane.showMessageDialog(viewCSD, "xóa thất bại!");
                }
                //getDataFromDB();
                ps.close();
        } catch (SQLException ex) {
            {
                Logger.getLogger(ChiSoNuoc.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
}
