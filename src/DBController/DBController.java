/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DBController;

import Class.DoiTac;
import Class.SanPhamDoiTac;
import DBConnection.DBConnection;
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
                
                DoiTac hoadon = new DoiTac(id,ten);
                list.add(hoadon);
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
            if(maDT == "all"){
                query = "select sp.TenSanPham, sp.MoTa, ct.DonGia from CT_SanPham_ChiNhanh ct, SanPham sp where sp.MaSP = ct.MaSP";
            }
            else {
                query = "select sp.TenSanPham, sp.MoTa, ct.DonGia from CT_SanPham_ChiNhanh ct, SanPham sp, ChiNhanh cn, DoiTac dt where sp.MaSP = ct.MaSP and ct.MaCN = cn.MaCN and cn.MaDT = dt.MaDT and dt.TenDoiTac=?";
            
            }
            PreparedStatement preparedStatement = conn.prepareStatement(query);
            if(maDT != "all"){
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
        
    
    
    
}
