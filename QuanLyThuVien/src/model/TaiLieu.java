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
public class TaiLieu {
    private String maTl, nXB;
    private int soBanPH,soAP;

    public TaiLieu() {
    }

    public TaiLieu(String maTl, String nXB, int soBanPH) {
        this.maTl = maTl;
        this.nXB = nXB;
        this.soBanPH = soBanPH;
    }

    public TaiLieu(String maTl, String nXB, int soBanPH, int soAP) {
        this.maTl = maTl;
        this.nXB = nXB;
        this.soBanPH = soBanPH;
        this.soAP = soAP;
    }

    public String getMaTl() {
        return maTl;
    }

    public void setMaTl(String maTl) {
        this.maTl = maTl;
    }

    public String getnXB() {
        return nXB;
    }

    public void setnXB(String nXB) {
        this.nXB = nXB;
    }

    public int getSoBanPH() {
        return soBanPH;
    }

    public void setSoBanPH(int soBanPH) {
        this.soBanPH = soBanPH;
    }

    public int getSoAP() {
        return soAP;
    }

    public void setSoAP(int soAP) {
        this.soAP = soAP;
    }
    public String toString(){
        return maTl+"\t"+nXB+"\t"+soBanPH+"\t"+soAP;
    }
}
