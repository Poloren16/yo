package models;

public class StudentBuilder extends TableBuilder {

    public StudentBuilder() {
        // (#1.2 Sesuaikan value dari var table dan primaryKey)
        this.table = "Student";
        this.primaryKey = "Id";

        // (#1.3 Sesuaikan isi dari kolom table berdasarkan class Student)
        // dimensi pertama = jumlah kolom
        // dimensi kedua = {nama kolom, tipe data}
        columns = new String[4][];

        columns[0] = new String[]{"Id", "INT"};
        columns[1] = new String[]{"Name", "VARCHAR(50)"};
        columns[2] = new String[]{"Nim", "INT"};
        columns[3] = new String[]{"Class", "VARCHAR(50)"};
    }
}
