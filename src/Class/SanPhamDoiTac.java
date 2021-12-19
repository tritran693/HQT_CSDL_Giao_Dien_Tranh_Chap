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
public class SanPhamDoiTac {
    private String TenSanPham;
    private String MoTa;
    private int DonGia;

    public SanPhamDoiTac(String TenSanPham, String MoTa, int DonGia) {
        this.TenSanPham = TenSanPham;
        this.MoTa = MoTa;
        this.DonGia = DonGia;
    }

    public String getTenSanPham() {
        return TenSanPham;
    }

    public void setTenSanPham(String TenSanPham) {
        this.TenSanPham = TenSanPham;
    }

    public String getMoTa() {
        return MoTa;
    }

    public void setMoTa(String MoTa) {
        this.MoTa = MoTa;
    }

    public int getDonGia() {
        return DonGia;
    }

    public void setDonGia(int DonGia) {
        this.DonGia = DonGia;
    }
    
    public Object[] toArray() {
        return new Object[]{TenSanPham, MoTa, DonGia};
    }
}
