/**
 *
 */
package com.mycompany.jurnalmodul09;

public class Lingkaran extends BangunDatar {
    private double jariJari;
    private static final double PI = Math.PI;

    public Lingkaran(String nama, double jariJari) {
        super(nama);
        this.jariJari = jariJari;
    }

    public double getJariJari() {
        return jariJari;
    }

    public void setJariJari(double jariJari) {
        this.jariJari = jariJari;
    }

    public double hitungLuas() {
        return PI * jariJari * jariJari;
    }

    public double hitungKeliling() {
        return 2 * PI * jariJari;
    }
}

