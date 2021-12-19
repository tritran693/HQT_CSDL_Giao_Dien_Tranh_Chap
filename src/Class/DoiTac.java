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
public class DoiTac {
    private String MaDT;
    private String TenDoiTac;

    public DoiTac(String MaDT, String TenDoiTac) {
        this.MaDT = MaDT;
        this.TenDoiTac = TenDoiTac;
    }

    public String getMaDT() {
        return MaDT;
    }

    public void setMaDT(String MaDT) {
        this.MaDT = MaDT;
    }

    public String getTenDoiTac() {
        return TenDoiTac;
    }

    public void setTenDoiTac(String TenDoiTac) {
        this.TenDoiTac = TenDoiTac;
    }
    
    public Object[] toArray() {
        return new Object[]{MaDT, TenDoiTac};
    }
}
