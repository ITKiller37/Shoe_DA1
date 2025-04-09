/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package repository;
import Utils.Dbconnection;
import java.sql.*;
import model.NhanVienLoginInfo;
/**
 *
 * @author Dang
 */
public class RP_DangNhap {
    private Connection conn;
    
    public RP_DangNhap(){
        this.conn = Dbconnection.getConnection();
    }
    
   public NhanVienLoginInfo getLoginInfo(String soDienThoai, String matKhau) {
        String SQL = "SELECT ID, VaiTro FROM NhanVien WHERE SoDienThoai = ? AND MatKhau = ?";
        
        try {
            PreparedStatement ps = this.conn.prepareStatement(SQL);
            ps.setString(1, soDienThoai);
            ps.setString(2, matKhau);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                int id = rs.getInt("ID");
                String vaiTro = rs.getString("VaiTro");
                return new NhanVienLoginInfo(id, vaiTro);
            }
            return null;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
