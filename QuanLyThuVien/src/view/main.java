/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;


import controller.QLTV;
import java.util.Scanner;

/**
 *
 * @author vuanh
 */
public class main {

    public static void main(String[] args) {
        QLTV q=new QLTV();
        while(true){
            System.out.println("========Menu========");
            System.out.println("1. Nhap Sach");
            System.out.println("2. Nhap Tap Chi");
            System.out.println("3. Viet danh sach");
            System.out.println("4. Tim kiem theo ten NXB");
            System.out.println("5. Sua Tai Lieu");
            System.out.println("6. Tai Lieu Co So Phat Hanh Thap Nhat");
            System.out.println("0. Thoat");
            System.out.println("Moi lua chon");
            Scanner in= new Scanner(System.in);
            int chon;
            chon = in.nextInt();
            switch(chon){
                case 0:
                    System.out.println("Tam biet");
                    System.exit(0);
                case 1: 
                    q.nhapSach();
                    break;
                case 2: 
                    q.nhapTapChi();
                    break;
                case 3:
                    q.inDS();
                    break;
                case 4:
                    q.timKiem();
                    break;
                case 5: 
                    q.edit();
                    break;
                case 6: 
                    q.sobanPHmin();
                    break;
            }
        }
    }
    
}
