/**
 *
 */
package com.mycompany.jurnalmodul09;


public class Segitiga extends BangunDatar {
    private double alas;
    private double tinggi;

    public Segitiga(String nama, double alas, double tinggi) {
        super(nama);
        this.alas = alas;
        this.tinggi = tinggi;
    }

    public double getAlas() {
        return alas;
    }

    public void setAlas(double alas) {
        this.alas = alas;
    }

    public double getTinggi() {
        return tinggi;
    }

    public void setTinggi(double tinggi) {
        this.tinggi = tinggi;
    }


    public double hitungLuas() {
        return 0.5 * alas * tinggi;
    }


    public double hitungKeliling() {
        double sisiMiring = Math.sqrt((alas / 2.0) * (alas / 2.0) + tinggi * tinggi);
        return alas + 2 * sisiMiring;
    }
}

