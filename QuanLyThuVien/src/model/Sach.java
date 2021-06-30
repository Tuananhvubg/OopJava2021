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
public class Sach extends TaiLieu implements TinhAnPham{
    private String tenSach,tenTacGia;
    private int soTrang;

    public Sach() {
    }

    public Sach(String maTl, String nXB, int soBanPH, String tenSach, String tenTacGia, int soTrang) {
        super(maTl, nXB, soBanPH);
        this.tenSach = tenSach;
        this.tenTacGia = tenTacGia;
        this.soTrang = soTrang;
    }

    public String getTenSach() {
        return tenSach;
    }

    public void setTenSach(String tenSach) {
        this.tenSach = tenSach;
    }

    public String getTenTacGia() {
        return tenTacGia;
    }

    public void setTenTacGia(String tenTacGia) {
        this.tenTacGia = tenTacGia;
    }

    public int getSoTrang() {
        return soTrang;
    }

    public void setSoTrang(int soTrang) {
        this.soTrang = soTrang;
    }
  
    @Override
    public int getAnPham() {
        if (super.getSoBanPH()<500) 
            return (int) (super.getSoBanPH()*0.1);
        else 
            return (int) (super.getSoBanPH()*0.2);
    }
    @Override
    public String toString() {
        return  getMaTl()+ "\t"+ getnXB()+ "\t" + getSoBanPH() +"\t        "+ getAnPham()+"\t"
                +getTenSach() + "\t" + getTenTacGia() + "\t" 
                + getSoTrang();
    } 
}
