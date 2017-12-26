package com.daiktam.ktgiuaky;

import java.io.Serializable;

/**
 * Created by Admin on 22/11/17.
 */

public class Nguoi implements Serializable{
    String maKH,tenKH;
    int kieu;
    int soCu,soMoi;

    public Nguoi(String maKH, String tenKH, int kieu, int soCu, int soMoi) {
        this.maKH = maKH;
        this.tenKH = tenKH;
        this.kieu = kieu;
        this.soCu = soCu;
        this.soMoi = soMoi;
    }

    public String getMaKH() {
        return maKH;
    }

    public void setMaKH(String maKH) {
        this.maKH = maKH;
    }

    public String getTenKH() {
        return tenKH;
    }

    public void setTenKH(String tenKH) {
        this.tenKH = tenKH;
    }

    public int getKieu() {
        return kieu;
    }

    public void setKieu(int kieu) {
        this.kieu = kieu;
    }

    public float getSoCu() {
        return soCu;
    }

    public void setSoCu(int soCu) {
        this.soCu = soCu;
    }

    public float getSoMoi() {
        return soMoi;
    }

    public void setSoMoi(int soMoi) {
        this.soMoi = soMoi;
    }

    public int tinhTien(){
        int t=soMoi-soCu;
        switch (kieu)
        {
            case 1:
                if(t<=50)
                    t= t*1450;
                else
                    if(t<=100)
                        t= t*1500;
                else t= t*1750;
                break;
            case 2:
                if(t<=50)
                    t= t*1550;
                else
                if(t<=100)
                    t= t*1600;
                else t= t*1670;
                break;
            case 3:
                if(t<=50)
                    t= t*1400;
                else
                if(t<=100)
                    t= t*1500;
                else t= t*1550;
                break;
        }
        return t;
    }
    @Override
    public String toString() {
        return "tên: "+tenKH+", số cũ: "+soCu+", số mới: "+soMoi;
    }
}
