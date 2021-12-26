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
public class SanPham {
    private String MaSP;
    private String TenSP;
    private String MoTa;

    public SanPham(String MaSP, String TenSP, String MoTa) {
        this.MaSP = MaSP;
        this.TenSP = TenSP;
        this.MoTa = MoTa;
    }

    public String getMaSP() {
        return MaSP;
    }

    public void setMaSP(String MaSP) {
        this.MaSP = MaSP;
    }

    public String getTenSP() {
        return TenSP;
    }

    public void setTenSP(String TenSP) {
        this.TenSP = TenSP;
    }

    public String getMoTa() {
        return MoTa;
    }

    public void setMoTa(String MoTa) {
        this.MoTa = MoTa;
    }
    
    
    public Object[] toArray() {
        return new Object[]{MaSP, TenSP, MoTa};
    }
}
