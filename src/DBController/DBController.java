/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DBController;

import Class.ChiTietSanPhamChiNhanh;
import Class.DoiTac;
import Class.DonHang;
import Class.SanPhamDoiTac;
import DBConnection.DBConnection;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;


/**
 *
 * @author trisu
 */
public class DBController {
    
    public static boolean insert(String maHD, String maKH, String date){
        try {
            Connection conn = DBConnection.getConnection();
            String sql = "INSERT INTO HoaDon VALUES(?,?,?,0)";
            PreparedStatement preparedStatement = conn.prepareStatement(sql);
            preparedStatement.setString(1, maHD);
            preparedStatement.setString(2, maKH);
            preparedStatement.setString(3, date);
            
            preparedStatement.executeUpdate();
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(DBController.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }
    
        public static boolean insert_SP_CN(String masp, String tensp, String mota, int soluong, int dongia, String macn){
        try {
            Connection conn = DBConnection.getConnection();
            String sql = "exec THEM_SP_CN ?,?,?,?,?,?";
            PreparedStatement preparedStatement = conn.prepareStatement(sql);
            preparedStatement.setString(1, masp);
            preparedStatement.setString(2, tensp);
            preparedStatement.setString(3, mota);
            preparedStatement.setString(4, macn);
            preparedStatement.setInt(5, soluong);
            preparedStatement.setInt(6, dongia);
            
            preparedStatement.executeUpdate();
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(DBController.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }
    
    public static ArrayList<DoiTac> getTenDoiTac(){
        ArrayList<DoiTac> list = new ArrayList<>();
        Connection conn = null;
        try{
            conn = DBConnection.getConnection();
            Statement hd = conn.createStatement();
            ResultSet rs = hd.executeQuery("select MaDT,TenDoiTac from DoiTac");
            while(rs.next()){
                String id = rs.getString("MaDT");
                String ten = rs.getString("TenDoiTac");
                
                DoiTac dt = new DoiTac(id,ten);
                list.add(dt);
            }
        }catch (SQLException ex) {
            Logger.getLogger(DBController.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
    }
    
        public static ArrayList<SanPhamDoiTac> getSpDoiTac(String maDT){
        ArrayList<SanPhamDoiTac> list = new ArrayList<>();
        Connection conn = null;
        try{
            conn = DBConnection.getConnection();
            Statement hd = conn.createStatement();
            String query;
            if(maDT == null){
                query = "exec DanhSachSanPham null";
            }
            else {
                query = "exec DanhSachSanPham ?";
            
            }
            PreparedStatement preparedStatement = conn.prepareStatement(query);
            if(maDT != null){
                preparedStatement.setString(1, maDT);
            }
            ResultSet rs = preparedStatement.executeQuery();
            while(rs.next()){
                String ten = rs.getString("TenSanPham");
                String mota = rs.getString("MoTa");
                int dongia = rs.getInt("DonGia");
                SanPhamDoiTac dt = new SanPhamDoiTac(ten, mota,dongia);
                list.add(dt);
            }
        }catch (SQLException ex) {
            Logger.getLogger(DBController.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
    }
        
        public static ArrayList<SanPhamDoiTac> getSpDoiTac(String maDT, int low, int high){
        ArrayList<SanPhamDoiTac> list = new ArrayList<>();
        Connection conn = null;
        try{
            conn = DBConnection.getConnection();
            Statement hd = conn.createStatement();
            String query;
            if(maDT == null){
                query = "exec LocTheoGia ?,?, null";
            }
            else {
                query = "exec LocTheoGia ?,?,?";
            
            }
            PreparedStatement preparedStatement = conn.prepareStatement(query);
            preparedStatement.setInt(1, low);
            preparedStatement.setInt(2, high);
            if(maDT != null){
                preparedStatement.setString(3, maDT);
            }
            ResultSet rs = preparedStatement.executeQuery();
            while(rs.next()){
                String ten = rs.getString("TenSanPham");
                String mota = rs.getString("MoTa");
                int dongia = rs.getInt("DonGia");
                SanPhamDoiTac dt = new SanPhamDoiTac(ten, mota,dongia);
                list.add(dt);
            }
        }catch (SQLException ex) {
            Logger.getLogger(DBController.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
    }
        
    public static  ArrayList<ChiTietSanPhamChiNhanh> getSanPhamChiNhanh(){
        ArrayList<ChiTietSanPhamChiNhanh> list = new ArrayList<>();
        Connection conn = null;
        try{
            conn = DBConnection.getConnection();
            Statement hd = conn.createStatement();
            ResultSet rs = hd.executeQuery("select sp.*, ct.SoLuongConLai, ct.DonGia, cn.MaCN \n" +
                                            "from SanPham sp, CT_SanPham_ChiNhanh ct, ChiNhanh cn\n" +
                                            "where sp.MaSP = ct.MaSP and cn.MaCN = ct.MaCN \n" +
                                            "and cn.MaDT='DT01'");
            while(rs.next()){
                String MaSP = rs.getString("MaSP");
                String TenSp = rs.getString("TenSanPham");
                String Mota = rs.getString("Mota");
                int soluong = rs.getInt("SoLuongConLai");
                int dongia = rs.getInt("DonGia");
                String MaCN = rs.getString("MaCN");
                
                ChiTietSanPhamChiNhanh model = new ChiTietSanPhamChiNhanh(MaSP, TenSp, Mota, soluong, dongia, MaCN);
                list.add(model);
            }
        }catch (SQLException ex) {
            Logger.getLogger(DBController.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
        return list;
    }

    public static ArrayList<DonHang> getDonHang(String makh) {
        ArrayList<DonHang> list = new ArrayList<>();
        Connection conn = null;
        try{
            conn = DBConnection.getConnection();
            Statement hd = conn.createStatement();
            ResultSet rs = hd.executeQuery("select MaDH, NgayDatHang, TinhTrang, MaTX, HinhThucThanhToan, DiaChiThanhToan, PhiVanChuyen, PhiSanPham ,TongTien from DonDH where MaKH = 'KH01' ");
            while(rs.next()){
                String madh = rs.getString("MaDH");
                String ngaydat = rs.getString("NgayDatHang");
                String tinhtrang = rs.getString("TinhTrang");
                String matx = rs.getString("MaTX");
                String hinhthucthanhtoan = rs.getString("HinhThucThanhToan");
                String diachinhan = rs.getString("DiaChiThanhToan");
                int phivanchuyen = rs.getInt("PhiVanChuyen");
                int phisanpham = rs.getInt("PhiSanPham");
                int tongtien = rs.getInt("TongTien");
                 
                DonHang dh;
                dh = new DonHang(madh, ngaydat, tinhtrang, matx, hinhthucthanhtoan, diachinhan, phivanchuyen, phisanpham, tongtien);
                list.add(dh);
            }
        }catch (SQLException ex) {
            Logger.getLogger(DBController.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
    }
    
     public static ArrayList<DonHang> getAllDonHang() throws SQLException{
        ArrayList<DonHang> list = new ArrayList<>();
        
        Connection conn = DBConnection.getConnection();
        try{
            Statement hd = conn.createStatement();
            ResultSet rs = hd.executeQuery("SELECT * FROM DonDH");
            while(rs.next()){
                String madh = rs.getString("MaDH");
                String ngaydat= rs.getString("NgayDatHang");
                String tinhtrang = rs.getString("TinhTrang");
                String matx = rs.getString("MaTX");
                String hinhthucthanhtoan = rs.getString("HinhThucThanhToan");
                String diachinhan = rs.getString("DiaChiThanhToan");
                int phivanchuyen = rs.getInt("PhiVanChuyen");
                int phisanpham = rs.getInt("PhiSanPham");
                int tongtien = rs.getInt("TongTien");
                
                DonHang dh;
                dh = new DonHang(madh, ngaydat, tinhtrang, matx, hinhthucthanhtoan, diachinhan, phivanchuyen, phisanpham, tongtien);
                list.add(dh);
            }
        }catch (SQLException ex) {
            Logger.getLogger(DBController.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
    }
     
        
    
}
