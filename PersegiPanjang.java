/**
 *
 */
package com.mycompany.jurnalmodul09;



public class PersegiPanjang extends BangunDatar {
    private double panjang;
    private double lebar;

    public PersegiPanjang(String nama, double panjang, double lebar) {
        super(nama);
        this.panjang = panjang;
        this.lebar = lebar;
    }

    public double getPanjang() {
        return panjang;
    }

    public void setPanjang(double panjang) {
        this.panjang = panjang;
    }

    public double getLebar() {
        return lebar;
    }

    public void setLebar(double lebar) {
        this.lebar = lebar;
    }


    public double hitungLuas() {
        return panjang * lebar;
    }


    public double hitungKeliling() {
        return 2 * (panjang + lebar);
    }
}

