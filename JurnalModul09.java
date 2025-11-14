/**
 *
 */
package com.mycompany.jurnalmodul09;

/**
 *
 * @author ASUS
 */


import java.util.Scanner;

public class JurnalModul09 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n;
        do {
            System.out.print("Masukkan jumlah bangun datar : ");
            while (!sc.hasNextInt()) {
                System.out.print("Masukkan angka yang benar: ");
                sc.next();
            }
            n = sc.nextInt();
            if (n < 3) {
                System.out.println("Minimal harus 3 elemen. Coba lagi.");
            }
        } while (n < 3);

        BangunDatar[] arr = new BangunDatar[n];
        sc.nextLine(); // buang newline

        for (int i = 0; i < n; i++) {
            System.out.println();
            System.out.println((i + 1) + ". Lingkaran");
            System.out.println((i + 1) + ". Persegi Panjang");
            System.out.println((i + 1) + ". Segitiga Sama Kaki");
            System.out.print("Pilih tipe bangun datar ke-" + (i + 1) + " (1=Lingkaran, 2=PersegiPanjang, 3=Segitiga): ");

            int tipe;
            while (true) {
                while (!sc.hasNextInt()) {
                    System.out.print("Masukkan 1, 2, atau 3: ");
                    sc.next();
                }
                tipe = sc.nextInt();
                if (tipe >= 1 && tipe <= 3) break;
                System.out.print("Masukkan 1, 2, atau 3: ");
            }
            sc.nextLine(); // buang newline

            System.out.print("Masukkan nama bangun datar: ");
            String nama = sc.nextLine();

            switch (tipe) {
                case 1: // Lingkaran
                    System.out.print("Masukkan jari-jari: ");
                    double r = readPositiveDouble(sc);
                    arr[i] = new Lingkaran(nama, r);
                    break;
                case 2: // Persegi Panjang
                    System.out.print("Masukkan panjang: ");
                    double panjang = readPositiveDouble(sc);
                    System.out.print("Masukkan lebar: ");
                    double lebar = readPositiveDouble(sc);
                    arr[i] = new PersegiPanjang(nama, panjang, lebar);
                    break;
                case 3: // Segitiga sama kaki
                    System.out.print("Masukkan alas: ");
                    double alas = readPositiveDouble(sc);
                    System.out.print("Masukkan tinggi: ");
                    double tinggi = readPositiveDouble(sc);
                    arr[i] = new Segitiga(nama, alas, tinggi);
                    break;
                default:
                    // tidak akan terjadi karena validasi sebelumnya
                    arr[i] = new PersegiPanjang("Unknown", 1, 1);
            }
        }

        // Output: looping dan tampilkan nama, atribut, luas, keliling tiap elemen
        System.out.println("\n--- Hasil ---\n");
        for (int i = 0; i < arr.length; i++) {
            BangunDatar b = arr[i];
            System.out.println("Nama BangunDatar : " + b.getNama());

            if (b instanceof PersegiPanjang) {
                PersegiPanjang p = (PersegiPanjang) b;
                System.out.printf("Panjang          : %.2f%n", p.getPanjang());
                System.out.printf("Lebar            : %.2f%n", p.getLebar());
            } else if (b instanceof Segitiga) {
                Segitiga s = (Segitiga) b;
                System.out.printf("Alas             : %.2f%n", s.getAlas());
                System.out.printf("Tinggi           : %.2f%n", s.getTinggi());
            } else if (b instanceof Lingkaran) {
                Lingkaran l = (Lingkaran) b;
                System.out.printf("Jari-jari        : %.2f%n", l.getJariJari());
            }

            System.out.printf("Luas             : %.2f%n", b.hitungLuas());
            System.out.printf("Keliling         : %.2f%n", b.hitungKeliling());
            System.out.println();
        }

        sc.close();
    }

    private static double readPositiveDouble(Scanner sc) {
        double val;
        while (true) {
            if (sc.hasNextDouble()) {
                val = sc.nextDouble();
                if (val > 0) {
                    sc.nextLine(); // buang sisa baris
                    return val;
                } else {
                    System.out.print("Masukkan nilai positif (>0): ");
                    sc.nextLine();
                }
            } else {
                System.out.print("Masukkan angka yang benar: ");
                sc.next();
            }
        }
    }
}

