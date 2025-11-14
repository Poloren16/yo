/**
 *
 */
package com.mycompany.jurnalmodul09;


public abstract class BangunDatar {
    protected String nama;

    public BangunDatar(String nama) {
        this.nama = nama;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    // method abstrak untuk perhitungan
    public abstract double hitungLuas();
    public abstract double hitungKeliling();
}

