/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author vuanh
 */
public class TapChi extends TaiLieu implements TinhAnPham{
    private int thangPH;

    public TapChi() {
    }

    public TapChi(String maTl, String nXB, int soBanPH, int thangPH) {
        super(maTl, nXB, soBanPH);
        this.thangPH = thangPH;
    }

    public int getThangPH() {
        return thangPH;
    }

    public void setThangPH(int thangPH) {
        this.thangPH = thangPH;
    }
    
    @Override
    public int getAnPham() {
        if (super.getSoBanPH()<500) 
            return (int) (super.getSoBanPH()*0.05);
        else 
            return (int) (super.getSoBanPH()*0.1);    
    }
    @Override
    public String toString() {
        return  getMaTl()+ "\t"+ getnXB()+ "\t" + getSoBanPH() +"\t"
                + getThangPH() +"\t"+ getAnPham();
    } 
}
