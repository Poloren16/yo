/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.jurnalmod10;

/**
 *
 * @author ASUS
 */
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

public class Mahasiswa {
    private String nim;
    private String nama;
    private LocalDate tanggalLahir;
    private double ipk;

    private static final DateTimeFormatter FORMAT = DateTimeFormatter.ofPattern("yyyy-MM-dd");

    public void setNim(String nim) throws Exception {
        if (nim == null || nim.trim().isEmpty()) {
            throw new Exception("NIM tidak boleh kosong");
        }

        // cek semua angka dulu
        for (int i = 0; i < nim.length(); i++) {
            if (!Character.isDigit(nim.charAt(i))) {
                throw new Exception("NIM harus semua angka");
            }
        }

        // setelah yakin semua angka → baru cek panjang
        if (nim.length() != 12) {
            throw new Exception("NIM harus 12 digit");
        }

        this.nim = nim;
    }


    public void setNama(String nama) throws Exception {
        if (nama == null || nama.trim().isEmpty()) {
            throw new Exception("Nama tidak boleh kosong");
        }
        if (nama.length() < 8) {
            throw new Exception("Nama minimal 8 karakter");
        }
        this.nama = nama;
    }

    public void setTanggalLahir(String tanggal) throws Exception {
        try {
            this.tanggalLahir = LocalDate.parse(tanggal, FORMAT);
        } catch (DateTimeParseException e) {
            throw new Exception("Format tanggal harus YYYY-MM-dd");
        }
    }

    public void setIpk(double ipk) throws Exception {
        if (ipk < 0.00 || ipk > 4.00) {
            throw new Exception("IPK antara 0.00-4.00");
        }
        this.ipk = ipk;
    }

    public String getNim() { return nim; }
    public String getNama() { return nama; }
    public LocalDate getTanggalLahir() { return tanggalLahir; }
    public double getIpk() { return ipk; }
}
