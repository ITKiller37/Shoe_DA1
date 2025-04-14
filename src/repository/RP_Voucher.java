/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package repository;

import model.Voucher;
import Utils.Dbconnection;
import java.sql.*;
import java.util.ArrayList;

public class RP_Voucher {

    Connection con = null;
    PreparedStatement ps = null;
    ResultSet rs = null;
    String sql = null;

    // Hiển thị tất cả voucher
    public ArrayList<Voucher> getAll() {
        ArrayList<Voucher> listVouchers = new ArrayList<>();
        sql = "SELECT id, maVoucher, tenVoucher, ngayBatDau, ngayKetThuc, loaiVoucher, giaTri, trangThai FROM Voucher";
        try {
            con = Dbconnection.getConnection();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                int id = rs.getInt("id");
                String maVoucher = rs.getString("maVoucher");
                String tenVoucher = rs.getString("tenVoucher");
                String ngayBatDau = rs.getString("ngayBatDau");
                String ngayKetThuc = rs.getString("ngayKetThuc");
                String loaiVoucher = rs.getString("loaiVoucher");
                Double giaTri = rs.getDouble("giaTri");
                int trangThai = rs.getInt("trangThai");

                Voucher voucher = new Voucher(id, maVoucher, tenVoucher, ngayBatDau, ngayKetThuc, loaiVoucher, giaTri, trangThai);
                listVouchers.add(voucher);
            }
            return listVouchers;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    // Thêm một voucher
    public int add(Voucher voucher) {
        sql = "INSERT INTO Voucher (maVoucher, tenVoucher, ngayBatDau, ngayKetThuc, loaiVoucher, giaTri, trangThai) VALUES (?, ?, ?, ?, ?, ?, ?)";
        try {
            con = Dbconnection.getConnection();
            ps = con.prepareStatement(sql);
            ps.setString(1, voucher.getMaVoucher());
            ps.setString(2, voucher.getTenVoucher());
            ps.setString(3, voucher.getNgayBatDau());
            ps.setString(4, voucher.getNgayKetThuc());
            ps.setString(5, voucher.getLoaiVoucher());
            ps.setDouble(6, voucher.getGiaTri());
            ps.setInt(7, voucher.getTrangThai());
            return ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        }
    }


    // Cập nhật một voucher
    public int update(Voucher voucher, int id) {
        sql = "UPDATE Voucher SET maVoucher = ?, tenVoucher = ?, ngayBatDau = ?, ngayKetThuc = ?, loaiVoucher = ?, giaTri = ?, trangThai = ? WHERE id = ?";
        try {
            con = Dbconnection.getConnection();
            ps = con.prepareStatement(sql);
            ps.setString(1, voucher.getMaVoucher());
            ps.setString(2, voucher.getTenVoucher());
            ps.setString(3, voucher.getNgayBatDau());
            ps.setString(4, voucher.getNgayKetThuc());
            ps.setString(5, voucher.getLoaiVoucher());
             ps.setDouble(6, voucher.getGiaTri());
            ps.setInt(7, voucher.getTrangThai());
            ps.setInt(8, id);
            return ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
            return 0;
        }
    }
    
     public ArrayList<Voucher> searchByKeyword(String keyword) {
    ArrayList<Voucher> listVouchers = new ArrayList<>();
    sql = "SELECT ID, MaVoucher, TenVoucher, NgayBatDau, NgayKetThuc, LoaiVoucher, GiaTri, TrangThai FROM Voucher WHERE ID LIKE ? OR MaVoucher LIKE ? OR TenVoucher LIKE ?";
    try {
        con = Dbconnection.getConnection();
        ps = con.prepareStatement(sql);
        String searchKeyword = "%" + keyword + "%";
        // Tìm theo ID (chuyển ID thành chuỗi để so sánh)
        ps.setString(1, keyword);
        // Tìm theo MaVoucher
        ps.setString(2, searchKeyword);
        // Tìm theo TenVoucher
        ps.setString(3, searchKeyword);
        rs = ps.executeQuery();
        while (rs.next()) {
            int id = rs.getInt("id");
            String voucherCode = rs.getString("MaVoucher");
            String voucherName = rs.getString("TenVoucher");
            String startDate = rs.getString("NgayBatDau");
            String endDate = rs.getString("NgayKetThuc");
            String voucherType = rs.getString("LoaiVoucher");
            Double value = rs.getDouble("GiaTri");
            int status = rs.getInt("TrangThai");

            Voucher voucher = new Voucher(id, voucherCode, voucherName, startDate, endDate, voucherType, value, status);
            listVouchers.add(voucher);
        }
        return listVouchers;
    } catch (SQLException e) {
        e.printStackTrace();
    }
    return null;
}
     
         public boolean checkMaExists(String maVoucher) {
        String SQL = "SELECT COUNT(*) FROM Voucher WHERE MaVoucher = ?";
        try {
            con = Dbconnection.getConnection();
            ps = con.prepareStatement(SQL);
            ps.setString(1, maVoucher);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                return rs.getInt(1) > 0; // Trả về true nếu mã đã tồn tại
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }
}
