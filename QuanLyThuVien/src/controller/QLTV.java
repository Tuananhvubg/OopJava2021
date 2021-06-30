/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Scanner;
import java.util.stream.Collectors;
import model.Sach;
import model.TaiLieu;
import model.TapChi;

/**
 *
 * @author vuanh
 */
public class QLTV implements ChucNang{
    private List<TaiLieu> list;
    private Scanner in;
    public QLTV() {
        list = new ArrayList<>();
        in = new Scanner(System.in);
        list.add(new Sach("A11BC1231", "Kim Dong", 1000, "Toan Tin 12", "Nguyen Van A", 500));
        list.add(new Sach("B12BC1232", "Nha Nam HN", 4000, "Ngu Van 12", "Nguyen Van B", 500));
        list.add(new Sach("C13BC1233", "Kim Dong", 200, "Dia Ly 12", "Nguyen Van A", 500));
        list.add(new TapChi("D14VB1234", "Kim Dong", 800, 6));
        list.add(new TapChi("E15VB1235", "Nha Nam HN ", 100, 5));
        list.add(new TapChi("F16VB1236", "Kim Dong", 200, 4));
        list.add(new TapChi("G17VB1237", "Nha Nam HN", 200, 3));
        list.add(new TapChi("H18VB1238", "Kim Dong", 200, 2));
    }
    private int tonTai(String maTL){
        for (int i=0;i<list.size();i++)
            if (list.get(i).getMaTl().equalsIgnoreCase(maTL)) return i;
        return -1;
    }
    private TaiLieu nhap(){
        String maTL, NXB;
        int sobanPH;
        in = new Scanner(System.in);
        while(true){
            System.out.println("MaTL: " );
            String re="[A-Z]{1}[0-9]{2}[A-Z]{2}[0-9]{4}";
            maTL=in.nextLine().toUpperCase();
            if ((tonTai(maTL)==-1) && maTL.matches(re)) 
                break;
            else 
               System.err.println("Nhap lai");
        }
        System.out.println("NXB: " );
        NXB=in.nextLine();
        System.out.println("So ban PH: " );
        sobanPH=Integer.parseInt(in.nextLine());
        return new TaiLieu(maTL, NXB, sobanPH);
    }
    @Override
    public void nhapSach() {
        TaiLieu tl=nhap();
        String tenSach, tenTG;
        int soTrang;
        System.out.println("tenSach: " );
        tenSach=in.nextLine();
        System.out.println("tenTG: " );
        tenTG=in.nextLine();
        System.out.println("So Trang: " );
        soTrang=Integer.parseInt(in.nextLine());
        list.add(new Sach(tl.getMaTl(), tl.getnXB(), tl.getSoBanPH(), tenSach, tenTG, soTrang));
    }

    @Override
    public void nhapTapChi() {
        TaiLieu tl=nhap();
        int thangPH;
        System.out.println("ThangPH: " );
        thangPH=Integer.parseInt(in.nextLine());
        list.add(new TapChi(tl.getMaTl(), tl.getnXB(), tl.getSoBanPH(), thangPH));
    }

    @Override
    public void inDS() {
        System.out.println("Ma TL      "+"\t"+"NXB       "+"\t"+"SBPH"+"\t"+"ThgPH"+"\t"+"SoAP"+"\t"+"Ten Sach"
                +"\t"+"Ten TG"+"\t     "+"  So Trang");
        for (int i=0;i<list.size();i++){
            System.out.println(list.get(i).toString());
        }
        System.out.println("===================================");
        System.out.println("Tong so tai lieu la: "+ list.size());
    }

    @Override
    public void timKiem() {
        
        System.out.println("Nhap ten NXB('Kim Dong' hoac 'Nha Nam HN'):");
        String NXB=in.nextLine();
        System.out.println("===================================");
        int tong=0;
        System.out.println("Ma TL      "+"\t"+"NXB       "+"\t"+"SBPH"+"\t"+"ThgPH"+"\t"+"SoAP"+"\t"+"Ten Sach"
                +"\t"+"Ten TG"+"\t     "+"  So Trang");
        for (int i=0;i<list.size();i++)
            if (list.get(i).getnXB().equalsIgnoreCase(NXB)){
            System.out.println(list.get(i).toString());
            tong++;
        }
        if (tong==0) System.out.println("Khong co ban ghi nao cua nha xuat ban "+ NXB+"");
    }

    @Override
    public void edit() {
        System.out.println("Nhap ma TL can sua: " );
        String pt=in.nextLine();
        int vitri= -1;
        for (int i=0;i<list.size();i++)
            if (list.get(i).getMaTl().equalsIgnoreCase(pt)){
                vitri=i;
            }
        if (vitri==-1){
            System.out.println("Khong ton tai tai lieu nay\nChon trong danh sach duoi day");
            System.out.println("Ma TL      "+"\t"+"NXB       "+"\t"+"SBPH"+"\t"+"ThgPH"+"\t"+"SoAP"+"\t"+"Ten Sach"
                +"\t"+"Ten TG"+"\t     "+"  So Trang");
            for (int i=0;i<list.size();i++){
                System.out.println(list.get(i).toString());
            }   
        }
        else{
            System.out.println("Nhap ten NXB");
            String nxb=in.nextLine();
            System.out.println("Nhap so ban phat hanh: " );
            int banph=Integer.parseInt(in.nextLine());
            System.out.println("Nhap mau: " );
            list.get(vitri).setnXB(nxb);
            list.get(vitri).setSoBanPH(banph);
            System.out.println("Ban da sua thanh cong" );
        }
    }

    @Override
    public void sobanPHmin() {
        Map<String,TaiLieu> o=list.stream().collect(
                  Collectors.groupingBy(TaiLieu::getnXB,Collectors.
                          collectingAndThen(Collectors.reducing((TaiLieu p1,TaiLieu p2)
                          ->p1.getSoBanPH()<p2.getSoBanPH()?p1:p2),Optional::get)));
          for(Object key:o.keySet())
              System.out.println("NXB:  "+key.toString()+
                      " \nBan Phat Hanh It Nhat:\n"+o.get(key)+"\n=================");
    }
    
}
