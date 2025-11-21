/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.jurnalmod10;

/**
 *
 * @author ASUS
 */
import java.util.Scanner;

public class JurnalMod10 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        Mahasiswa m = new Mahasiswa();

        System.out.println("Validator Mahasiswa");

        // === NIM ===
        while (true) {
            System.out.print("NIM: ");
            String nim = in.nextLine();

            try {
                m.setNim(nim);
                System.out.println("NIM valid\n");
                break;
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }

        // === NAMA ===
        while (true) {
            System.out.print("Nama: ");
            String nama = in.nextLine();

            try {
                m.setNama(nama);
                System.out.println("Nama valid\n");
                break;
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }

        // === TANGGAL LAHIR ===
        while (true) {
            System.out.print("Tanggal Lahir (YYYY-MM-dd): ");
            String tgl = in.nextLine();

            try {
                m.setTanggalLahir(tgl);
                System.out.println("Tanggal lahir valid\n");
                break;
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }

        // === IPK ===
        while (true) {
            System.out.print("IPK: ");
            String input = in.nextLine();

            try {
                double nilai = Double.parseDouble(input);
                m.setIpk(nilai);
                System.out.println("IPK valid\n");
                break;
            } catch (NumberFormatException e) {
                System.out.println("IPK harus berupa angka");
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }

        System.out.println("Semoga Selalu diberi kemudahan^^");
    }
}
