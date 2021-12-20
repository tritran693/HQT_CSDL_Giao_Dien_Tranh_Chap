/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Class;

/**
 *
 * @author ninhviettient4cbl@gmail.com
 */
public class DonHang {
    private String madh;
    private String ngaydat;
    private String tinhtrang;
    private String matx;
    private String hinhthucthanhtoan;
    private String diachinhan;
    private int phivanchuyen;
    private int phisanpham;
    private int tongtien;

    public int getTongtien() {
        return tongtien;
    }

    public void setTongtien(int tongtien) {
        this.tongtien = tongtien;
    }

    public String getMadh() {
        return madh;
    }

    public void setMadh(String madh) {
        this.madh = madh;
    }

    public String getNgaydat() {
        return ngaydat;
    }

    public void setNgaydat(String ngaydat) {
        this.ngaydat = ngaydat;
    }

    public String getTinhtrang() {
        return tinhtrang;
    }

    public void setTinhtrang(String tinhtrang) {
        this.tinhtrang = tinhtrang;
    }

    public String getMatx() {
        return matx;
    }

    public void setMatx(String matx) {
        this.matx = matx;
    }

    public String getHinhthucthanhtoan() {
        return hinhthucthanhtoan;
    }

    public void setHinhthucthanhtoan(String hinhthucthanhtoan) {
        this.hinhthucthanhtoan = hinhthucthanhtoan;
    }

    public String getDiachinhan() {
        return diachinhan;
    }

    public void setDiachinhan(String diachinhan) {
        this.diachinhan = diachinhan;
    }

    public int getPhivanchuyen() {
        return phivanchuyen;
    }

    public void setPhivanchuyen(int phivanchuyen) {
        this.phivanchuyen = phivanchuyen;
    }

    public int getPhisanpham() {
        return phisanpham;
    }

    public void setPhisanpham(int phisanpham) {
        this.phisanpham = phisanpham;
    }
    
    public DonHang(String madh, String ngaydat, String tinhtrang, String matx, String hinhthucthanhtoan, String diachinhan,int phivanchuyen,int phisanpham,int tongtien) {
        this.madh = madh;
        this.tinhtrang = tinhtrang;
        this.ngaydat = ngaydat;
        this.hinhthucthanhtoan = hinhthucthanhtoan;
        this.matx = matx;
        this.diachinhan = diachinhan;
        this.phivanchuyen = phivanchuyen;
        this.phisanpham = phisanpham;
        this.tongtien = tongtien;
    }
    
    
    public Object[] toArray(){
        return new Object[]{madh, ngaydat, tinhtrang, matx, hinhthucthanhtoan, diachinhan, phivanchuyen, phisanpham, tongtien};
    }
    
}
