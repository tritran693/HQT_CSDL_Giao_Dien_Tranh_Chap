/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Class;

/**
 *
 * @author NVTien
 */
public class TaiXe {
    private String MaTX;
    private String TenTaiXe;
    
    public TaiXe(String MaTX, String TenTaiXe) {
        this.MaTX = MaTX;
        this.TenTaiXe = TenTaiXe;
    }

    public String getMaTX() {
        return MaTX;
    }

    public String getTenTaiXe() {
        return TenTaiXe;
    }

    public void setMaTX(String MaTX) {
        this.MaTX = MaTX;
    }

    public void setTenTaiXe(String TenTaiXe) {
        this.TenTaiXe = TenTaiXe;
    }

    public Object[] toArray() {
        return new Object[]{MaTX, TenTaiXe};
    }
    
}
