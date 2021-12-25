/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Class;

/**
 *
 * @author trisu
 */
public class ChiTietSanPhamChiNhanh {
    private String MaSP;
    private String TenSp;
    private String Mota;
    private int soluong;
    private int dongia;
    private String MaCN;

    public ChiTietSanPhamChiNhanh(String MaSP, String TenSp, String Mota, int soluong, int dongia, String MaCN) {
        this.MaSP = MaSP;
        this.TenSp = TenSp;
        this.Mota = Mota;
        this.soluong = soluong;
        this.dongia = dongia;
        this.MaCN = MaCN;
    }

    public String getMaSP() {
        return MaSP;
    }

    public void setMaSP(String MaSP) {
        this.MaSP = MaSP;
    }

    public String getTenSp() {
        return TenSp;
    }

    public void setTenSp(String TenSp) {
        this.TenSp = TenSp;
    }

    public String getMota() {
        return Mota;
    }

    public void setMota(String Mota) {
        this.Mota = Mota;
    }

    public int getSoluong() {
        return soluong;
    }

    public void setSoluong(int soluong) {
        this.soluong = soluong;
    }

    public int getDongia() {
        return dongia;
    }

    public void setDongia(int dongia) {
        this.dongia = dongia;
    }

    public String getMaCN() {
        return MaCN;
    }

    public void setMaCN(String MaCN) {
        this.MaCN = MaCN;
    }
    
    public Object[] toArray() {
        return new Object[]{MaSP, TenSp, Mota, soluong, dongia, MaCN};
    }
}
